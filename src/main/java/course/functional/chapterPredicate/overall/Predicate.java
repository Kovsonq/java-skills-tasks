package course.functional.chapterPredicate.overall;

import java.util.Objects;

/**
 * default method return functional interface objects, whose mehtods can in turn be called down the method chain
 * in this case we can use the chain of calculation
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return t -> test(t) || other.test(t);
    }

    default Predicate<T> and(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return t -> (test(t) && other.test(t));
    }

    default Predicate<T> negate(){
        return t -> !test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef){
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }

    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target){
        Objects.requireNonNull(target);
        return (Predicate<T>) target.negate();
    }

}