package course.spring.examplejavaconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringBean {
    public void doSomething(){
        log.info("Something interesting");
    }
}
