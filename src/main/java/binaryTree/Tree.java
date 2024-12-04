package binaryTree;

import java.util.ArrayList;

public class Tree {
    public Node root;
    private ArrayList<Integer> sortedList;


    public Tree() {
        this.sortedList = new ArrayList<>();
    }


    public void insert(int value) {
        root = insertRec(root, value);
    }

    public Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value, 1);
        }
        if(value < root.value) {
            root.left = insertRec(root.left, value);
        }
        else if(value > root.value) {
            root.right = insertRec(root.right, value);
        }
        else{
            root.amount = root.amount + 1;
        }
        return root;
    }

    public void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.left);

            System.out.print(root.value + " " + "(" + root.amount + ")" +  " ===> ");

            inOrderTraverse(root.right);
        }
    }

    public ArrayList<Integer> getSortedList(Node root) {

        if (root != null) {
            getSortedList(root.left);
            for(int i = 0; i < root.amount; i++) {
                sortedList.add(root.value);
            }
            getSortedList(root.right);
        }
        return sortedList;
    }


    public Node search(int value, Node root) {
        if(root != null) {
            if(root.value == value) {
                //System.out.println("Found: " +  root.value + ". Amount: " +  root.amount);
                return root;
            }
            else if(value < root.value) {
                return search(value, root.left);
            }
            else{
                return search(value, root.right);
            }
        }
        else{
            //System.out.println("Not found");
            return null;
        }
    }
}
