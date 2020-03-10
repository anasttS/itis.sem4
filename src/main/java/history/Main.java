package history;


import history.helper.Context;
import history.interpreter.Interpreter;
import history.models.Browser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Browser.connection();
        Context.setBrowser(new Browser());
        Interpreter interpreter = new Interpreter(Context.getBrowser());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            interpreter.handle(scanner.nextLine());
        }
    }
}
