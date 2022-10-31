import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxCategory implements FinanceRequest, Observer {
    protected String category;
    protected int sum;
    protected transient Map<String, Integer> expensesByCategory;

    public MaxCategory() {
        this.expensesByCategory = new HashMap<>();
    }

    @Override
    public void update(String category, int sum) {
        if (expensesByCategory.containsKey(category)) {
            int currSum = expensesByCategory.get(category);
            expensesByCategory.put(category, (currSum + sum));
        } else {
            expensesByCategory.put(category, sum);
        }
        findAndSetCategory();
    }

    @Override
    public void findAndSetCategory() {
        Map.Entry<String, Integer> maxEntry = Collections.max(expensesByCategory.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));
        category = maxEntry.getKey();
        sum = maxEntry.getValue();
    }

    public Map<String, Integer> getExpensesByCategory() {
        return expensesByCategory;
    }
}
