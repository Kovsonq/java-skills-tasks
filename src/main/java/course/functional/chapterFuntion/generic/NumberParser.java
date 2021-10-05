package course.functional.chapterFuntion.generic;

import course.functional.chapterFuntion.overall.Function;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberParser {

    private static <R extends Number> R parse(String s, Function<String, R> function){
        return function.apply(s);
    }

    public static void main(String[] args) {
        java.util.function.Function<String, Integer> example;
        java.util.function.BiFunction<String, Integer,String> example2;
        ArrayList<Function<String, ? extends Number>> list = new ArrayList<>();

        list.add(x->Byte.parseByte(x));
        list.add(x->Short.parseShort(x));
        list.add(x->Integer.parseInt(x));
        list.add(x->Long.parseLong(x));
        list.add(x->Float.parseFloat(x));
        list.add(x->Double.parseDouble(x));

        String[] numbers = {"10", "20", "30", "40", "50", "60"};
        Number[] result = new Number[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = list.get(i).apply(numbers[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
