package course.functional.chapter1.task2;

public class SummerTest {

    public static void main(String[] args) {

        Summer<Integer> sumInt = new Summer<Integer>() {
            @Override
            public Integer sum(Integer x1, Integer x2) {
                return x1+x2;
            }
        };

        Summer<Double> dubSum = new Summer<Double>() {
            @Override
            public Double sum(Double x1, Double x2) {
                return x1+x2;
            }
        };

        Summer<Long> longSum = new Summer<Long>() {
            @Override
            public Long sum(Long x1, Long x2) {
                return x1+x2;
            }
        };

        System.out.println(sumInt.sum(2,3));
        System.out.println(dubSum.sum(2.0, 3.0));
        System.out.println(longSum.sum(2l,3l));
    }
}
