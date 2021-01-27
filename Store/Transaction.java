package Store;

import java.util.Scanner;

public class Transaction {
    private static int payment;
    private static int change;

    public static void pay(Customer customer){
        Scanner sc = new Scanner(System.in);
        payment = 0;
        change = 0;
        System.out.println("Balance: " + customer.getBalance());
        System.out.print("Input Payment: ");
        while(!sc.hasNextInt()) {
            System.out.println("Error! Must be a number");
            System.out.print("Input Payment: ");
            sc.next();
            }
        payment = sc.nextInt();
        Cashier.setTotalMoney(Cashier.getTotalMoney()+payment);
        int totalBalance = customer.getBalance() - payment;
        if(totalBalance>0){
            customer.setBalance(totalBalance);
            System.out.println("Remaining Balance is Php" + totalBalance);
        }else if(totalBalance<0){
            Cashier.setTotalMoney(Cashier.getTotalMoney() + totalBalance);
            change = Math.abs(totalBalance);
            OrderStatus.removeCustomer(customer);
            System.out.println("Change should be Php" + change);
        }else if(totalBalance==0){
            OrderStatus.removeCustomer(customer);
            System.out.println("Paid exact");
        }
    }
}

