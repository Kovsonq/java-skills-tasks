package course.functional.chapter1.staticMethod;

@FunctionalInterface
public interface GenericInterface<X> {

    X process(X x1, X x2);

}
