package course.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class CollectionRunner {
    public static void main(String[] args) {
        String[] array = {"A","B", "C", "D"};
//        Integer[] array = {1,2,3,4};
        try {
            changePosition(array,0,2);
        } catch (ArrayIndexOutOfBoundsException e){
            log.error("Illegal index for array");
        }

        ArrayList<?> arrayList = castArrayToList(array);
        log.info("{}", arrayList);

    }

    static <T> void changePosition(T[] array, int posOne, int posTwo) {
        if (posOne > array.length || posTwo > array.length){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            T temp = array[posOne];
            array[posOne] = array[posTwo];
            array[posTwo] = temp;
        }
        for (T t : array) {
            log.info("{}", t);
        }
    }

    static <T> ArrayList<T> castArrayToList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
