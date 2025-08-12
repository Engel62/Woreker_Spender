package entity;

import simulation.CitySimulation;
import utils.AbstractClient;
import utils.RandomSelector;

public class Spender extends AbstractClient {
    public Spender(String name, int initialMoney) {
        super(name, initialMoney);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (money <= 0) {
                // Берем кредит в банке
                Bank bank = RandomSelector.selectRandom(CitySimulation.banks);
                bank.processClient(this, false);
            } else {
                // Наняем работягу
                Worker worker = RandomSelector.selectRandom(CitySimulation.workers);
                worker.workFor(this);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Thread " + name + " has been stopped.");
    }
}