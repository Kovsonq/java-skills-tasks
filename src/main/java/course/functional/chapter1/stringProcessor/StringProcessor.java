package course.functional.chapter1.stringProcessor;

/**
 * FI - is an interface with a single abstract method, called its functional method
 * But it can include few non-abstract methods
 * It's ideal for defining a single problem or operation
 */
@FunctionalInterface
public interface StringProcessor {
    String process(String message);

    default void getCurrentTimeInMillis(){
        System.out.println(System.currentTimeMillis());
    }
}
