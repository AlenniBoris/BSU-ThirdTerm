import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGui extends JFrame {

    private final Multitude<Integer> firstMultitude = new Multitude<>();
    private final Multitude<Integer> secondMultitude = new Multitude<>();

    private final JList<Object> firstList = new JList<>();;
    private final JList<Object> secondList = new JList<>();
    private final JList<Object> unitList = new JList<>();
    private final JList<Object> interceptionList = new JList<>();
    private final JList<Object> diffList = new JList<>();

    private final JButton addFirstBtn = new JButton("Add");
    private final JButton addSecondBtn = new JButton("Add");
    private final JButton unitBtn = new JButton("Unit");
    private final JButton interceptionBtn = new JButton("Interception");
    private final JButton diffBtn = new JButton("Difference");


    private JPanel getListPanel(){
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(5,1));

        JPanel firstListPanel = new JPanel();
        firstListPanel.add(firstList);
        setScroll(firstList, firstListPanel);
        listPanel.add(firstListPanel);

        JPanel secondListPanel = new JPanel();
        secondListPanel.add(secondList);
        setScroll(secondList, secondListPanel);
        listPanel.add(secondListPanel);

        JPanel unitListPanel = new JPanel();
        unitListPanel.add(unitList);
        setScroll(unitList, unitListPanel);
        listPanel.add(unitListPanel);

        JPanel interListPanel = new JPanel();
        interListPanel.add(interceptionList);
        setScroll(interceptionList, interListPanel);
        listPanel.add(interListPanel);

        JPanel diffListPanel = new JPanel();
        interListPanel.add(diffList);
        setScroll(diffList, diffListPanel);
        listPanel.add(diffListPanel);

        return listPanel;
    }

    private void setScroll(JList<Object> list, JPanel panel){
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);
    }

    private JPanel getButtonsPanel(){
        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new GridLayout(5,1));

        btnsPanel.add(addFirstBtn);
        addFirstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog("Add to your first multitude");
                String[] arr = str.split(",");
                for(String s : arr){
                    firstMultitude.add(Integer.parseInt(s));
                }
                firstList.setListData(firstMultitude.getArrayList().toArray());
            }
        });
        btnsPanel.add(addSecondBtn);
        addSecondBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog("Add to your first multitude");
                String[] arr = str.split(",");
                for(String s : arr){
                    secondMultitude.add(Integer.parseInt(s));
                }
                secondList.setListData(secondMultitude.getArrayList().toArray());
            }
        });
        btnsPanel.add(unitBtn);
        unitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unitList.setListData(firstMultitude.unitMultitude(secondMultitude).toArray());
            }
        });
        btnsPanel.add(interceptionBtn);
        interceptionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interceptionList.setListData(firstMultitude.interceptionMultitude(secondMultitude).toArray());
            }
        });
        btnsPanel.add(diffBtn);
        diffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diffList.setListData(firstMultitude.diffMultitude(secondMultitude).toArray());
            }
        });

        return btnsPanel;
    }

    public AppGui(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setVisible(true);
        setLayout(new GridLayout(1,2));
        add(getListPanel());
        add(getButtonsPanel());
    }

}
