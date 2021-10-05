package course.functional.chapterFuntion.task1;

import lombok.Data;

@Data
public class B {

    Double a;
    String b;
    String c;

    public B(Double a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
