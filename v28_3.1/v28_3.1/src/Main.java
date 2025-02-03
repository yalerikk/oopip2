import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    static int SIZE = 9;
    public static void main(String[] args) {
        System.out.println("Первый вариант массива");
        ArrayList<Integer> arrayList = new ArrayList<>();
        initArray(arrayList);
        printArray(arrayList);
        List<String> stringArrayList = stringArrayList(arrayList);
        System.out.println("\nПреобразование массива с помощью stream:");
        for (int i = 0; i < stringArrayList.size(); i++) {
            if(i == stringArrayList.size() - 1){
                System.out.println(stringArrayList.get(i) + ".");
            }
            else System.out.print(stringArrayList.get(i) + ", ");
        }
    }

    public static void initArray(ArrayList<Integer> arrayList) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt(16));
        }
    }

    public static void printArray(List<Integer> List) {
        for (int i = 0; i < List.size(); i++) {
            if(i == List.size() - 1){
                System.out.println(List.get(i) + ".");
            }
            else System.out.print(List.get(i) + ", ");
        }
    }

    public static List<String> stringArrayList (ArrayList<Integer> arrayList) {
        return arrayList.stream()
                .sorted((s1,s2) -> s2 - s1)
                .filter(s -> (s%2) == 0).map(String::valueOf).collect(Collectors.toList());
    }
}