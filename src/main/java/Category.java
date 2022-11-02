public interface Category {
    void extractDataFromLog(FinanceData financeData);
    void update(String category, int sum);
    void findAndSetCategory();

}
