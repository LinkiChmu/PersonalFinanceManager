import java.util.*;

public class MaxCategory {
    protected String category;
    protected int sum;
    protected transient Map<String, Integer> expensesByCategory;

    public MaxCategory() {
        this.expensesByCategory = new HashMap<>();
    }


    public void update(String category, int sum) {
        if (expensesByCategory.containsKey(category)) {
            int currSum = expensesByCategory.get(category);
            expensesByCategory.put(category, (currSum + sum));
        } else {
            expensesByCategory.put(category, sum);
        }
        findAndSetCategory();
    }

        public void findAndSetCategory() {
        Map.Entry<String, Integer> maxEntry = Collections.max(expensesByCategory.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));
        category = maxEntry.getKey();
        sum = maxEntry.getValue();
    }

    public void extractDataFromLog (FinanceData financeData) {
        financeData.log.forEach(purchase -> {
            this.update(purchase.getCategory(), purchase.getSum());
        });
    }

     public Map<String, Integer> getExpensesByCategory() {
        return expensesByCategory;
    }
}
