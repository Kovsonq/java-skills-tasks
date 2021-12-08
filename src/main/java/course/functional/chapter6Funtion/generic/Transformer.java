package course.functional.chapter6Funtion.generic;

import course.functional.chapter6Funtion.overall.BiFunction;
import course.functional.chapter6Funtion.overall.Function;

public class Transformer {
    private static <T,R> R transform(T t, Function<T, R> function){
        return function.apply(t);
    }

    public static void main(String[] args) {
        Function<String, Integer> fsi = x->Integer.parseInt(x);
        Function<Integer, String> fis = x->Integer.toString(x);

        Integer i = transform("100", fsi);
        String s = transform(200, fis);


        System.out.println(i);
        System.out.println(s);

        System.out.println("---------------After-------------------");
        Function<String, Boolean> fsb = x -> Boolean.parseBoolean(x);
        Function<Boolean,Integer> fbi = x -> x ? 1:0;
        System.out.println(fsb.andThen(fbi).apply("true"));

        System.out.println("---------------Before-------------------");
        Function<Boolean,Integer> fbi2 = x -> x ? 1:0;
        Function<String, Boolean> fsb2 = x -> Boolean.parseBoolean(x);
        System.out.println(fbi2.compose(fsb2).apply("true"));

        System.out.println("---------------Identity-------------------");
        Function<String,String> f = Function.identity();
        System.out.println(f.apply("Identity"));

        System.out.println("---------------BiFunction-------------------");
        BiFunction<Integer,Character,String> bi = (x,z) -> {
            if (Character.isUpperCase(z)){
                return (x%2) == 0 ? "EVEN" : "ODD";
            }
            return (x%2) == 0 ? "even" : "odd";
        };
        System.out.println( bi.apply(3, 'P'));

    }
}
