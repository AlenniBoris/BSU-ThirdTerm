package KP_Test_Var;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {


    private JMenu loadMenu(){
        JMenuItem loadStudents = new JMenuItem("Load students");
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
                        students = new MyCollection<>(FillClass.getStudentsFromFile(fileChooser.getSelectedFile()));
                        studentsList.setListData(students.toArray());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenuItem loadNumbers = new JMenuItem("Load numbers");
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
                        numbers = new MyCollection<>(FillClass.getFloatsFromFile(fileChooser.getSelectedFile()));
                        numbersList.setListData(numbers.toArray());
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

    private JFileChooser fileChooser;
    private MyCollection<Student> students;
    private MyCollection<Float> numbers;

    private JMenuBar menuBar = new JMenuBar();

    private JPanel studentsPanel = new JPanel();
    private JList studentsList = new JList();
    private JPanel btnsStudents = new JPanel(new GridLayout(1,2));
    private JButton maxStudent = new JButton("max student");
    private JButton minStudent = new JButton("min student");

    private JPanel numbersPanel = new JPanel();
    private JList numbersList = new JList();
    private JPanel btnsNumbers = new JPanel(new GridLayout(1,2));
    private JButton maxNumber = new JButton("max number");
    private JButton minNumber = new JButton("min number");

    private JPanel setStudentsBtn(){
        btnsStudents.add(maxStudent);
        maxStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Max: " + students.max().toString());
                } catch (NullPointerException exception){
                    JOptionPane.showMessageDialog(null, "Cant show");
                }
            }
        });

        btnsStudents.add(minStudent);
        minStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Min: " + students.min().toString());
                } catch (NullPointerException exception){
                    JOptionPane.showMessageDialog(null, "Cant show");
                }
            }
        });

        return btnsStudents;
    }

    private JPanel setNumbersBtn(){
        btnsNumbers.add(maxNumber);
        maxNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Max: " + numbers.max().toString());
                } catch (NullPointerException exception){
                    JOptionPane.showMessageDialog(null, "Cant show");
                }
            }
        });

        btnsNumbers.add(minNumber);
        minNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Min: " + numbers.min().toString());
                } catch (NullPointerException exception){
                    JOptionPane.showMessageDialog(null, "Cant show");
                }
            }
        });

        return btnsNumbers;
    }

    public MainFrame(){
        super("main frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menuBar);
        menuBar.add(loadMenu());



        setLayout(new GridLayout(1,2));

        add(studentsPanel);
        studentsPanel.setLayout(new GridLayout(2,1));
        studentsPanel.add(setStudentsBtn());
        studentsPanel.add(studentsList);

        add(numbersPanel);
        numbersPanel.setLayout(new GridLayout(2,1));
        numbersPanel.add(setNumbersBtn());
        numbersPanel.add(numbersList);

    }
}