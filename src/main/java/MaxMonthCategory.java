public class MaxMonthCategory extends MaximalCategory {
    protected transient int yearMonth;

    public MaxMonthCategory(int year, int month) {
        super();
        this.yearMonth = year * 100 + month; //2022 * 100 + 11 = 202211
    }

    @Override
    public void extractDataFromLog(FinanceData financeData) {
        financeData.log.stream()
                .filter(purchase -> (purchase.getDate() / 100) == yearMonth) // 20220631 / 100 = 202206
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
