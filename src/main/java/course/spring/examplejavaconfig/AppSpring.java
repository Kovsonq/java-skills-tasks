package course.spring.examplejavaconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class AppSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        springBean.doSomething();

        CodeCreator javaCodeCreator = context.getBean("javaCodeCreator", CodeCreator.class);
        log.info(javaCodeCreator.getClassExample());

    }
}
