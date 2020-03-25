package store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import store.config.Configs;
import store.services.Interpreter;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configs.class);
        Interpreter interpreter = (Interpreter) context.getBean("interpreter");
        interpreter.handle();
    }
}
