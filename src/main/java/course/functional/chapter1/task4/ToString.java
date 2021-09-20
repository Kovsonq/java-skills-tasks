package course.functional.chapter1.task4;

@FunctionalInterface
public interface ToString<T> {
    String convert(T source);
}
