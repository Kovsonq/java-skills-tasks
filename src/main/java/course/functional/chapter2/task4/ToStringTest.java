package course.functional.chapter2.task4;

import course.functional.chapter1.task4.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToStringTest {

    public static void main(String[] args) {

        ToString<List<String>> l2s = source -> {
            String commaString = "";

            for (String s : source){
                commaString = commaString.concat(s).concat(", ");
            }
            commaString = commaString.substring(0, commaString.length()-2);
            return commaString;
        };

        ToString<Map<String, Integer>> m2s = source -> {
            String colonString = "";

            for (Map.Entry<String, Integer> s : source.entrySet()){
                colonString = colonString.concat(s.getKey()).concat(":").concat(s.getValue().toString()).concat(", ");
            }
            colonString = colonString.substring(0, colonString.length()-2);
            return colonString;
        };

        System.out.println(l2s.convert(Arrays.asList("yam", "no", "hi", "by")));

        Map<String,Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(m2s.convert(map));

    }

}
