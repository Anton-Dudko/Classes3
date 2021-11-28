import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src\\main\\java\\in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useLocale(Locale.ENGLISH);
        final int PURCHASES_NUMBER = scanner.nextInt();
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

        for (int i = 0; i < PURCHASES_NUMBER; i++) {
            purchases[i] = new Purchase(scanner.nextInt(), scanner.nextDouble(), WeekDay.values()[scanner.nextInt()]);
        }

        printPurchases(purchases);

        int totalCost = 0;
        int totalCostMonday = 0;
        int maxCost = 0;
        WeekDay maxCostDay = null;
        double meanCost = 0.000;
        if(PURCHASES_NUMBER != 0){
            for (Purchase p : purchases) {
                int cost = p.getCost();
                totalCost += cost;
                if(p.getWeekDay() == (WeekDay.MONDAY)){
                    totalCostMonday += cost;
                }
                if(cost > maxCost){
                    maxCost = cost;
                    maxCostDay = p.getWeekDay();
                }
            }
            meanCost = totalCost/PURCHASES_NUMBER;
        }

        System.out.printf("Average cost = " + Utils.convert(meanCost)  +
                            "\nTotal cost on Monday = " + Utils.convert(totalCostMonday) +
                            "\nThe day with the maximum purchase cost - " + maxCostDay + "\n");

        Arrays.sort(purchases);
        printPurchases(purchases);

        Purchase purchase = new Purchase(5 ,0,0);
        System.out.println(purchases[Arrays.binarySearch(purchases, purchase)]);


    }

    public static void printPurchases(Purchase[] purchase){
        System.out.println(Purchase.NAME + "; " + Utils.convert(Purchase.PRICE));
        for(Purchase p : purchase){
            System.out.println(p);
        }
    }


}
