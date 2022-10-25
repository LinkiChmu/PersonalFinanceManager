import java.util.ArrayList;
import java.util.List;

public class FinanceData implements Notifier {
    private List<Observer> observers;
    private String category;
    private int sum;
    private String date;

    public FinanceData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(category, sum, date);
        }
    }

    public void addExpense (String category, int sum, String date) {
        this.category = category;
        this.sum = sum;
        this.date = date;
        notifyObservers();

    }
}
