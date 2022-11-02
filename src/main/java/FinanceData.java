import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FinanceData {
   protected List<Purchase> log;


    public FinanceData() {
        this.log = new ArrayList<>();
    }



    public void logExpense (String date, int sum, String category) {
        log.add(new Purchase(date, category, sum));
    }

    public List<Purchase> getLog() {
        return log;
    }
}
