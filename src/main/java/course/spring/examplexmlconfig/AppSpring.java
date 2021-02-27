package course.spring.examplexmlconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class AppSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myContext.xml");

        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        springBean.doSomething();

        CodeCreator codeCreator = context.getBean("javaCodeCreator", CodeCreator.class);
        log.info(codeCreator.getClassExample());

        CodeCreator cppCodeCreator = context.getBean("cppCodeCreator", CodeCreator.class);
        log.info(cppCodeCreator.getClassExample());

        context.close();
    }
}
