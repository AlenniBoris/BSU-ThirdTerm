package Lab11.task1.GUI;

import Lab11.task1.InterfaceComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame {
    public Frame() {
        Subscriber keySubscriber = new Subscriber();
        ObservedItem keyPanel = new ObservedItem();
        keyPanel.addObserver(keySubscriber);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setSize(600,600);
        setVisible(true);

        add(lastKey);
        lastKey.setEditable(false);
        add(getKeysPanel());

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                keyPanel.addKey(String.valueOf(e.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keyPanel.addKey(String.valueOf(e.getKeyChar()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyPanel.notifyObservers();
                lastKey.setText(keySubscriber.getLastData());
                allKeys.setListData(keySubscriber.getIncomingData().toArray());
            }
        });
    }

    private JPanel getKeysPanel(){
        JPanel listPanel = new JPanel();
        listPanel.add(allKeys);
        setScroll(allKeys, listPanel);
        return listPanel;
    }

    private void setScroll(JList<Object> list, JPanel panel){
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);
    }


    private final JTextField lastKey = new JTextField();
    private final JList<Object> allKeys = new JList<>();
}
