package store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.model.Name;


import java.util.Set;

@Component
public class InterpreterImpl implements Interpreter {

    @Autowired
    private Store store;

    public void handle(String command) {
        String[] param = command.split(" ");
        switch (param[0]) {
            case "add":
                add(param[1]);
                break;
            case "out":
                System.out.println(out());
                break;
            default:
                System.out.println("Such command doesn't exist");
                break;
        }
    }

    private void add(String name) {
        store.add(Name.builder()
                .name(name)
                .build());
    }

    private Set<Name> out() {
        return store.out();
    }
}
