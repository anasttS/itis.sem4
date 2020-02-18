package patterns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class Tree {
    @XmlElement(name = "node")
    Node root;

    public Tree(Node root) {
        this.root = root;
    }
}
