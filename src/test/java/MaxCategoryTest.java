import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MaxCategoryTest {
    MaxCategory maxCategory;

    @BeforeEach
    void setUp() {
        maxCategory = new MaxCategory();
    }

    @DisplayName("Testing addition of a new (not existing) expense to the map")
    @ParameterizedTest
    @MethodSource("getArguments")
    void update(String category, int sum) {
        Assertions.assertEquals(0, maxCategory.expensesByCategory.size());

        maxCategory.update(category, sum);
        Assertions.assertEquals(1, maxCategory.expensesByCategory.size());
        Assertions.assertEquals(sum, maxCategory.expensesByCategory.get(category));

        maxCategory.expensesByCategory.put("быт", 200);
        maxCategory.update(category, sum);
        Assertions.assertEquals(2, maxCategory.expensesByCategory.size());

        Assertions.assertNotNull(maxCategory.category);
        Assertions.assertTrue(maxCategory.sum != 0);
    }
    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of("еда", 100),
                Arguments.of("еда", 1000),
                Arguments.of("еда", 800),
                Arguments.of("другое", 2000),
                Arguments.of("другое", 100),
                Arguments.of("другое", 4000),
                Arguments.of("финансы", 1000)
        );
    }

    @DisplayName("Testing the addition of an already contained expense")
    @ParameterizedTest
    @MethodSource("getArguments2")
    void updateWhenExpenseExists(String category, int sum) {
        Assertions.assertEquals(0, maxCategory.expensesByCategory.size());

        maxCategory.update(category, sum);
        Assertions.assertEquals(1, maxCategory.expensesByCategory.size());
        Assertions.assertEquals(sum, maxCategory.expensesByCategory.get(category));

        maxCategory.expensesByCategory.put("еда", 300);
        maxCategory.update(category, sum);
        Assertions.assertEquals(1, maxCategory.expensesByCategory.size());
        Assertions.assertEquals(1300, maxCategory.expensesByCategory.get(category));

        Assertions.assertNotNull(maxCategory.category);
        Assertions.assertTrue(maxCategory.sum != 0);
    }
    static Stream<Arguments> getArguments2() {
        return Stream.of(
                Arguments.of("еда", 1000),
                Arguments.of("еда", 1000),
                Arguments.of("еда", 1000)
        );
    }

    @DisplayName("Testing the search for the maximum category and set it")
    @Test
    void findAndSetCategory() {
        maxCategory.expensesByCategory.put("еда", 2000);
        maxCategory.expensesByCategory.put("финансы", 8000);
        maxCategory.expensesByCategory.put("другое", 5000);
        maxCategory.findAndSetCategory();

        Assertions.assertEquals("финансы", maxCategory.category);
        Assertions.assertEquals(8000, maxCategory.sum);

    }
}
