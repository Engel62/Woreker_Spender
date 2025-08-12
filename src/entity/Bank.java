package entity;

import utils.AbstractClient;
import utils.CityConfig;

public class Bank extends AbstractClient {
    private final Object lock = new Object();
    private volatile boolean isOnLunch = false;

    public Bank(String name, int initialMoney) {
        super(name,initialMoney);
    }

    public void takeLunch(long lunchTime) {
        isOnLunch = true;
        try {
            Thread.sleep(lunchTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        isOnLunch = false;
        }

    public void processClient(Client client, boolean isDeposit) {
        synchronized (lock) {
            if (isDeposit) {
                money += client.getMoney();
                client.setMoney(0);
            } else {
                int amount = 100;
                money -= amount;
                client.setMoney(client.getMoney()+amount);
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            if (Math.random() < 0.1) {
                takeLunch(CityConfig.LUNCH_TIME);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Поток " + name + "остановлен");
    }
}

