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
import java.util.ArrayList;

public class XMLRead {
    public static String[] readUsingSAX(){
        ArrayList<String> strings = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler(){
                boolean bGradebook = false, bSurname, bSubject = false, bGrade = false;
                StringBuilder sb  =new StringBuilder();

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                    if (qName.equals("gradebook")) bGradebook = true;
                    if (qName.equals("surname")) bSurname = true;
                    if (qName.equals("subject")) bSubject = true;
                    if (qName.equals("grade")) bGrade = true;
                }

                public void characters(char[] ch, int start, int length) throws SAXException{
                    if (bGradebook){
                        sb.append("Gradebook = ").append(new String(ch, start, length));
                        bGradebook = false;
                    }
                    if (bSurname){
                        sb.append("Surname = ").append(new String(ch, start, length));
                        bSurname = false;
                    }
                    if (bSubject){
                        sb.append("Subject = ").append(new String(ch, start, length));
                        bSubject = false;
                    }
                    if (bGrade){
                        sb.append("Grade = ").append(new String(ch, start, length));
                        bGrade = false;
                    }

                    strings.add(sb.toString());
                }

            };

            parser.parse("file.xml", handler);
        }catch (Exception exception){
            exception.getStackTrace();
        }
        return strings.toArray(new String[0]);
    }

    public static String[] readUsingDOM(){
        ArrayList<String> strings = new ArrayList<>();
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
                    strings.add("Gradebook = " + eElement.getElementsByTagName("gradebook").item(0).getTextContent() + " " +
                    "Surname = " + eElement.getElementsByTagName("surname").item(0).getTextContent() + " " +
                    "Subject = " + eElement.getElementsByTagName("subject").item(0).getTextContent() + " " +
                    "Grade = " + eElement.getElementsByTagName("grade").item(0).getTextContent() + " ");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return strings.toArray(new String[0]);
    }
}
