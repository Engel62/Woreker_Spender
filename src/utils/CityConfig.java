package utils;

public class CityConfig {
    public static long WORK_DAY_DURATION;
    public static long WORK_TIME;
    public static long LUNCH_TIME;
    public static int BANK_COUNT;
    public static int WORKER_COUNT;
    public static int SPENDER_COUNT;
    public static int INITIAL_BANK_MONEY;
    public static int INITIAL_SPENDER_MONEY;
    public static int INITIAL_WORKER_MONEY;
    public static int WORKER_SALARY;
    public static int MONEY_THRESHOLD;

    public static void loadConfig() {
        WORK_DAY_DURATION = 60000;
        WORK_TIME = 2000;
        LUNCH_TIME = 3000;
        BANK_COUNT = 2;
        WORKER_COUNT = 3;
        SPENDER_COUNT = 4;
        INITIAL_BANK_MONEY = 100;
        INITIAL_WORKER_MONEY = 0;
        INITIAL_SPENDER_MONEY = 10;
        WORKER_SALARY = 1;
        MONEY_THRESHOLD = 5;
    }
}
