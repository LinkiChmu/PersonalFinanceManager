import java.io.Serializable;

public class FinanceStatistics implements Serializable {
    protected Observer maxCategory;

    public FinanceStatistics(Observer observer) {
        this.maxCategory = observer;
    }
}
