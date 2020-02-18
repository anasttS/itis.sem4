package patterns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "root")
@JsonIgnoreProperties(value = {"root"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Node {
    @XmlElement(name = "name")
    private String name;
    @XmlTransient
    private Node root;
    @XmlElement(name = "type")
    private Type type;
    @XmlElement(name = "prioritet")
    private int prioritet;
    @XmlElement(name = "children")
    private List<Node> children = new ArrayList<>();

    private Node() {
    }

    public void addChild(Node node) {
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


    public static Builder newBuilder() {
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
