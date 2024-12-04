package binaryTree;

import java.util.ArrayList;

public class Tree {
    public Node root;
    private ArrayList<Integer> sortedList;
    public int counter = 0;


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
            if(root.amount > 1) {
                System.out.print(root.value + " " + root.amount +  " ===> ");
            }
            inOrderTraverse(root.right);
        }
    }

    public ArrayList<Integer> getSortedList(Node root) {
        counter++;
        if (root != null) {
            getSortedList(root.left);
            for(int i = 0; i < root.amount; i++) {
                sortedList.add(root.value);
            }
            getSortedList(root.right);
        }
        return sortedList;
    }


    public void search(int value, Node root) {
        if(root != null) {
            if(root.value == value) {
                System.out.println("Found: " + root.value);
            }
            else if(value < root.value) {
                search(value, root.left);
            }
            else if(value > root.value) {
                search(value, root.right);
            }
            else {
                System.out.println("Not Found");
            }
        }
    }

    public void findDifference(ArrayList<Integer> leftList, ArrayList<Integer> rightList){




    }
}
