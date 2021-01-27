package Store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private static ArrayList<Food> listOfMenu = new ArrayList<Food>();
    static Scanner sc = new Scanner(System.in);
    static String response;

    public static Menu getInstance(){
        instance = new Menu();
        return instance;
    }

    private Menu() {
    }

    public static void addFood() throws IOException, InterruptedException {
        Food x = new Food();
        x.CreateDish();
        listOfMenu.add(x);
        showMenu();
        System.out.println("Added Successfully");
        do {
            System.out.print("Add another dish? (y/n):");
            response = sc.next().toLowerCase();
            if(response.equals("y")){
                addFood();
                break;
            }else if (response.equals("n")){
                break;
            }else {
                System.out.println("Invalid input");
                continue;
            }
        }while(true);
    }

    public static void removeFood() throws IOException, InterruptedException {
        Store.clear();
        int foodRemove;
        if(!listOfMenu.isEmpty()) {
            do{
                showMenu();
                System.out.print("Select food to be removed: ");
                foodRemove = Store.validateNumber(sc);
                if(listOfMenu.size() < foodRemove || foodRemove <= 0){
                    System.out.println("Error! There is no food with that number");
                    Store.pressEnter();
                }else break;
            } while (true);
            listOfMenu.remove(foodRemove - 1);
            System.out.println("Removed Successfully");
            Store.pressEnter();
        }else {
            System.out.println("There is no food yet");
            Store.pressEnter();
        }
    }

    public static void showMenu() throws IOException, InterruptedException {
        Store.clear();
        if(!listOfMenu.isEmpty()) {
            for (int i = 0; i < listOfMenu.size(); i++) {
                System.out.printf("%d. Food: %-20sPrice: %-10s\n", i + 1, listOfMenu.get(i).getName(), listOfMenu.get(i).getPrice());
            }
        }else System.out.println("There is no food yet");
    }

    public static ArrayList<Food> getListOfMenu() {
        return listOfMenu;
    }

    public static void editMenu() throws IOException, InterruptedException {
        Store.clear();
        System.out.println("EDIT MENU:\n" +
                "\t\t1. ShowMenu\n" +
                "\t\t2. Add food\n" +
                "\t\t3. Delete food\n" +
                "\t\t4. Go back\n");
        int ans = Store.validateNumber(sc);
        switch (ans){
            case 1:
                showMenu();
                Store.pressEnter();
                break;
            case 2:
                addFood();
                break;
            case 3:
                removeFood();
                break;
            default:
                break;
        }

    }
}

