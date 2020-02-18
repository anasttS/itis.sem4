package patterns.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import patterns.Node;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class JsonImpl{
    ObjectMapper mapper = new ObjectMapper();

    public Node read(File file) {
        try {
            String str = null;
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            if (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
            return mapper.readValue(str, Node.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void write(Node node, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(mapper.writeValueAsString(node));
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


}
