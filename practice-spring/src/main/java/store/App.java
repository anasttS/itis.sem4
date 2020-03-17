package store;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import store.config.Configs;
import store.services.Interpreter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configs.class);
        Interpreter interpreter = context.getBean(Interpreter.class);
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!(command.equals("stop"))){
            interpreter.handle(command);
        }
    }
}
