package com.Accenturebootcamp.fridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fridge {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many products do you want to put in Fridge? ");
    int count = Integer.parseInt(scanner.nextLine());
    Product newFridge[] = new Product[count];
    int FridgeLimit = 3000; // Limit for the total weight of products in Fridge.
    //System.currentTimeMillis();
    for (int i = 0; i < newFridge.length; i++) {
      System.out.print((i + 1) + ". Product name? ");
      String name = scanner.nextLine();
      System.out.print(name + " weight? (grams) ");
      int weight = Integer.parseInt(scanner.nextLine());
      newFridge[i] = new Product(name, weight);
    }

    int sum = 0;
    for (Product arr : newFridge) {
      sum += arr.getWeight();
    }

    do {

      System.out.println("\nProducts in Fridge: "); // Prints the product list
      for (int i = 0; i < newFridge.length; i++) {
        String currentProductInfo = (i + 1) + ". " + newFridge[i].GetInformation();
        System.out.println(currentProductInfo);
      }

      if (sum > FridgeLimit) {
        System.out.print("\nThe products weight is " + (sum - FridgeLimit) + " grams "
            + "over the total weight of Fridge limit! " + "\nType the number of the product you wan't to remove: ");
        int x = Integer.parseInt(scanner.nextLine());
        sum = sum - newFridge[x - 1].getWeight();
        scanner.close();
        List<Product> list = new ArrayList<>(Arrays.asList(newFridge));
        list.remove(x - 1);
        newFridge = list.toArray(new Product[list.size()]);
      }
    } while (sum > FridgeLimit);
    newFridge[55] = new Product("tests", 15, 13);
    System.out.println();
    System.out.println("Products in Fridge: "); // Prints the product list
    for (int i = 0; i < newFridge.length; i++) {
      System.out.println((i + 1) + ". " + newFridge[i].GetInformation());
    }

    System.out.println();
    System.out.println("Total weight of products in Fridge: " + sum + " grams");
  }
}
