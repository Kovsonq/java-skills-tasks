package course.functional.chapter1.stringProcessor;

/**
 * FI can be provided by defining a named class that provides the functional method
 */
public class NamedStringProcessor implements StringProcessor {
    @Override
    public String process(String str){
        return str;
    }
}
