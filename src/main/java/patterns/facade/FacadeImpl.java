package patterns.facade;

import javafx.scene.Node;

public class FacadeImpl implements FacadeInterface {

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
    public void readTree(Node node, String format) {
        if (format.equals("xml")){

        } else if (format.equals("json")){

        }
    }

    @Override
    public void writeTree(Node node, String format) {
        if (format.equals("xml")){

        } else if (format.equals("json")){

        }
    }
}
