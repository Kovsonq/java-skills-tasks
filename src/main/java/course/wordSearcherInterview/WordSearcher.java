package course.wordSearcherInterview;

import java.util.List;
import java.util.Map;

public interface WordSearcher {
    Map<String,Long> calculateWords(List<String> content, List<String> words, boolean isRegisterMatters);
}
