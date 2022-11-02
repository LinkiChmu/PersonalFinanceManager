import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaxMonthCategoryTest {
    MaxMonthCategory maxMonthCategory;

    @BeforeEach
    void setUp() {
        maxMonthCategory = new MaxMonthCategory(2022, 06);
    }

    @DisplayName("Testing extracting the monthly data from the log ")
    @Test
    void extractDataFromLog() {
        FinanceData financeData = new FinanceData();
        financeData.log = List.of(
                new Purchase(20220627, "быт", 250),
                new Purchase(20221127, "финансы", 250),
                new Purchase(20221025, "еда", 600),
                new Purchase(20220625, "еда", 600),
                new Purchase(20220606, "красота и здоровье", 1100)
        );
        maxMonthCategory.extractDataFromLog(financeData);
        Assertions.assertEquals("красота и здоровье", maxMonthCategory.category);
        Assertions.assertEquals(1100, maxMonthCategory.sum);
    }

}
