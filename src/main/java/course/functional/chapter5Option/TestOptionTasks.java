package course.functional.chapter5Option;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class TestOptionTasks {
    public static void main(String[] args) {
        String input = "1 2 3 4 5 6 7 8 9 10";

        UnaryOperator<String> suo = x -> {
            String[] inputArray = x.split(" ");
            String result = "";
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (Integer.parseInt(inputArray[i]) % 2 != 0) {
                    result = result.concat(inputArray[i]).concat(" ");
                }
            }
            return result;
        };
        System.out.println(suo.apply(input));

        IntUnaryOperator bio = x -> (x + 2) * (-4);
        System.out.println(bio.applyAsInt(3));

        BinaryOperator<A> duo = (x, y) -> new A(x.x + y.x, x.y - y.y);
        System.out.println(duo.apply(new A(2,3), new A(5,7)).toString());

        BinaryOperator<Double> dbo = (x,y) -> 2*x + 3*y;
        System.out.println(dbo.andThen(x->x/2).andThen(x->x*5).apply(6.0,3.0));

        UnaryOperator<String> suo2 = x -> x.concat("but from ourselves.");
        System.out.println(suo2
                .andThen(x -> x.replace("from", "in"))
                .andThen(String::toUpperCase)
                .apply("The fault lies not from our stars "));

        List<Car> carList = List.of(new Car("Elantras", 100),
                new Car("Priuses", 100),
                new Car("Odysseys", 100));

        UnaryOperator<Car> carWithDiscount = x -> {
            switch (x.name){
                case "Elantras" -> {
                    return new Car("Elantras", x.price * 0.93);
                }
                case "Priuses" -> {
                    return new Car("Priuses", x.price * 0.9);
                }
                case "Odysseys" -> {
                    return new Car("Odysseys", x.price * 0.95);
                }
                default -> {
                    return  null;
                }
            }
        };

        for (Car car : carList){
            System.out.println(carWithDiscount.apply(car));
        }
    }
}
