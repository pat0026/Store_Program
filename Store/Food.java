package Store;

import java.io.IOException;
import java.util.Scanner;

public class Food {
    private String name;
    private int price;
    Scanner sc;

    public void CreateDish() throws IOException, InterruptedException {
        Store.clear();
        Scanner sc = new Scanner(System.in);
        System.out.print("Food: ");
        this.name = sc.nextLine();
        System.out.print("Price: ");
        this.price = Store.validateNumber(sc);
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
