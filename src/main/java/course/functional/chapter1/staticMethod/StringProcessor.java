package course.functional.chapter1.staticMethod;

@FunctionalInterface
public interface StringProcessor {

    String process(String s);

    /**
     * Static method are useful to define helper methods that are not meant to be overridden by implementing classes
     * @param s
     * @return
     */
    static boolean isLowerCase(String s){
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i) {
            result = Character.isLowerCase(s.charAt(i));
        }
        return result;
    }

    static boolean isUpperCase(String s){
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i) {
            result = Character.isUpperCase(s.charAt(i));
        }
        return result;
    }
}
