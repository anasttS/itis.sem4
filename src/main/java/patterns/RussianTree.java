package patterns;

import patterns.iterators.Tree;
import patterns.iterators.IteratorBFS;
import patterns.iterators.IteratorBFSPriority;
import patterns.iterators.IteratorDFS;
import patterns.iterpreter.Interpreter;

import java.util.*;

public class RussianTree implements Tree {
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

        Node almetevskii =  Node.newBuilder()
                .setName("Almetevskii")
                .setRoot(tatarstan)
                .setType(Type.DISTRICT)
                .setPrioritet(5)
                .build();

        Node gubakhinskii =  Node.newBuilder()
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


        IteratorBFS iteratorBFS = new IteratorBFS(root);
        while (iteratorBFS.hasNext()) {
            System.out.println(iteratorBFS.next().getName());
        }
        iteratorBFS = new IteratorBFS(root);

        IteratorDFS iteratorDFS = new IteratorDFS(root);
        while (iteratorDFS.hasNext()) {
            System.out.println(iteratorDFS.next().getName());
        }

        IteratorBFSPriority iteratorBFSPriority = new IteratorBFSPriority(root);
        while (iteratorBFSPriority.hasNext()) {
            System.out.println(iteratorBFSPriority.next().getName());
        }

        Interpreter interpreter = new Interpreter();
        List<Node> result = interpreter.returnChildren(iteratorBFS);
        for (Node aResult : Objects.requireNonNull(result)) {
            System.out.println(aResult.getName());
        }


    }

    public IteratorBFS createIteratorBFS() {
        return null;
    }

    public IteratorDFS createIteratorDFS() {
        return null;
    }

    public IteratorBFSPriority createIteratorBFSPriority() {
        return null;
    }
}
