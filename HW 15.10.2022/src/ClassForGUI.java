import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClassForGUI extends JFrame{
    private JLabel firstEnterLabel = new JLabel("Enter first");
    private JTextField firstEnterField = new JTextField();
    private JLabel stepEnterLabel = new JLabel("Enter step");
    private JTextField stepEnterField = new JTextField();
    private JLabel numEnterLabel = new JLabel("Enter number");
    private JTextField numEnterField = new JTextField();

    private JButton linearBtn = new JButton("Linear");
    private JButton exponBtn = new JButton("Exponential");

    private JLabel sumLabel = new JLabel("Sum of elements: ");
    private JPanel sumPanel = new JPanel();
    private JTextField sumShowField = new JTextField();

    private JLabel elemsLabel = new JLabel("All elements: ");
    private JPanel elemsPanel = new JPanel();
    private JTextField elemsShowField = new JTextField();

    private JButton clearBtn = new JButton("Clear");
    private JButton saveBtn = new JButton("Save as");

    private Series series;

    ArrayList<JTextField> textFieldArrayList = new ArrayList<>();

    private boolean canWork(){
        try{
           double first = Double.parseDouble(firstEnterField.getText());
           double stepSrs = Double.parseDouble(stepEnterField.getText());
           int elemPos = Integer.parseInt(numEnterField.getText());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public ClassForGUI() throws HeadlessException{
        super("Series widget");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));

        textFieldArrayList.add(firstEnterField);
        textFieldArrayList.add(stepEnterField);
        textFieldArrayList.add(numEnterField);
        textFieldArrayList.add(sumShowField);
        textFieldArrayList.add(elemsShowField);

        //там где мы вводим параметры
        Container paramsSetCont = new Container();
        paramsSetCont.setLayout(new GridLayout(2,3));
        add(paramsSetCont);
        paramsSetCont.add(firstEnterLabel);
        paramsSetCont.add(stepEnterLabel);
        paramsSetCont.add(numEnterLabel);
        paramsSetCont.add(firstEnterField);
        paramsSetCont.add(stepEnterField);
        paramsSetCont.add(numEnterField);

        firstEnterField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }
        });
        stepEnterField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }
        });
        numEnterField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sumShowField.setText("");
                elemsShowField.setText("");
            }
        });

        //кнопки для выбора прогрессии
        Container seriesBtnCont = new Container();
        seriesBtnCont.setLayout(new GridLayout(1,2));
        add(seriesBtnCont);
        seriesBtnCont.add(linearBtn);
        seriesBtnCont.add(exponBtn);

        linearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canWork()){
                    series = new Liner(Double.parseDouble(firstEnterField.getText()), Double.parseDouble(stepEnterField.getText()), Integer.parseInt(numEnterField.getText()));
                    sumShowField.setText(Double.toString(series.getSum()));
                    elemsShowField.setText(series.toString());
                }
                else{
                    sumShowField.setText("Can't find");
                    elemsShowField.setText("Can't find");
                }
            }
        });
        exponBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canWork()){
                    series = new Exponential(Double.parseDouble(firstEnterField.getText()), Double.parseDouble(stepEnterField.getText()), Integer.parseInt(numEnterField.getText()));
                    sumShowField.setText(Double.toString(series.getSum()));
                    elemsShowField.setText(series.toString());
                }
                else{
                    sumShowField.setText("Can't find");
                    elemsShowField.setText("Can't find");
                }
            }
        });

        //поле вывода суммы и чисел прогрессии
        Container showResultsCont = new Container();
        showResultsCont.setLayout(new GridLayout(2,2));
        add(showResultsCont);
        showResultsCont.add(sumLabel);
        showResultsCont.add(sumPanel);
        showResultsCont.add(elemsLabel);
        showResultsCont.add(elemsPanel);

        sumPanel.setLayout(new BoxLayout(sumPanel, BoxLayout.Y_AXIS));
        sumPanel.add(sumShowField);
        sumShowField.setEditable(false);
        JScrollPane sumScrollBar = new JScrollPane(sumShowField);
        sumScrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sumPanel.add(sumScrollBar);

        elemsPanel.setLayout(new BoxLayout(elemsPanel, BoxLayout.Y_AXIS));
        elemsPanel.add(elemsShowField);
        elemsShowField.setEditable(false);
        JScrollPane elemsScrollBar = new JScrollPane(elemsShowField);
        elemsScrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        elemsPanel.add(elemsScrollBar);

        //кнопки очистить и согхранить
        Container finalBtnCont = new Container();
        finalBtnCont.setLayout(new GridLayout(1,2));
        add(finalBtnCont);
        finalBtnCont.add(saveBtn);
        finalBtnCont.add(clearBtn);

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fileChooser.showSaveDialog(saveBtn);
                if (returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    if (canWork()) {
                        series.writeSeriesToFile(file.getName());
                    }
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JTextField j : textFieldArrayList){
                    j.setText("");
                }
            }
        });
    }
}


