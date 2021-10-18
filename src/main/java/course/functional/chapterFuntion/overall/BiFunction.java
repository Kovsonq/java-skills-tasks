package course.functional.chapterFuntion.overall;

@FunctionalInterface
public interface BiFunction<T,U,R> {
    R apply(T t, U u);

    default <V> BiFunction<T,U,V> andThen(Function<? super R, ? extends V> after){
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
