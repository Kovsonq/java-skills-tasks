package course.spring.examplejavaconfig;

import org.springframework.stereotype.Component;

@Component
public interface ClassNameGenerator {
    String generateClassName();
}
