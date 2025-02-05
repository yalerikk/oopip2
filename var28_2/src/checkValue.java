import java.util.Scanner;

public class checkValue {
    static Scanner sca = new Scanner(System.in);
    public static int getInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(sca.nextLine());
                if (input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.out.println("\nВведите корректное значение!");
            }
        }
    }
}
