package course.functional.chapter1.task1;

import java.io.InputStream;

@FunctionalInterface
public interface InputStreamOpener {
    InputStream open(String s);
}
