package course.streams.employee;

import lombok.Data;

@Data
public class Worker {
    private String name;
    private int age;
    private double salary;

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
