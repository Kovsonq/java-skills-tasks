package course.functional.chapter1.task3;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface ListManipulator<T> {
    void manipulate(List<T> list, T element);

    default List<T> create(){
        return new ArrayList<T>();
    }
}
