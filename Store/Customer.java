package Store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name;
    Scanner sc = new Scanner(System.in);
    String ans;
    int balance = 0;

    public void newCustomer() throws IOException, InterruptedException {
        Store.clear();
        if(!Menu.getListOfMenu().isEmpty()) {
            Customer x = OrderStatus.addCustomer();
            System.out.print("Customers name: ");
            x.name = sc.next();
            whatIsYourOrder(x);
            while (true) {
                System.out.println("Additional Order? (y/n)");
                ans = sc.next();
                if (ans.toLowerCase().equals("y")) {
                    whatIsYourOrder(x);
                    continue;
                } else if (ans.toLowerCase().equals("n")) {
                    System.out.println("Customer: " + x.getName());
                    System.out.println("To be paid: " + x.getBalance());
                    break;
                } else {
                    System.out.println("Invalid input. Please try again");
                    continue;
                }
            }
        }else System.out.println("There is no Menu");
    }

    public static void whatIsYourOrder(Customer x) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int customersOrder;
        do{
            Menu.showMenu();
            System.out.println("Customer: " + x.name);
            System.out.print("What is customers order: ");
            customersOrder = Store.validateNumber(sc);
            if (Menu.getListOfMenu().size() < customersOrder || customersOrder <= 0){
                System.out.println("Error! There is no food with that number");
                Store.pressEnter();
            }else{
                break;
            }
        } while (true);
        x.setBalance(x.getBalance() + Menu.getListOfMenu().get(customersOrder - 1).getPrice());
        System.out.println("To be paid: " + x.getBalance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
