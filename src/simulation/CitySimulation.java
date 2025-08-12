package simulation;

import entity.Bank;
import entity.Spender;
import entity.Worker;
import factory.CityEntityFactory;
import factory.DefaultCityEntityFactory;
import utils.CityConfig;
import utils.CityMedia;
import utils.HelpDesk;

import java.util.ArrayList;
import java.util.List;

public class CitySimulation {
    public static List<Bank> banks = new ArrayList<>();
    public static List<Worker> workers = new ArrayList<>();
    public static List<Spender> spenders = new ArrayList<>();

    public static void main(String[] args) {
        CityConfig.loadConfig();
        CityEntityFactory factory = new DefaultCityEntityFactory();
        for (int i = 0; i < CityConfig.BANK_COUNT; i++) {
            banks.add(factory.createBank(CityConfig.INITIAL_BANK_MONEY));
        }
        for (int i = 0; i < CityConfig.WORKER_COUNT; i++) {
            workers.add(factory.createWorker(CityConfig.INITIAL_WORKER_MONEY));
        }
        for (int i = 0; i < CityConfig.SPENDER_COUNT; i++) {
            spenders.add(factory.createSpender(CityConfig.INITIAL_SPENDER_MONEY));
        }
        banks.forEach(b -> new Thread(b).start());
        workers.forEach(w -> new Thread(w).start());
        spenders.forEach(s -> new Thread(s).start());

        Thread mediaThread = new Thread(new CityMedia());
        mediaThread.setDaemon(true);
        mediaThread.start();

        try {
            Thread.sleep(CityConfig.WORK_DAY_DURATION);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        banks.forEach(Bank::stop);
        workers.forEach(Worker::stop);
        spenders.forEach(Spender::stop);

        System.out.println("Good news for everyone! Total amount money in city is: " + HelpDesk.getInstance().getTotalMoney() + "$");
    }
}
