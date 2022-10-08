public class BSTree<T extends Comparable<T>> implements Comparable<BSTree<T>>{
    @Override
    public int compareTo(BSTree<T> o) {
        return 0;
    }

    private class Node{
        T _val;
        Node _left;
        Node _rigth;
        Node(T val){
            _left = _rigth = null;
            _val = val;
        }
    }

    private Node root;

    BSTree() {
        root = null;
    }

    BSTree(T val){
        root = new Node(val);
    }

    public void insert(T num) { root = insertNum(root, num); }
    public void print(){ printLeafLeft_Right_Root(root); }
    public void search(T num) { root = findNum(root, num); }

    Node insertNum(Node root, T num){
        int comp = 0;
        if (root == null){
            root = new Node(num);
            return root;
        }
        else if (root._val.compareTo(num) < 0){
            root._left = insertNum(root._left, num);
        }
        else{
            root._rigth = insertNum(root._rigth, num);
        }

        return root;
    }

    void printLeafRoot_Left_Right(Node root){
        if (root != null){
            System.out.println(root._val);
            printLeafRoot_Left_Right(root._left);
            printLeafRoot_Left_Right(root._rigth);
        }
    }

    void printLeafLeft_Right_Root(Node root){
        if (root != null){
            printLeafLeft_Right_Root(root._left);
            printLeafLeft_Right_Root(root._rigth);
            System.out.println(root._val);
        }
    }

     void printLeafLeft_Root_Right(Node root){
        if (root != null){
            printLeafLeft_Root_Right(root._left);
            System.out.println(root._val);
            printLeafLeft_Root_Right(root._rigth);
        }
    }

    Node findNum(Node root, T num){
        if (root == null || root._val == num){
            return root;
        }
        else if (num.compareTo(root._val) >= 0){
            return findNum(root._rigth, num);
        }
        else {
            return findNum(root._left, num);
        }
    }

}
