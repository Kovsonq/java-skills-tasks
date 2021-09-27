package course.functional.chapter2.task6;

public class SumFromZeroTest {

    public static void main(String[] args) {
        SumFromZero sumFromZero = x -> {
            int sum = 0;
            try {

                for (int i = 1; i <= x; i++) {
                    sum +=i;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Wrong number, not integer: " + x + ". Will return 0.");
            }
            return sum;
        };

        System.out.println(sumFromZero.sumNumbers(10));
    }
}
