package Store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderStatus {
    private static OrderStatus instance;
    private static ArrayList<Customer> listOfCustomer = new ArrayList<Customer>();

    public static OrderStatus getInstance(){
        instance = new OrderStatus();
        return instance;
    }

    private OrderStatus() {
    }

    public static Customer addCustomer(){
        Customer x = new Customer();
        listOfCustomer.add(x);
        return x;
    }

    public static void removeCustomer(Customer customer){
        listOfCustomer.remove(customer);
        System.out.println("Removed Successfully");
    }

    public static void customerPay() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        if(!listOfCustomer.isEmpty()) {
            showCustomers();
            System.out.print("Select customer that is paying: ");
            int payingCustomer = Store.validateNumber(sc) - 1;
            if (!(listOfCustomer.size() - 1 < payingCustomer || payingCustomer < 0)) {
                System.out.println("Paying customer is: " + listOfCustomer.get(payingCustomer).getName());
                System.out.print("Would you like to proceed? (y/n): ");
                String answer = sc.next();
                if (answer.toLowerCase().equals("y")) {
                    Transaction.pay(listOfCustomer.get(payingCustomer));
                } else if (answer.toLowerCase().equals("n")) {
                    customerPay();
                } else System.out.println("Invalid Input");
            } else System.out.println("No customer with that number");
        }else {
            Store.clear();
            System.out.println("There is no customers yet");
        }
    }

    public static void showCustomers() throws IOException, InterruptedException {
        Store.clear();
        if(!listOfCustomer.isEmpty()){
            for (int i = 0; i < listOfCustomer.size(); i++) {
                System.out.printf("%d. Customer: %-10sBalance: %-10s\n", i + 1, listOfCustomer.get(i).getName(), listOfCustomer.get(i).getBalance());
            }
        }else System.out.println("There is no customers yet");
    }

    public static ArrayList<Customer> getListOfCustomer() {
        return listOfCustomer;
    }

    public static void setListOfCustomer(ArrayList<Customer> listOfCustomer) {
        OrderStatus.listOfCustomer = listOfCustomer;
    }
}
