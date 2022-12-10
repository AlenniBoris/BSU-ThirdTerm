import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLSave {
    public static void saveToXML(StudentCollection collection){
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dom = builder.newDocument();

            Element root = dom.createElement("Students");
            dom.appendChild(root);

            for (Student student: collection.getListStudents()){
                Element childRoot = dom.createElement("Student");
                root.appendChild(childRoot);
                //Gradebook
                Element gradebook = dom.createElement("gradebook");
                gradebook.setTextContent(Integer.toString(student.getGradebook()));
                //Surname
                Element surname = dom.createElement("surname");
                surname.setTextContent(student.getSurname());
                //Subject
                Element subject = dom.createElement("subject");
                subject.setTextContent(student.getSubject());
                //Grade
                Element grade = dom.createElement("grade");
                grade.setTextContent(Integer.toString(student.getGrade()));

                childRoot.appendChild(gradebook);
                childRoot.appendChild(surname);
                childRoot.appendChild(subject);
                childRoot.appendChild(grade);
            }

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.transform(new DOMSource(dom), new StreamResult(new File("file.xml")));
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
