package stateMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StateMachine stateMachine = new StateMachine();
        Interpreter interpreter = new Interpreter(stateMachine);
        while (true) {
            String command = scanner.nextLine();
            interpreter.handle(command);
        }
    }
}
