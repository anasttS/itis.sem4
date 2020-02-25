package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Assigned extends State {
    public Assigned(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        getContext().setState(new InProgress(task));
    }

    @Override
    public void down(Parameter parameter) {
        getContext().setDeveloperId(0);
        getContext().setState(new Open(task));
    }

    @Override
    public State copy(Task task) {
        return new Assigned(task);
    }

}
