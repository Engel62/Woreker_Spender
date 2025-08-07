public interface CityEntityFactory {
    Bank createBank(int initialMoney);
    Worker createWorker(int initialMoney);

    Spender createSpender(int initialMoney);

}
