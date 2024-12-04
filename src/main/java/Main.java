
/*
TODO:
 -
 */

import binaryTree.Node;
import binaryTree.Tree;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static java.util.Collections.min;

public class Main {
    static int difference = 0;
    public static void main(String[] args) throws IOException {
        Tree leftTree = new Tree();
        Tree rightTree = new Tree();

        Input input = new Input();
        //input.parseFile("C:\\Users\\zerox\\Java\\Eget\\AdventOfCode\\AdventOfCode_1\\src\\main\\resources\\InputTest.txt");
        input.parseFile("C:\\Users\\zerox\\Java\\Eget\\AdventOfCode\\AdventOfCode_1\\src\\main\\resources\\Input.txt");

        for(int number : input.getLeftList()){
            leftTree.insert(number);
        }

        for(int number : input.getRightList()){
            rightTree.insert(number);
        }

        ArrayList<Integer> sortedLeft = new ArrayList<>(leftTree.getSortedList(leftTree.root));
        ArrayList<Integer> sortedRight = new ArrayList<>(rightTree.getSortedList(rightTree.root));

        System.out.println("|=====The Result=====|");
        System.out.println("\nThis is my solution to the Advent \n" +
                "Of Code Day 1 problem\n");

        getDifference(sortedLeft, sortedRight);

        System.out.println();
        getSimilarityScore(sortedLeft, rightTree);


        System.out.println("|==================|");
    }

    public static void getDifference(ArrayList<Integer> sortedLeft, ArrayList<Integer> sortedRight) {
        for(int i = 0; i < sortedRight.size(); i++){
            int a = sortedLeft.get(i) - sortedRight.get(i);
            difference += (a < 0) ? -a : a;
        }
        System.out.println("The difference is: " + difference);
    }

    public static void getSimilarityScore(ArrayList<Integer> sortedLeft, Tree rightTree) {
        int count;
        int product;
        int sum = 0;

        for(int number : sortedLeft){
            Node searchIndex = rightTree.search(number, rightTree.root);
            if(searchIndex != null){
                count = searchIndex.amount;
                product = count * number;
                sum += product;
            }
        }
        System.out.println("The similarity score is: " + sum);
    }
}
