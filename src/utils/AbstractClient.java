package utils;

import entity.Client;

public abstract class AbstractClient implements Client, Runnable {
    protected String name;
    protected int money;
    protected volatile boolean isRunning;

    public AbstractClient(String name, int initialMoney) {
        this.name = name;
        this.money = initialMoney;
        this.isRunning = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void setMoney(int amount) {
        this.money = amount;
    }

    public void stop() {
        isRunning = false;
    }
}
