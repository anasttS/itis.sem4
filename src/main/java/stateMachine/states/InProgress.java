package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class InProgress extends State {
    public InProgress(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        getContext().setState(new Resolved(task));
    }

    @Override
    public void down(Parameter parameter) {
        getContext().setState(new Assigned(task));
    }

    @Override
    public State copy(Task task) {
        return new InProgress(task);
    }

}
