public class CityMedia implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                printReport();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void printReport() {
        int total = 0;
        for (Bank bank : CitySimulation.banks) {
            total+= bank.getMoney();
            System.out.println(bank.getName()+ " количество денег :" + bank.getMoney() + "$");
        }

        for (Worker worker : CitySimulation.workers) {
            total += worker.getMoney();
            System.out.println(worker.getName()+ " количество денег :" + worker.getMoney() + "$");
        }
        for (Spender spender : CitySimulation.spenders) {
            total += spender.getMoney();
            System.out.println(spender.getName()+ " количество денег :" + spender.getMoney() + "$");
        }
        HelpDesk.getInstance().updateTotalMoney(total);
        System.out.println("Good news for everyone! Total amount money in city is: " + total + "$");
    }

}
