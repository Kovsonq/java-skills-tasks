package course.functional.chapter1.genericFuntion;

import course.functional.chapter1.staticMethod.GenericInterface;

public class GenericInterfaceTest {

    public static void main(String[] args) {

        GenericInterface<Integer> integerSum = new GenericInterface<Integer>() {
            @Override
            public Integer process(Integer x1, Integer x2) {
                return x1 + x2;
            }
        };

        GenericInterface<Double> doubleMinus = new GenericInterface<Double>() {
            @Override
            public Double process(Double x1, Double x2) {
                return x1 - x2;
            }
        };

        GenericInterface<String> stringSum = new GenericInterface<String>() {
            @Override
            public String process(String x1, String x2) {
                return x1 + x2;
            }
        };

        System.out.println(integerSum.process(2,3));
        System.out.println(doubleMinus.process(2.0, 3.0));
        System.out.println(stringSum.process("2", "3"));
        
    }
}
