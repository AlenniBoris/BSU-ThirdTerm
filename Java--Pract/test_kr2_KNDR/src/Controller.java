public class Controller {
    String command;
    Stack stack;
    View view = new View();

    public Controller(String command, Stack stack){
        this.command = command;
        this.stack = stack;
    }

    public void doSmth(){
        switch (command){
            case "Push" :
                stack.Push(1);
                view.update(stack);
                break;
            case "Pop" :
                stack.Pop();
                view.update(stack);
                break;
            case "Clear" :
                stack.clear();
                view.update(stack);
                break;
        }
    }
}
