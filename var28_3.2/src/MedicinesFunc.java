import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MedicinesFunc {

    public static void text(String text, List<Medicines> list) {
        System.out.println(text);
        for (int i = 0; i < list.size(); i++) {
            Medicines basket = list.get(i);
            double cost = Math.round(basket.getCost() * 100.0) / 100.0;

            if (i == list.size() - 1) {
                System.out.println(cost + " р.");
            } else {
                System.out.print(cost + " р, ");
            }
        }
        System.out.println();
    }

    public static void filterMenu(List<Medicines> basket) {
        while (true) {
            System.out.println("\nФильтрация по видам: " +
                    "\n1) Профилактическая;" +
                    "\n2) Этиотропная;" +
                    "\n3) Симптоматическая;" +
                    "\n4) Заместительная;" +
                    "\n5) Патогенетическая." +
                    "\n6) Выйти.");
            int choice = CheckValue.getInput(1, 6);

            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1 -> {
                    List<Medicines> filtered = basket.stream()
                            .filter(x -> x instanceof Preventive)
                            .collect(Collectors.toList());
                    text("Профилактическая:", filtered);
                }
                case 2 -> {
                    List<Medicines> filtered = basket.stream()
                            .filter(x -> x instanceof Etiotropic)
                            .collect(Collectors.toList());
                    text("Этиотропная:", filtered);
                }
                case 3 -> {
                    List<Medicines> filtered = basket.stream()
                            .filter(x -> x instanceof Symptomatic)
                            .collect(Collectors.toList());
                    text("Симптоматическая:", filtered);
                }
                case 4 -> {
                    List<Medicines> filtered = basket.stream()
                            .filter(x -> x instanceof Substitutive)
                            .collect(Collectors.toList());
                    text("Заместительная:", filtered);
                }
                case 5 -> {
                    List<Medicines> filtered = basket.stream()
                            .filter(x -> x instanceof Pathogenetic)
                            .collect(Collectors.toList());
                    text("Патогенетическая:", filtered);
                }
            }
        }
    }

    public static void skip(List<Medicines> basket) {
        // Получаем максимальное количество элементов в корзине
        int maxSkip = Math.min(basket.size(), 10); // Например, максимальное значение 10 для пропуска
        System.out.println("\nВведите количество элементов для пропуска (1-" + maxSkip + "):");
        int skipCount = CheckValue.getInput(1, maxSkip);

        List<Medicines> listBasket = basket.stream().skip(skipCount).collect(Collectors.toList());
        text("\nПропуск первых " + skipCount + " элементов", listBasket);
    }

    public static void groupingBy(List<Medicines> basket) {
        Map<String, List<Medicines>> listGroup = basket.stream()
                .collect(Collectors.groupingBy(Medicines::getType));
        for (Map.Entry<String, List<Medicines>> entry : listGroup.entrySet()) {
            System.out.println(entry.getKey());
            for (Medicines medicines : entry.getValue()) {
                double cost = Math.round(medicines.getCost() * 100.0) / 100.0;
                System.out.println(cost + " р.");
            }
        }
    }

    public static void toStringList(List<Medicines> basket) {
        System.out.println("Преобразование листа в лист String (только виды лекарств)");
        List<String> stringList = basket.stream().map(Medicines::getType).collect(Collectors.toList());
        for (int i = 0; i < stringList.size(); i++) {
            if (i == stringList.size() - 1) {
                System.out.println(stringList.get(i) + ".\n");
            } else {
                System.out.print(stringList.get(i) + ", ");
            }
        }
    }

    public static void sortMenu(List<Medicines> basket) {
        while (true) {
            System.out.println("\nВыберите способ реализации сортировки счета корзины:\n1) Сортировка Thread;\n2) Сортировка Stream API;\n3) Выйти.");
            int choice = CheckValue.getInput(1, 3);

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1 -> chooseSortingThreadMethod(basket);
                case 2 -> chooseSortingStreamAPIMethod(basket);
            }
        }
    }

    public static void chooseSortingThreadMethod(List<Medicines> basket) {
        while (true) {
            System.out.println("\nВыберите вид сортировки Thread счета корзины:\n1) Сортировка по возрастанию;\n2) Сортировка по убыванию;\n3) Выйти.");
            int choice = CheckValue.getInput(1, 3);

            if (choice == 3) {
                break;
            }

            Runnable sorter = switch (choice) {
                case 1 -> new SortUp(basket);
                case 2 -> new SortDown(basket);
                default -> throw new IllegalArgumentException("Некорректный выбор сортировки");
            };

            Thread sortingThread = new Thread(sorter);
            sortingThread.start();

            try {
                sortingThread.join();
                MedicinesFunc.text("\nСписок лекарств:", basket);
            } catch (InterruptedException e) {
                System.out.println("Сработало исключение InterruptedException.");
            }
        }
    }

    public static void chooseSortingStreamAPIMethod(List<Medicines> basket) {
        while (true) {
            System.out.println("\nВыберите вид сортировки Stream API счета корзины:\n1) Сортировка по возрастанию;\n2) Сортировка по убыванию;\n3) Выйти.");
            int choice = CheckValue.getInput(1, 3);

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1 -> {
                    basket = basket.stream().sorted((s1, s2) -> Double.compare(s1.getCost(), s2.getCost())).collect(Collectors.toList());
                    text("\nСортировка цены лекарств по возрастанию:", basket);
                }
                case 2 -> {
                    basket = basket.stream().sorted((s1, s2) -> Double.compare(s2.getCost(), s1.getCost())).collect(Collectors.toList());
                    text("\nСортировка цены лекарств по убыванию:", basket);
                }
            }
        }
    }
}