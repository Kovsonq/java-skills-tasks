package course.functional.chapter1.task2;

@FunctionalInterface
public interface Summer<T extends Number> {
    T sum(T x1, T x2);
}
