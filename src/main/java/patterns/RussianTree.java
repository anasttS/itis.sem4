package patterns;

import patterns.iterators.IteratorBFS;
import patterns.iterators.IteratorBFSPriority;
import patterns.iterators.IteratorDFS;
import patterns.iterpreter.Interpreter;

import java.util.*;

public class RussianTree {
    public static void main(String[] args) {

        Node root = Node.newBuilder()
                .setName("Russia")
                .setType(Type.COUNTRY)
                .setPrioritet(1)
                .build();

        Node tatarstan = Node.newBuilder()
                .setName("Tatarstan")
                .setRoot(root)
                .setType(Type.REGION)
                .setPrioritet(1)
                .build();

        Node perm = Node.newBuilder()
                .setName("Perm")
                .setRoot(root)
                .setType(Type.REGION)
                .setPrioritet(2)
                .build();

        Node almetevskii = Node.newBuilder()
                .setName("Almetevskii")
                .setRoot(tatarstan)
                .setType(Type.DISTRICT)
                .setPrioritet(5)
                .build();

        Node gubakhinskii = Node.newBuilder()
                .setName("Gubakhinskii")
                .setRoot(perm)
                .setType(Type.DISTRICT)
                .setPrioritet(10)
                .build();

        Node almetevsk = Node.newBuilder()
                .setName("Almetevsk")
                .setRoot(almetevskii)
                .setType(Type.CITY)
                .setPrioritet(1)
                .build();

        Node gubakha = Node.newBuilder()
                .setName("Gubakha")
                .setRoot(gubakhinskii)
                .setType(Type.CITY)
                .setPrioritet(12)
                .build();

        Node lenina = Node.newBuilder()
                .setName("Lenina")
                .setRoot(almetevsk)
                .setType(Type.STREET)
                .setPrioritet(1)
                .build();

        Node druzhby = Node.newBuilder()
                .setName("Druzhby")
                .setRoot(gubakha)
                .setType(Type.STREET)
                .setPrioritet(6)
                .build();

        Node house1 = Node.newBuilder()
                .setName("149")
                .setRoot(lenina)
                .setType(Type.HOUSE)
                .setPrioritet(149)
                .build();

        Node house2 = Node.newBuilder()
                .setName("23")
                .setRoot(druzhby)
                .setType(Type.HOUSE)
                .setPrioritet(23)
                .build();

        root.addChild(tatarstan);
        root.addChild(perm);

        tatarstan.addChild(almetevskii);
        perm.addChild(gubakhinskii);

        almetevskii.addChild(almetevsk);
        gubakhinskii.addChild(gubakha);

        almetevsk.addChild(lenina);
        gubakha.addChild(druzhby);

        lenina.addChild(house1);
        druzhby.addChild(house2);


        Interpreter interpreter = new Interpreter();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.contains("return children")) {
            List<Node> result = interpreter.returnChildren(createIteratorBFS(root), str);
            for (Node aResult : result) {
                System.out.println(aResult.getName());
            }
        }

        if (str.contains("add")) {
            interpreter.addNode(createIteratorBFS(root), str);
            IteratorBFS iteratorBFS = createIteratorBFS(root);
            while (iteratorBFS.hasNext()) {
                System.out.println(iteratorBFS.next().getName());
            }
            createIteratorDFS(root);
        }

        if (str.contains("delete")){
            interpreter.deleteNode(createIteratorBFS(root), str);
            IteratorBFS iteratorBFS = createIteratorBFS(root);
            while (iteratorBFS.hasNext()) {
                System.out.println(iteratorBFS.next().getName());
            }
            createIteratorDFS(root);
        }

        if (str.contains("save")){
            interpreter.saveTree(createIteratorBFS(root), str);
            IteratorBFS iteratorBFS = createIteratorBFS(root);
            while (iteratorBFS.hasNext()) {
                System.out.println(iteratorBFS.next().getName());
            }
            createIteratorDFS(root);
        }



    }

    public static IteratorBFS createIteratorBFS(Node root) {
        return new IteratorBFS(root);
    }

    public static IteratorDFS createIteratorDFS(Node root) {
        return new IteratorDFS(root);
    }

    public static IteratorBFSPriority createIteratorBFSPriority(Node root) {
        return new IteratorBFSPriority(root);
    }
}
