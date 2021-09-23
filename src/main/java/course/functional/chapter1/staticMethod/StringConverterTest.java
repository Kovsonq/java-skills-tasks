package course.functional.chapter1.staticMethod;

public class StringConverterTest {

    public static void main(String[] args) {

        StringProcessor toLowerCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toLowerCase();
            }
        };

        StringProcessor toUpperCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toUpperCase();
            }
        };

        String s = toLowerCase.process("FUNCTIONALINTERFACE");
        System.out.println(s);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(s));

        String t = toUpperCase.process(s);
        System.out.println("\n" + t);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(t));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(t));
    }
}
