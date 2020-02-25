package stateMachine;

import stateMachine.task.TaskInterface;

import java.util.HashMap;

public class StateMachine {

    private HashMap<Integer, TaskInterface> tasks;

    public StateMachine() {
        this.tasks = new HashMap<>();
    }

    public void addTask(TaskInterface task) {
        tasks.put(task.getId(), task);
    }


    public TaskInterface getTask(Integer id) {
        return tasks.get(id);
    }
}
