public class DefaultCityEntityFactory implements CityEntityFactory {
    private static int bankCounter = 1;
    private static int workerCounter = 1;
    private static int spenderCounter = 1;

    @Override
    public Bank createBank(int initialMoney) {
        return new Bank("Банк- " + bankCounter++, initialMoney);
    }

    @Override
    public Worker createWorker(int initialMoney) {
        return new Worker("Трудяга " + workerCounter++, initialMoney, CityConfig.WORKER_SALARY, CityConfig.MONEY_THRESHOLD);
    }

    @Override
    public Spender createSpender(int initialMoney) {
        return new Spender("Транжира " + spenderCounter++, initialMoney);
    }
}
