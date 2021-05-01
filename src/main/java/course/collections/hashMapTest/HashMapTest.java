package course.collections.hashMapTest;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<CustomObject, String> myHashMap = new HashMap<>();

        CustomObject first = new CustomObject("1","1");
        CustomObject second = new CustomObject("2","2");

        myHashMap.put(first, "1");
        myHashMap.put(second, "2");

        second.setSubKeyOne("1");
        second.setSubKeyTwo("1");

        System.out.println(myHashMap.get(first));
        System.out.println(myHashMap.get(second));

        System.out.println(myHashMap.entrySet());
    }
}
