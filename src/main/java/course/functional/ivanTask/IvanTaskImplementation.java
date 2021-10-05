package course.functional.ivanTask;

import java.util.List;
import java.util.stream.Collectors;

public class IvanTaskImplementation {
    public static List<User> aggregate(List<User> values) {
        return values.stream().collect(
                Collectors.groupingBy(User::getLogin, Collectors.summingInt(User::getContributions)))
                .entrySet()
                .stream()
                .map(entry -> new User(entry.getKey(), entry.getValue()))
                .toList();
    }
}
