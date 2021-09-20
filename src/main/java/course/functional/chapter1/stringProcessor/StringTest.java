package course.functional.chapter1.stringProcessor;


public class StringTest {

    public static void main(String[] args) {

        NamedStringProcessor namedStringProcessor = new NamedStringProcessor();
        System.out.println(namedStringProcessor.process("String 1"));

        StringProcessor stringProcessor = new StringProcessor() {
            @Override
            public String process(String message) {
                return message.toLowerCase();
            }
        };
        System.out.println(stringProcessor.process("UPPER CASE"));
    }
}
