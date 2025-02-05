import java.util.List;

public class MedicinesFunc {
    public static void text(String text, List<Medicines> list){
        System.out.println("\n" + text);
        for (int i = 0; i < list.size(); i++) {
            Medicines basket = list.get(i);
            double cost = Math.round(basket.getCost() * 100.0) / 100.0;

            if (i == list.size() - 1) {
                System.out.println(cost + " р.");
            }
            else {
                System.out.print(cost + " р, ");
            }
        }
        System.out.println();
    }
}
