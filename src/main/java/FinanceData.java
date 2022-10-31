import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FinanceData {
   private List<Purchase> log;
    private List<Observer> observers;


    public FinanceData() {
        this.observers = new ArrayList<>();
        this.log = new ArrayList<>();   }



    public void addExpense (String category, int sum, String date) {
        log.add(new Purchase(date, category, sum));


    }
}
