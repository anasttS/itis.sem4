package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Testing extends State {
    public Testing(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {
        getContext().setState(new Closed(task));
        getContext().setDeveloperId(0);
        getContext().setTesterId(0);
    }

    @Override
    public void down(Parameter parameterString) {
        getContext().setState(new Assigned(task));
        getContext().setError("");
    }

    @Override
    public State copy(Task task) {
        return new Testing(task);
    }

}
