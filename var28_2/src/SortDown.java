import java.util.Collections;
import java.util.List;

public class SortDown implements Runnable {
    private List<Medicines> basket;

    public SortDown(List<Medicines> basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        System.out.println("Сортировка цены лекарств по убыванию:");
        Collections.sort(basket, (m1, m2) -> Double.compare(m2.getCost(), m1.getCost()));
    }
}