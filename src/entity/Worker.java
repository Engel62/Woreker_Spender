package entity;

import simulation.CitySimulation;
import utils.AbstractClient;
import utils.CityConfig;
import utils.RandomSelector;

public class Worker extends AbstractClient {
    private final Object lock = new Object();
    private volatile boolean isWorking = false;
    private final int salary;
    private final int moneyThreshold;

    public Worker(String name, int initialMoney, int salary, int moneyThreshold) {
        super(name, initialMoney);
        this.salary = salary;
        this.moneyThreshold = moneyThreshold;
    }
    public void workFor(Spender spender) {
        synchronized (lock) {
            isWorking = true;
        }
        try {
            Thread.sleep(CityConfig.WORK_TIME);
            money += salary;
            spender.setMoney(spender.getMoney() - salary);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            isWorking = false;
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            if (money >= moneyThreshold) {
                Bank bank = RandomSelector.selectRandom(CitySimulation.banks);
                bank.processClient(this, true);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Поток "+ name + " остановлен");
    }
}
