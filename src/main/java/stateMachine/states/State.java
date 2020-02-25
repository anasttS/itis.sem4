package stateMachine.states;

import lombok.Data;
import stateMachine.parameter.Parameter;
import stateMachine.task.Task;

abstract public class State {
    protected Task task;

    public Task getContext(){
        return task;
    }

    public State(Task task) {
        this.task = task;
    }

    public abstract void up(Parameter parameter);
    public abstract void down(Parameter parameter);
    public abstract State copy(Task task);



}
