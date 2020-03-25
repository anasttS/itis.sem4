package store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.model.Name;

import java.util.Scanner;


@Component
public class Interpreter {

    @Autowired
    private Store store;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String command = scanner.nextLine();
            String[] param = command.split(" ");
            if (!(command.equals("stop"))) {
                switch (param[0]) {
                    case "add":
                        store.add(Name.builder()
                                .name(param[1])
                                .build());
                        break;
                    case "out":
                        store.out();
                        break;
                    default:
                        System.out.println("Such command doesn't exist");
                        break;
                }
            } else {
                flag = false;
            }
        }
    }
}
