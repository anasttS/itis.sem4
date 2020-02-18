package patterns.iterpreter;

import patterns.Type;
import patterns.iterators.IteratorBFS;
import patterns.Node;
import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    public List<Node> returnChildren(IteratorBFS iteratorBFS, String str) {
        String[] arr = str.split(" ");
        String type = arr[2];
        String name = arr[3];
        List<Node> children = new ArrayList<>();
        while (iteratorBFS.hasNext()) {
            Node next = iteratorBFS.next();
            String nameStr = next.getName();
            String typeStr = next.getType().toString();
            if (nameStr.equals(name) && typeStr.equals(type)) {
                children.addAll(next.getChildren());
            }
        }
        return children;
    }

    public void addNode(IteratorBFS iteratorBFS, String str) {
        if (str.contains("add")) {
            String[] arr = str.split(" ");
            String addressOfRoot = arr[1];
            String name = arr[2];
            String type = arr[3];
            String prioritet = arr[4];
            String[] toRootArr = addressOfRoot.split(",");
            Node next;
            Node root = null;
            int len = toRootArr.length;
            while (iteratorBFS.hasNext()) {
                next = iteratorBFS.next();
                String nameStr = next.getName();
                if (nameStr.equals(toRootArr[len - 1])) {
                    root = next;
                    break;
                } else {
                    System.out.println("Such root doesn't exist");
                }
            }
            Type typeNode = null;
            switch (type) {
                case ("COUNTRY"):
                    typeNode = Type.COUNTRY;
                    break;
                case ("REGION"):
                    typeNode = Type.REGION;
                    break;
                case ("DISTRICT"):
                    typeNode = Type.DISTRICT;
                    break;
                case ("CITY"):
                    typeNode = Type.CITY;
                    break;
                case ("STREET"):
                    typeNode = Type.STREET;
                    break;
                case ("HOUSE"):
                    typeNode = Type.HOUSE;
                    break;
            }

            Node newNode = Node.newBuilder()
                    .setName(name)
                    .setRoot(root)
                    .setType(typeNode)
                    .setPrioritet(Integer.parseInt(prioritet))
                    .build();

            root.addChild(newNode);
        }
    }

    public void deleteNode(IteratorBFS iteratorBFS, String str) {
        String[] arr = str.split(",");
        String name = arr[arr.length - 1];
        Node res = null;
        Node next;

        while (iteratorBFS.hasNext()) {
            next = iteratorBFS.next();
            String nameStr = next.getName();
            if (nameStr.equals(name)){
                res = next;
                break;
            }
        }

        Node root = null;
        if (res != null) {
            root = res.getRoot();
        } else {
            System.out.println("Such node doesn't exist");
        }
        if (root == null){
            res = null;
        } else {
            List<Node> children = root.getChildren();
            children.remove(res);
        }
    }

    public void saveTree(IteratorBFS iteratorBFS, String str) {

    }
}
