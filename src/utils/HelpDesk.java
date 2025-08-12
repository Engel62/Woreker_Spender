package utils;

public class HelpDesk {
    private static HelpDesk instance;
    private int totalMoney;
    private HelpDesk()
    {}

    public static synchronized HelpDesk getInstance() {
        if (instance == null) {
            instance = new HelpDesk();
        }
        return instance;
    }

    public synchronized void updateTotalMoney(int amount) {
        totalMoney = amount;
    }

    public synchronized int getTotalMoney() {
        return totalMoney;
    }
}
