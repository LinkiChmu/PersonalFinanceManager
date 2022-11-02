public class MaxCategory extends MaximalCategory {

    public MaxCategory() {
        super();
    }

    @Override
    public void extractDataFromLog(FinanceData financeData) {
        financeData.log.forEach(purchase ->
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
