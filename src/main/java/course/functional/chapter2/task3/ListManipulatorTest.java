package course.functional.chapter2.task3;

import course.functional.chapter1.task3.ListManipulator;

import java.util.ArrayList;
import java.util.List;

public class ListManipulatorTest {

    public static void main(String[] args) {

        ListManipulator<String> sListAdd = (list, element) -> list.add(element);

        ListManipulator<Integer> iListAdd = new ListManipulator<>() {
            @Override
            public void manipulate(List<Integer> list, Integer element) {
                list.add(element);
            }

            @Override
            public List<Integer> create() {
                return new ArrayList<>(50);
            }
        };

        ListManipulator<Integer> iListRmv = new ListManipulator<>() {
            @Override
            public void manipulate(List<Integer> list, Integer element) {
                list.remove(0);
            }

            @Override
            public List<Integer> create() {
                return new ArrayList<>(50);
            }
        };

        List<String> sList = sListAdd.create();
        System.out.println(sList);
        sListAdd.manipulate(sList, "first");
        System.out.println(sList);

        List<Integer> iList = iListAdd.create();
        System.out.println(iList);
        iListAdd.manipulate(iList, 1);
        iListAdd.manipulate(iList, 2);
        iListAdd.manipulate(iList, 3);
        iListAdd.manipulate(iList, 4);
        System.out.println(iList);
        iListRmv.manipulate(iList, null);
        System.out.println(iList);

    }
}
