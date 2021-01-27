package Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) throws IOException, InterruptedException {
        Customer x = new Customer();
        Scanner sc = new Scanner(System.in);
        boolean open = true;
        int response;

        while (open) {
            clear();
            System.out.println("Welcome to our Store!\n" +
                    "\t\t1. Edit Menu\n" +
                    "\t\t2. Add a customer\n" +
                    "\t\t3. Balance status of customers\n" +
                    "\t\t4. Customer payment\n" +
                    "\t\t5. Cashier\n" +
                    "\t\t6. Quit");
            response = validateNumber(sc);
            switch (response) {
                case 1:
                    Menu.editMenu();
                    break;
                case 2:
                    x.newCustomer();
                    pressEnter();
                    break;
                case 3:
                    OrderStatus.showCustomers();
                    pressEnter();
                    break;
                case 4:
                    OrderStatus.customerPay();
                    pressEnter();

                    break;
                case 5:
                    clearAndPrintCode("Total money for today: " + Cashier.getTotalMoney());
                    break;
                case 6:
                    clearAndPrintCode("Good Job! Let's rest for the day");
                    open = false;
                    clear();
                    break;
                default:
                    clearAndPrintCode("Invalid input!");
                    pressEnter();
            }

        }

    }

    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void pressEnterContinue() throws IOException {
        System.out.print("Press Enter to Continue:");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
    }

    public static void pressEnter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Enter to Continue");
        String text = sc.nextLine();
    }
    public static void clearAndPrintCode(String x) throws IOException, InterruptedException {
        clear();
        System.out.println(x);
        pressEnter();
    }

    public static int validateNumber(Scanner sc){
        boolean valid = false;
        while(!sc.hasNextInt()){
            System.out.print("Error! Numbers only: ");
            sc.next();
        }
        return sc.nextInt();
    }
}