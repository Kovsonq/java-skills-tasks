package course.collections.secondtask;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SorterTest {
    public static void main(String[] args) {
        String[] array = {"alex", "alex", "dima","dima","sony","kasha","hleb","dogle","hleb"};
        Arrays.stream(array).distinct().forEach(log::info);


        Map<String,Integer> counter = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            counter.putIfAbsent(array[i],1);
            for (int j = i+1; j < array.length; j++) {
                if (array[i].equals(array[j])){
                    counter.merge(array[i],1, Integer::sum);
                }
            }
        }
        counter.entrySet().forEach(o->log.info("{}", o));
    }
}