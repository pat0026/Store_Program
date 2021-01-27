package Store;

public class Cashier {
    private static Cashier cashier;
    private static int totalMoney;

    private static Cashier getInstance(){
        cashier = new Cashier();
        return cashier;
    }

    private Cashier(){
    }

    public static int getTotalMoney() {
        return totalMoney;
    }

    public static void setTotalMoney(int totalMoney){
        Cashier.totalMoney = totalMoney;
    }
}
