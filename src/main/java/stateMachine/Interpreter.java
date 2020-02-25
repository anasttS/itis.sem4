package stateMachine;

import stateMachine.parameter.Parameter;
import stateMachine.task.TaskInterface;
import stateMachine.task.TaskProxy;

public class Interpreter {
    private StateMachine stateMachine;

    public Interpreter(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public void handle(String line) {
        String[] command = line.split("_");
        switch (command[0]) {
            case "copy":
                System.out.println(copy(command[1]));
                break;
            case "up":
                up(command);
                System.out.println("up");
                break;
            case "down":
                down(command);
                System.out.println("down");
                break;
            case "newTask":
                newTask(command);
                System.out.println(command[1]);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }

    private Integer copy(String id) {
        TaskInterface task = stateMachine.getTask(Integer.parseInt(id));
        if (task != null) {
            TaskInterface newTask = task.copy();
            stateMachine.addTask(newTask);
            return newTask.getId();
        } else {
            return -1;
        }
    }

    private void up(String[] command) {
        Parameter parameter = new Parameter();
        helper(command, parameter);
        TaskInterface taskInterface = stateMachine.getTask(Integer.parseInt(command[1]));
        if (taskInterface != null) {
            taskInterface.up(parameter);
        } else {
            System.out.println("No such task");
        }
    }

    private void down(String[] command) {
        Parameter parameter = new Parameter();
        helper(command, parameter);
        stateMachine.getTask(Integer.parseInt(command[1])).down(parameter);
    }

    private void newTask(String[] command) {
        Parameter parameter = Parameter.builder().text(command[1]).build();
        stateMachine.addTask(new TaskProxy(parameter));
    }

    private void helper(String[] command, Parameter parameter ){
        for (int i = 2; i < command.length; i++) {
            String[] parameters = command[i].split(":");
            switch (parameters[0]) {
                case "developerId":
                    parameter.setDeveloperId(Integer.parseInt(parameters[1]));
                    break;
                case "testerId":
                    parameter.setTesterId(Integer.parseInt(parameters[1]));
                    break;
                case "error":
                    parameter.setError(parameters[1]);
                    break;
                case "text":
                    parameter.setText(parameters[1]);
                    break;
            }
        }
    }
}
