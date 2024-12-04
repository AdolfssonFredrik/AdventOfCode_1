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
            if (root.value == value) {
                //if value is found in tree
                //return the node where it is found
                return root;
            } else if (value < root.value) {
                return search(value, root.left);
            } else {
                return search(value, root.right);
            }
        }else{
            //Return null if node not found
            return null;
        }
    }
}

