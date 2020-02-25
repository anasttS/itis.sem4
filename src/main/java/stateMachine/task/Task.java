package stateMachine.task;

import lombok.Data;
import stateMachine.parameter.Parameter;
import stateMachine.states.State;
import stateMachine.states.Draft;

@Data
public class Task implements TaskInterface {
    static Integer generatedId = 0;
    private Integer id;
    private Integer developerId;
    private Integer testerId;
    private String text;
    private String error;
    private State state;

    private static Integer generateId() {
        return generatedId++;
    }

    public Task() {
        this.id = Task.generateId();
        this.state = new Draft(this);
    }

    private Task(Task task) {
        this.developerId = task.developerId;
        this.error = task.error;
        this.testerId = task.testerId;
        this.text = task.text;
        this.state = task.state.copy(this);
        this.id = Task.generateId();
    }

    public Task(String text) {
        this.text = text;
    }

    public void up(Parameter parameter){

        state.up(parameter);
    }

    public void down(Parameter parameter){
        state.down(parameter);
    }

    @Override
    public void changeState(State state) {
        this.state = state;
    }

    public Task copy() {
        return new Task(this);
    }

}
