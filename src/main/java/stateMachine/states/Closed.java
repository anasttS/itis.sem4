package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Closed extends State {
    public Closed(Task task) {
        super(task);
    }

    @Override
    public void up(Parameter parameter) {

    }

    @Override
    public void down(Parameter parameter) {

    }

    @Override
    public State copy(Task task) {
        return new Closed(task);
    }

}
