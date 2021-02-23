package course.reflection;


import course.reflection.annatations.Column;
import course.reflection.annatations.Table;

@Table(name="worker")
public class TableExample {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

}
