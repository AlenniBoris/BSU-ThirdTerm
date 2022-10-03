public class mainCl {
    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree();
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(5);
        tree.insert(-2);
        tree.insert(-20);
        tree.insert(25);

        tree.print();
        tree.search(70);
    }
}
