package course.wordSearcherInterview;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordSearcherImpl implements WordSearcher {
    @Override
    public Map<String, Long> calculateWords(List<String> content, List<String> words, boolean isRegisterMatters) {
        if (content.isEmpty()) {
            throw new RuntimeException("Content is empty");
        }

        if (isRegisterMatters) {
            return content.stream()
                    .filter(words::contains)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } else {
            words = words.stream().map(String::toLowerCase).collect(Collectors.toList());
            return content.stream()
                    .map(String::toLowerCase)
                    .filter(words::contains)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }
}
