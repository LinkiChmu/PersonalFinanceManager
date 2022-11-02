import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaxDayCategoryTest {
    MaxDayCategory maxDayCategory;

    @BeforeEach
    void setUp() {
        maxDayCategory = new MaxDayCategory(2022, 11, 02);
    }

    @DisplayName("Testing extracting the daily data from the log")
    @Test
    void extractDataFromLog() {
        FinanceData financeData = new FinanceData();
        financeData.log = List.of(
                new Purchase(20221102, "быт", 250),
                new Purchase(20221102, "финансы", 250),
                new Purchase(20221125, "еда", 600),
                new Purchase(20221102, "еда", 500),
                new Purchase(20221106, "красота и здоровье", 1100)
        );
        maxDayCategory.extractDataFromLog(financeData);
        Assertions.assertEquals("еда", maxDayCategory.category);
        Assertions.assertEquals(500, maxDayCategory.sum);
    }
}
