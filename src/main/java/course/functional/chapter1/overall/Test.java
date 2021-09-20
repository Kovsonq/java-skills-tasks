package course.functional.chapter1.overall;

public class Test {

    public static void main(String[] args) {
        InterfaceExample.method1();

        InterfaceExample objC2 = new C2();
        InterfaceExample objC3 = new C3();
        System.out.println(objC2.method2("hello"));
        System.out.println(objC3.method2("world"));

        InterfaceExample.m1("Hello happy namber is: ");

        InterfaceExample objC4 = new C2();

        System.out.println( objC4.message("Two hundreed or not? : "));
    }
}
