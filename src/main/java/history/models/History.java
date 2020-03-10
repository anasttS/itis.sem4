package history.models;

import java.util.Stack;


public class History {
    private Stack<Snapshot> backStack;
    private Stack<Snapshot> forwardStack;

    public History() {
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();
    }

    public void back(Snapshot snapshot) {
        if (!backStack.isEmpty()) {
            forwardStack.add(snapshot);
            backStack.pop().recover();
        } else {
            System.out.println("Empty");
        }
    }

    public void forward(Snapshot snapshot) {
        if (!forwardStack.isEmpty()) {
            backStack.add(snapshot);
            forwardStack.pop().recover();
        } else {
            System.out.println("Empty");
        }
    }

    public void link(Snapshot snapshot) {
        backStack.add(snapshot);
        forwardStack.removeAllElements();
    }

    public void clearHistory() {
        backStack.removeAllElements();
    }
}
