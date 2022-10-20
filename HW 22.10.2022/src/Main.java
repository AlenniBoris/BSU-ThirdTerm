public class Main {
    public static void main(String[] args) {
//        StackWithList<Integer> stack = new StackWithList<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(5);
//        System.out.println(stack.pop());


//        StackWithArray<Integer> starr = new StackWithArray<>(2);
//        starr.push(1);
//        starr.push(2);
//        starr.push(3);
//        System.out.println(starr.pop());
//        System.out.println(starr.pop());
//        System.out.println(starr.pop());
//        starr.push(5);
//        System.out.println(starr.pop());

//        StackWithObjectArray<Integer> starr = new StackWithObjectArray(2);
//        starr.push(1);
//        starr.push(2);
//        starr.push(3);
//        System.out.println(starr.pop());
//        System.out.println(starr.pop());
//        System.out.println(starr.pop());
//        starr.push(5);
//        System.out.println(starr.pop());

        Table<Integer, Boolean> table = new Table<>();
        table.push(new Entry<>(1, true));
        table.push(new Entry<>(2, true));
        table.push(new Entry<>(3, true));
        table.push(new Entry<>(4, false));
        System.out.println(table.getValue(4));
        table.setValue(4, true);
        System.out.println(table.getValue(4));
        table.deleteKey(4);
        System.out.println(table.getValue(4));
    }
}
