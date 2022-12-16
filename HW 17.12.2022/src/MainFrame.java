import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{

    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> dataList = new JList<>(listModel);
    private final JList<String> listSAX = new JList<>(listModel);
    private final JList<String> listDOM = new JList<>(listModel);

    private JFileChooser fileChooser;
    private final StudentCollection collection = new StudentCollection();

    private JMenu getFileMenu(){
        JMenu fileMenu = new JMenu("Load");
        JMenuItem load = new JMenuItem("Load file");
        load.addActionListener(e -> {
            fileChooser = new JFileChooser(".");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Choose file");
            if (fileChooser.showDialog(null, "Open file") == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    collection.setStudentsFromFile(selectedFile);
                    dataList.setListData(collection.getStudents());
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        fileMenu.add(load);

        JMenuItem saveToXML = new JMenuItem("Save to XML");
        saveToXML.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.saveToXML();
            }
        });
        fileMenu.add(saveToXML);

        return fileMenu;
    }

    private JMenu getReadMenu(){
        JMenu readXmlMenu = new JMenu("Read");

        JMenuItem saxItem = new JMenuItem("SAX");
        saxItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listSAX.setListData(collection.getBySAX());
            }
        });
        readXmlMenu.add(saxItem);

        JMenuItem domItem = new JMenuItem("DOM");
        domItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listDOM.setListData(collection.getByDOM());
            }
        });
        readXmlMenu.add(domItem);

        return readXmlMenu;
    }


    private JMenuBar getBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getFileMenu());
        menuBar.add(getReadMenu());
        return menuBar;
    }

    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500,500);
        setVisible(true);

        setJMenuBar(getBar());

        JPanel listPanel = new JPanel(new GridLayout(1, 3));
        listPanel.add(dataList);
        listPanel.add(listSAX);
        listPanel.add(listDOM);
        add(listPanel);
    }
}
