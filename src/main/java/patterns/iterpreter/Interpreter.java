package patterns.iterpreter;

import patterns.iterators.IteratorBFS;
import patterns.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {

    public List<Node> returnChildren(IteratorBFS iteratorBFS){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str.contains("return children")){
            String[] arr = str.split(" ");
            String type = arr[2];
            String name = arr[3];
            List<Node> children = new ArrayList<>();
            while (iteratorBFS.hasNext()) {
                Node next = iteratorBFS.next();
                String  nameStr = next.getName();
                String typeStr = next.getType().toString();
                if(nameStr.equals(name) && typeStr.equals(type)){
                    children.addAll(next.getChildren());
                }
            }
            return children;
        }
        return null;
    }

    public void addNode(){

    }

    public void deleteNode(){

    }

    public void saveTree(){

    }
}
