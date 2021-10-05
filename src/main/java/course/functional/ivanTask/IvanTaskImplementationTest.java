package course.functional.ivanTask;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class IvanTaskImplementationTest {

    @Test
    public void testAggregation() {
        var actual = IvanTaskImplementation.aggregate(List.of(
                new User("Alice", 1), new User("Bob", 3),
                new User("Alice", 2), new User("Bob", 7),
                new User("Charlie", 3), new User("Alice", 5))
        );

        var expected = List.of(
                new User("Bob", 10),
                new User("Alice", 8),
                new User("Charlie", 3));

        Assert.assertEquals("Wrong result", expected, actual);
    }

}