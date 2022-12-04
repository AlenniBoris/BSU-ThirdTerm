package ExamWork2.MVC;

import ExamWork2.MVC.Controller;
import ExamWork2.MVC.View;
import ExamWork2.Stack;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);

        Stack stack = new Stack();
        View view = new View(stack);
        Controller controller = new Controller(stack, view);

        setJMenuBar(controller.getMyBar());
        add(view.getViewPanel());
    }
}
