import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MainFrame a = new MainFrame();
        StudentCollection collection = new StudentCollection();
        collection.setStudentsFromFile(new File("students"));
//        XMLSave.saveToXML(collection);
//        XMLRead.readUsingSAX();
//        System.out.println();
//        XMLRead.readUsingDOM();
    }
}
