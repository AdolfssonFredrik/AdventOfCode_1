
/*
TODO:
 - Parse the txt file.
 - Input data into a binary tree.
 - Pair up and find distance between all the nodes (distance from smallest in right list to smallest in left list, and so on).
 - Sum the total distance
 */

import binaryTree.Node;
import binaryTree.Tree;

import java.io.IOException;
import java.util.ArrayList;

import static java.util.Collections.min;

public class Main {
    static int difference = 0;
    public static void main(String[] args) throws IOException {
        Tree leftTree = new Tree();
        Tree rightTree = new Tree();

        Input input = new Input();
        input.parseFile("C:\\Users\\zerox\\Java\\Eget\\AdventOfCode\\AdventOfCode_1\\src\\main\\resources\\Input.txt");

        for(int number : input.getLeftList()){
            leftTree.insert(number);
        }

        for(int number : input.getRightList()){
            rightTree.insert(number);
        }

        System.out.println(min(input.getLeftList()));


        ArrayList<Integer> sortedLeft = new ArrayList<>(leftTree.getSortedList(leftTree.root));
        ArrayList<Integer> sortedRight = new ArrayList<>(rightTree.getSortedList(rightTree.root));

        rightTree.inOrderTraverse(rightTree.root);
        System.out.println();
        leftTree.inOrderTraverse(leftTree.root);





        int count = 0;
        for(int i = 0; i < sortedRight.size(); i++){
            int a = sortedLeft.get(i) - sortedRight.get(i);
            difference += (a < 0) ? -a : a;
            //System.out.println(sortedLeft.get(i) + " - " + sortedRight.get(i) + " = " + ((a < 0 )? -a : a));
            count = i;
        }
        System.out.println(count);

        System.out.println("The difference is: " + difference);
    }

    public static void getDifference(Node leftRoot, Node rightRoot) {

        System.out.println(difference);
    }
}
