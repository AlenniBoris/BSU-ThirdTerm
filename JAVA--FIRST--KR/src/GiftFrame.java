import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GiftFrame extends JFrame {
    private JPanel btnPanel = new JPanel();
    private JButton addBtn = new JButton("Add");
    private JButton delBtn = new JButton("Delete");

    private JPanel inputPanel = new JPanel();
    private JTextField nameInput = new JTextField("Name");
    private JTextField typeInput = new JTextField("Type");
    private JTextField weigthInput = new JTextField("Weight");
    private JTextField sugarInput = new JTextField("Sugar");

    private JList showArea;

    private GiftClass giftClass = new GiftClass();

    public GiftFrame(){
        setLayout(new GridLayout(3,1));

        add(inputPanel);

        inputPanel.setLayout(new GridLayout(1,4));

        inputPanel.add(nameInput);
        nameInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeInput.setText("");
            }
        });

        inputPanel.add(typeInput);
        typeInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeInput.setText("");
            }
        });

        inputPanel.add(weigthInput);
        weigthInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeInput.setText("");
            }
        });

        inputPanel.add(sugarInput);
        sugarInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeInput.setText("");
            }
        });


        showArea = new JList(giftClass.printGift());
        add(showArea);

        add(btnPanel);
        btnPanel.setLayout(new GridLayout(1,2));

        btnPanel.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameInput.getText().length() != 0 && typeInput.getText().length() != 0 && weigthInput.getText().length() != 0 && sugarInput.getText().length() != 0){
                    giftClass.addSweet(new SweetsClass(nameInput.getText(), typeInput.getText(), Double.parseDouble(weigthInput.getText()), Double.parseDouble(sugarInput.getText())));
                }
                showArea.setListData(giftClass.printGift());
            }
        });

        btnPanel.add(delBtn);
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.deleteSweet(showArea.getSelectedIndex());
                showArea.setListData(giftClass.printGift());
            }
        });
    }


}
