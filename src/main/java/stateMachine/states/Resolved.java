package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Resolved extends State {

    public Resolved(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        getContext().setTesterId(parameter.getTesterId());
        getContext().setState(new Testing(task));
    }

    @Override
    public void down(Parameter parameter) {
        getContext().setState(new InProgress(task));
    }

    @Override
    public State copy(Task task) {
        return new Resolved(task);
    }
}
