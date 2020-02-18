package patterns;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private Node root;
    private Type type;
    private int prioritet;
    private List<Node> children = new ArrayList<>();

    private Node() {
    }

    void addChild(Node node) {
        children.add(node);
    }

    public String getName() {
        return name;
    }


    public Node getRoot() {
        return root;
    }

    public Type getType() {
        return type;
    }

    public int getPrioritet() {
        return prioritet;
    }


    public List<Node> getChildren() {
        return children;
    }


    static Builder newBuilder() {
        return new Node().new Builder();
    }


    public class Builder {

        private Builder() {
        }

        public Builder setName(String name) {
            Node.this.name = name;
            return this;
        }

        public Builder setRoot(Node root) {
            Node.this.root = root;
            return this;
        }

        public Builder setType(Type type) {
            Node.this.type = type;
            return this;
        }

        public Builder setPrioritet(int prioritet) {
            Node.this.prioritet = prioritet;
            return this;
        }

        public Builder setChildren(List<Node> children) {
            Node.this.children = children;
            return this;
        }

        public Node build() {
            return Node.this;
        }

    }
}