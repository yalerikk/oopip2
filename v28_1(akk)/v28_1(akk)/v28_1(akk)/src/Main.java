import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Medicines> basket = new ArrayList<>();

    public static void main(String[] args) {

        addMed();

        IMath<Medicines> medicinesCalculator = (List<Medicines> list) -> {
            double totalCost = 0;
            for (Medicines medicine : list) {
                totalCost += medicine.getCost();
            }
            double discountFactor = addBenefits();
            totalCost *= discountFactor;

            // Округление до двух знаков
            totalCost = Math.round(totalCost * 100.0) / 100.0;
            return totalCost;
        };

        double sum = medicinesCalculator.totalCost(basket);
        System.out.println("\nСчет: " + sum);
    }

    public static void addMed() {
        while (true) {
            System.out.println("\nВиды лекарственной терапии:\n1) профилактическая;\n2) этиотропная;" +
                    "\n3) симптоматическая;\n4) заместительная;\n5) патогенетическая.\n\n");
            System.out.println("Выберите вид лекарства или нажмите 6, если корзина собрана:");

            int choice = checkValue.getInput(1, 6);
            if (choice == 6) {
                break;
            }

            double formCost = formOf();
            switch (choice) {
                case 1 -> basket.add(new Preventive(33.5 + formCost));
                case 2 -> basket.add(new Etiotropic(33.9 + formCost));
                case 3 -> basket.add(new Symptomatic(21.7 + formCost));
                case 4 -> basket.add(new Substitutive(11.5 + formCost));
                case 5 -> basket.add(new Pathogenetic(37.9 + formCost));
            }
        }
    }

    public static double formOf() {
        System.out.println("\nФормы лекарства:\n1) жидкая;\n2) твердая;\n3) мягкая;\n4) газообразная.\n" +
                "\nВыберите форму:");
        int form = checkValue.getInput(1, 4);
        return switch (form) {
            case 1 -> -3.3;
            case 2 -> 0;
            case 3 -> -13.3;
            case 4 -> -10.5;
            default -> 0;
        };
    }

    public static double addBenefits() {
        System.out.println("\nУ Вас есть льготы? Выберите:\n1) да;\n2) нет.");
        int choice = checkValue.getInput(1, 2);
        if (choice == 2) {
            return 1; // Нет скидки
        }

        System.out.println("\nВыберите процент скидки:\n1) 100%;\n2) 90%;\n3) 50%.");
        int discountChoice = checkValue.getInput(1, 3);
        return switch (discountChoice) {
            case 1 -> 0; // 100% скидка
            case 2 -> 0.1; // 90% скидка
            case 3 -> 0.5; // 50% скидка
            default -> 1; // по умолчанию
        };
    }
}