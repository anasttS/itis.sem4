package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Draft extends State {

    public Draft(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        System.out.println("Draft");
        getContext().setState(new Open(task));
    }

    @Override
    public void down(Parameter parameter) {

    }

    @Override
    public State copy(Task task) {
        return new Draft(task);
    }
}
