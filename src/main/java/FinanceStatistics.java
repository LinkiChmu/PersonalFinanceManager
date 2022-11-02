import java.io.Serializable;

public class FinanceStatistics implements Serializable {
    protected MaxCategory maxCategory;

    public FinanceStatistics(MaxCategory maxCategory) {
        this.maxCategory = maxCategory;
    }
}
