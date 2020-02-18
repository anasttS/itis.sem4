package patterns.facade;

import javafx.scene.Node;

public interface FacadeInterface {
    void readTree(Node node, String format);
    void writeTree(Node node, String format);
}
