package course.functional.chapter6Funtion.task1;

import lombok.Data;

@Data
public class A {

    Double d;
    String s;
    Integer i;

    public A(Double d, String s, Integer i) {
        this.d = d;
        this.s = s;
        this.i = i;
    }

    @Override
    public String toString() {
        return "A{" +
                "d=" + d +
                ", s='" + s + '\'' +
                ", i=" + i +
                '}';
    }
}
