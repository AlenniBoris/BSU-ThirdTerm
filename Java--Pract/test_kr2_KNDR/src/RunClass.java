import java.util.Scanner;

public class RunClass {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
//        System.out.println(stack.toString());

        System.out.println("What you woyld like to do with stack");
        Scanner sc =  new Scanner(System.in);
        String command = sc.nextLine();
        Controller controller = new Controller(command, stack);
        controller.doSmth();
    }
}
