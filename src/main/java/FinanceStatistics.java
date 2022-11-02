import java.io.Serializable;

public class FinanceStatistics implements Serializable {
    protected MaximalCategory maxCategory;
    protected MaximalCategory maxYearCategory;
    protected MaximalCategory maxMonthCategory;
    protected MaximalCategory maxDayCategory;


    public FinanceStatistics(MaximalCategory maxCategory,
                             MaximalCategory maxYearCategory,
                             MaximalCategory maxMonthCategory,
                             MaximalCategory maxDayCategory) {
        this.maxCategory = maxCategory;
        this.maxYearCategory = maxYearCategory;
        this.maxMonthCategory = maxMonthCategory;
        this.maxDayCategory = maxDayCategory;
    }
}
