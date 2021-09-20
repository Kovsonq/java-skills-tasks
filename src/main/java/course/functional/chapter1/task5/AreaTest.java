package course.functional.chapter1.task5;

public class AreaTest {

    public static void main(String[] args) {

        Area triangle = new Area() {
            @Override
            public double compute(double x1, double x2) {
                return (x1 * x2) / 2;
            }
        };

        Area circle = new Area() {
            @Override
            public double compute(double x1, double x2) {
                return x1 * Area.PI * Area.PI;
            }
        };

        Area rectangle = new Area() {
            @Override
            public double compute(double x1, double x2) {
                return x1 * x2;
            }
        };

        System.out.println(triangle.compute(2,5));
        System.out.println(circle.compute(3, 0));
        System.out.println(rectangle.compute(2, 5));

    }
}
