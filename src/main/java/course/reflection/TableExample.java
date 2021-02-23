package course.reflection;


import course.reflection.annatations.Column;
import course.reflection.annatations.Table;

@Table(name="worker")
public class TableExample {

    @Column
    private String name;
    @Column
    private int age;

}
