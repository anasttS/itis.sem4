package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Backlog extends State {
    public Backlog(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        getContext().setState(new Open(task));
    }

    @Override
    public void down(Parameter parameter) {

    }

    @Override
    public State copy(Task task) {
        return new Backlog(task);
    }

}
