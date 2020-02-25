package stateMachine.task;

import stateMachine.parameter.Parameter;
import stateMachine.states.State;

public interface TaskInterface {
    void up(Parameter parameter);

    void down(Parameter parameter);

    void changeState(State state);

    Integer getId();

    TaskInterface copy();
}

