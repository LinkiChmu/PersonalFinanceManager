import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaxYearCategoryTest {
    MaxYearCategory maxYearCategory;

    @BeforeEach
    void setUp() {
        maxYearCategory = new MaxYearCategory(2021);
    }

    @DisplayName("Testing extracting the data from the log")
    @Test
    void extractDataFromLog() {
        FinanceData financeData = new FinanceData();
        financeData.log = List.of(
                new Purchase(20211027, "быт", 250),
                new Purchase(20211027, "финансы", 250),
                new Purchase(20211025, "еда", 600),
                new Purchase(20221025, "еда", 600),
                new Purchase(20220206, "красота и здоровье", 1100)
        );
        maxYearCategory.extractDataFromLog(financeData);
        Assertions.assertEquals("еда", maxYearCategory.category);
        Assertions.assertEquals(600, maxYearCategory.sum);
    }

}
