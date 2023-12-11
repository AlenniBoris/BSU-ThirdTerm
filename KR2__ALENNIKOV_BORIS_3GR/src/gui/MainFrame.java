package gui;

import mvc.Controller;
import mvc.Multitude;
import mvc.View;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        Multitude multitude = new Multitude();
        View view = new View(multitude);
        Controller controller = new Controller(multitude, view);

        setJMenuBar(controller.getMyBar());
        add(view.getViewPanel());
    }
}
