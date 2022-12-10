import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class XMLRead {
    public static void readUsingSAX(){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler(){
                boolean bGradebook = false, bSurname, bSubject = false, bGrade = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                    System.out.println("Start element = " + qName);
                    if (qName.equals("gradebook")) bGradebook = true;
                    if (qName.equals("surname")) bSurname = true;
                    if (qName.equals("subject")) bSubject = true;
                    if (qName.equals("grade")) bGrade = true;
                }

                public void endElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                    System.out.println("Start element = " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException{
                    if (bGradebook){
                        System.out.println("Gradebook = " + new String(ch, start, length));
                        bGradebook = false;
                    }
                    if (bSurname){
                        System.out.println("Surname = " + new String(ch, start, length));
                        bSurname = false;
                    }
                    if (bSubject){
                        System.out.println("Subject = " + new String(ch, start, length));
                        bSubject = false;
                    }
                    if (bGrade){
                        System.out.println("Grade = " + new String(ch, start, length));
                        bGrade = false;
                    }
                }
            };
            parser.parse("file.xml", handler);
        }catch (Exception exception){
            exception.getStackTrace();
        }
    }

    public static void readUsingDOM(){
        try{
            File file = new File("file.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Student");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;
                    System.out.print("Gradebook = " + eElement.getElementsByTagName("gradebook").item(0).getTextContent() + " ");
                    System.out.print("Surname = " + eElement.getElementsByTagName("surname").item(0).getTextContent() + " ");
                    System.out.print("Subject = " + eElement.getElementsByTagName("subject").item(0).getTextContent() + " ");
                    System.out.print("Grade = " + eElement.getElementsByTagName("grade").item(0).getTextContent() + " ");
                }
                System.out.println();
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
