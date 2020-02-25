package stateMachine.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter writer;

    public Logger(File file) {
        try {
            this.writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void log(String log) {
        try {
            writer.write(log + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
