import javax.swing.JFrame;

public class GUIMain {
    public static void main(String[] args) {
// создание контейнера верхнего уровня JFrame
        MyFrame frame = new MyFrame("Simple Swing");
// установка начальных размеров фрейма
        frame.setLocation(300,300);
        frame.setSize(300, 400);
// отображение фрейма
        frame.setVisible(true);
    }
}
