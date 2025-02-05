import java.util.Collections;
import java.util.List;

public class SortUp implements Runnable {
    private List<Medicines> basket;

    public SortUp(List<Medicines> basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        System.out.println("Сортировка цены лекарств по возрастанию:");
        Collections.sort(basket, (m1, m2) -> Double.compare(m1.getCost(), m2.getCost()));
    }
}