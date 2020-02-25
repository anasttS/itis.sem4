package stateMachine.task;

import lombok.Data;
import stateMachine.parameter.Parameter;
import stateMachine.service.Logger;
import stateMachine.states.State;

import java.io.File;
import java.util.Date;

@Data
public class TaskProxy implements TaskInterface {
    private Task task;
    private Logger logger;

    public TaskProxy(Parameter parameter) {
        this.task = new Task();
        logger = new Logger(new File("logs.txt"));
    }

    public TaskProxy(TaskProxy taskProxy) {
        this.task = taskProxy.task.copy();
        this.logger = taskProxy.logger;
    }

    @Override
    public void up(Parameter parameter) {
        logger.log(new Date() + " " + " up in " + this.toString());
        task.up(parameter);
    }

    @Override
    public void down(Parameter parameter) {
        logger.log(new Date() + " " + " down in " + this.toString());
        task.down(parameter);
    }

    @Override
    public void changeState(State state) {
        logger.log(new Date() + " " + " change state " + this.toString());
        task.changeState(state);
    }

    @Override
    public Integer getId() {
        return task.getId();
    }

    public TaskProxy copy() {
        logger.log(new Date() + " " + "copy " + this.toString());
        return new TaskProxy(this);
    }
}
