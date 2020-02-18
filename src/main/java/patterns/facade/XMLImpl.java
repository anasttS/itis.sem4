package patterns.facade;

import patterns.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Scanner;

public class XMLImpl {

    public Node read(File file) {
        try {
            String str = null;
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            if (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
            return XmlToObject(str);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void write(Node node, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(jaxbObjectToXML(node));
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Node XmlToObject(String string) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Node.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Node) jaxbUnmarshaller.unmarshal(new StringReader(string));
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

    private static String jaxbObjectToXML(Node node) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Node.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(node, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
