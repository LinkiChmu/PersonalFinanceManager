public class MaxDayCategory extends MaximalCategory {
    protected transient int yearMonthDay;

    public MaxDayCategory(int year, int month, int day) {
        super();
        yearMonthDay = year * 10_000 + month * 100 + day;
    }

    @Override
    public void extractDataFromLog(FinanceData financeData) {
        financeData.log.stream()
                .filter(purchase -> purchase.getDate() == yearMonthDay)
                .forEach(purchase ->
                        this.update(purchase.getCategory(), purchase.getSum())
                );
    }

    @Override
    public void update(String category, int sum) {
        super.update(category, sum);
    }

    @Override
    public void findAndSetCategory() {
        super.findAndSetCategory();
    }
}
