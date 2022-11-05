import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BusinessFrame extends JFrame {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> showArea = new JList<>(listModel);

    private ArrayList<Security> securities;
    private ArrayList<Saleman> salemen;

    private ResFram resFram;

    private JFileChooser fileChooser = new JFileChooser();

    private final Business<Employee> business = new Business();

    private JMenu createSortMenu(){
        JMenu sortMenu = new JMenu("Sort");

        JMenuItem sortSalarySec = new JCheckBoxMenuItem("Salary security");
        sortSalarySec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFram = new ResFram(Business.getArrOfPeople(Business.getBySalary(securities)));
                resFram.setSize(500,500);
                resFram.setVisible(true);
            }
        });

        JMenuItem sortSalarySale = new JCheckBoxMenuItem("Salary salemen");
        sortSalarySale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFram = new ResFram(Business.getArrOfPeople(Business.getBySalary(salemen)));
                resFram.setSize(500,500);
                resFram.setVisible(true);
            }
        });

        JMenuItem sortCoefficientSec = new JCheckBoxMenuItem("Coefficinte");
        sortCoefficientSec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFram = new ResFram(Business.getArrOfPeople(Business.getByCoefficient(securities)));
                resFram.setSize(500,500);
                resFram.setVisible(true);
            }
        });

        JMenuItem sortCoefficientSale = new JCheckBoxMenuItem("Coefficinte saleman");
        sortCoefficientSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFram = new ResFram(Business.getArrOfPeople(Business.getBySalary(salemen)));
                resFram.setSize(500,500);
                resFram.setVisible(true);
            }
        });


        sortMenu.add(sortSalarySec);
        sortMenu.add(sortSalarySale);
        sortMenu.add(sortCoefficientSec);
        sortMenu.add(sortCoefficientSale);

        return sortMenu;
    }

    private JMenu loadMenu(){
        JMenuItem loadStudents = new JMenuItem("Load saleman");
        loadStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        salemen = new ArrayList<>(FillClass.getSalemanFromFile(fileChooser.getSelectedFile()));
                        showArea.setListData(Business.getArrOfPeople(salemen));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenuItem loadNumbers = new JMenuItem("Load security");
        loadNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        securities = new ArrayList<>(FillClass.getSecurityFromFile(fileChooser.getSelectedFile()));
                        showArea.setListData(Business.getArrOfPeople(securities));

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenu loadMenu = new JMenu("Load");
        loadMenu.add(loadStudents);
        loadMenu.add(loadNumbers);

        return loadMenu;
    }

    public BusinessFrame(){
        setLayout(new GridLayout(1,1));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createSortMenu());
        menuBar.add(loadMenu());

        add(showArea);
    }

}
