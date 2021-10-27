package course.functional.chapterOption;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class OptionTest {
    public static double getOp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value");
        return Double.parseDouble(scanner.nextLine());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String[] ops = {"+", "-", "*", "/", "POW", "ABS", "LOG", "EXP", "SIN", "COS", "TAN", "QUI"};

        DoubleBinaryOperator sum = (x, y) -> x + y;
        DoubleBinaryOperator dif = (x, y) -> x - y;
        DoubleBinaryOperator mul = (x, y) -> x * y;
        DoubleBinaryOperator div = (x, y) -> x / y;
        DoubleBinaryOperator pow = (x, y) -> Math.pow(x, y);
        DoubleUnaryOperator abs = x -> Math.abs(x);
        DoubleUnaryOperator log = x -> Math.log(x);
        DoubleUnaryOperator exp = x -> Math.exp(x);
        DoubleUnaryOperator sin = x -> Math.sin(x);
        DoubleUnaryOperator cos = x -> Math.cos(x);
        DoubleUnaryOperator tan = x -> Math.tan(x);

        boolean done = false;
        while (!done) {
            System.out.println("Select and operation, or press QUI to quit:");
            for (String op : ops) {
                System.out.print(op + ", ");
            }
            System.out.print(":");
            String op = scanner.nextLine();

            switch (op.toUpperCase()) {
                case "+" -> System.out.println(sum.applyAsDouble(getOp(), getOp()));
                case "-" -> System.out.println(dif.applyAsDouble(getOp(), getOp()));
                case "*" -> System.out.println(mul.applyAsDouble(getOp(), getOp()));
                case "/" -> System.out.println(div.applyAsDouble(getOp(), getOp()));
                case "POW" -> System.out.println(pow.applyAsDouble(getOp(), getOp()));
                case "ABS" -> System.out.println(abs.applyAsDouble(getOp()));
                case "LOG" -> System.out.println(log.applyAsDouble(getOp()));
                case "EXP" -> System.out.println(exp.applyAsDouble(getOp()));
                case "SIN" -> System.out.println(sin.applyAsDouble(getOp()));
                case "COS" -> System.out.println(cos.applyAsDouble(getOp()));
                case "TAN" -> System.out.println(tan.applyAsDouble(getOp()));
                case "QUI" -> done = true;
                default -> System.out.println("Invalid operation");
            }
        }
    }
}
