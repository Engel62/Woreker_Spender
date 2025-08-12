package factory;

import entity.Bank;
import entity.Spender;
import entity.Worker;

public interface CityEntityFactory {
    Bank createBank(int initialMoney);
    Worker createWorker(int initialMoney);

    Spender createSpender(int initialMoney);

}
