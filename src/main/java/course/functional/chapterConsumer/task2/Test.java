package course.functional.chapterConsumer.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    private static final ArrayList<Consumer<Number>> consumers = new ArrayList<>();
    private static final Number[] numericWrappers = {new Integer(4), new Double(3), new Float(2), new Long(1)};

    public static void main(String[] args) {
        Consumer<Number> integerConsumer = x -> System.out.println(x.intValue());
        Consumer<Number> doubleConsumer = x -> System.out.println(x.doubleValue());
        Consumer<Number> floatConsumer = x -> System.out.println(x.floatValue());
        Consumer<Number> longConsumer = x -> System.out.println(x.longValue());
        consumers.addAll(List.of(integerConsumer, doubleConsumer, floatConsumer, longConsumer));

        for (int i = 0; i < numericWrappers.length; i++) {
            try {
                for (Consumer<Number> consumer : consumers){
                    consumer.accept(numericWrappers[i]);
                }
            } catch (Exception exception){
                System.out.println("ERROR");
            }
        }
    }
}
