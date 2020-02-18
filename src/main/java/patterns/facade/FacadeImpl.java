package patterns.facade;


import patterns.Node;

import java.io.File;

public class FacadeImpl implements FacadeInterface {
    File file = new File("file.txt");
    static FacadeImpl instance;
    JsonImpl json = new JsonImpl();
    XMLImpl xml = new XMLImpl();

    public static FacadeImpl getInstance() {
        if(instance != null){
        return instance;
        } else{
            return instance = new FacadeImpl();
        }
    }

    private FacadeImpl(){

    }

    @Override
    public Node readTree(String format) {
        if (format.equals("xml")){
           return xml.read(file);
        } else if (format.equals("json")){
            return json.read(file);
        }
        return null;
    }

    @Override
    public void writeTree(patterns.Node node, String format) {
        if (format.equals("xml")){
            xml.write(node, file);
        } else if (format.equals("json")){
            json.write(node, file);
        }
    }
}
