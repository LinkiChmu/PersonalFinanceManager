public class MaxYearCategory extends MaximalCategory {
    protected transient int year;

    public MaxYearCategory(int year) {
        super();
        this.year = year;
    }

    @Override
    public void extractDataFromLog(FinanceData financeData) {
        financeData.log.stream()
                .filter(purchase -> (purchase.getDate() / 10_000) == year)
                .forEach(purchase -> {
            this.update(purchase.getCategory(), purchase.getSum());
        });
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
