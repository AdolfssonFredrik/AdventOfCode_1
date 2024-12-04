package binaryTree;

public class Node {
    public int value, amount;
    public Node left, right;

    public Node(int value, int amount) {
        this.value = value;
        this.amount = amount;
        left = right = null;
    }
}
