import java.io.Serializable;

public class FinanceStatistics implements Serializable {
    protected MaximalCategory maxCategory;

    public FinanceStatistics(MaximalCategory maxCategory) {
        this.maxCategory = maxCategory;
    }
}
