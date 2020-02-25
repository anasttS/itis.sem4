package stateMachine.states;

import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

public class Open extends State {

    public Open(Task task) {
        super(task);
    }


    @Override
    public void up(Parameter parameter) {
        getContext().setDeveloperId(parameter.getDeveloperId());
        getContext().setState(new Assigned(task));
    }

    @Override
    public void down(Parameter parameter) {
        getContext().setState(new Backlog(task));
    }

    @Override
    public State copy(Task task) {
        return new Open(task);
    }

}
