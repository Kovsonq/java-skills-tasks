package course.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class StreamTest {
    public static void main(String[] args) {
        String[] array = {"lalala","ase","wawws", "pepsi","morkinson",
                "the","the","pepsi","pepsi", "1","2","3","4","5","6","7","8"};
//
//        log.info(Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null));
        ArrayList<String> lala = (ArrayList<String>) Arrays.stream(array)
                .filter(o->o.matches("[1-5]")).collect(Collectors.toList());
        System.out.println(lala);


    }
}
