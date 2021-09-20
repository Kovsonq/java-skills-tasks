package course.functional.chapter1.genericFuntion;

public class ThoIntegerTest {

    public static void main(String[] args) {

        TwoInteger twoIntegerMultiple = new TwoInteger() {
            @Override
            public Integer process(Integer x1, Integer x2) {
                return x1*x2;
            }
        };

        TwoInteger twoIntegerPlus = new TwoInteger() {
            @Override
            public Integer process(Integer x1, Integer x2) {
                return x1 + x2;
            }
        };

        TwoInteger twoIntegerMinus = new TwoInteger() {
            @Override
            public Integer process(Integer x1, Integer x2) {
                return x1 - x2;
            }
        };

        System.out.println(twoIntegerMultiple.process(1,2));
        System.out.println(twoIntegerPlus.process(1,2));
        System.out.println(twoIntegerMinus.process(1,2));

    }
}
