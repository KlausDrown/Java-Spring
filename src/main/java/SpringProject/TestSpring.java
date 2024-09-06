package SpringProject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            NameBean nameBean = context.getBean("nameBean", NameBean.class);
            System.out.println(nameBean.getAge());
            System.out.println(nameBean.getName());

            context.close();
    }
}
