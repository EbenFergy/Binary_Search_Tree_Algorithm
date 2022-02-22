//PURPOSE OF PROGRAM: TO SORT AN ARRAY OF ELEMENTS USING THE BINARY SEARCH TREE ALGORITHM, TREE INSERTION PROCEDURE
//                    AND IN-ORDER TREE WALK;
//                     THIS PROGRAM CHECKS THE NUMBER OF KEY COMPARISONS WHEN USING THE NORMAL TREE-INSERTION METHOD;

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 2;
//DATE: FEBRUARY 20TH 2022;


package BinarySearchTree;

import java.util.Random;
import java.util.Arrays;

public class Binary_Search_Tree{


//    static int [] inputArr = {2,3,4,5,6,8,9,10,15,19,21,44,48,56,58};
static int [] inputArr = {3,7,8,9,11,25,29,36,44,46,48,56,58,60,65};
//    static int [] inputArr = {65,60,55,52,51,42,40,39,32,30,29,25,22,21,15};
//    static int [] inputArr = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};

//    int[] inputArr = new int[100];

    //      random integers between 100 and 1000 inclusive
//    int min = 100;
//    int max = 1000;
//
//    for(int i = 0; i< inputArr.length; i++) {
//        inputArr[i] = (int)(Math.random() * (max - min)) + min;
//    }


    static class Tree{
        Node root;
    }


    static Tree T = new Tree();

    static int counter = 0;



    static class Node{
        int key;
        Node parent;
        Node leftChild;
        Node rightChild;


        Node(int key){
            this. key = key;
        }

    }



    public static void main(String[] args) {
        for(int i = 0; i<inputArr.length; i++){
            Node z = new Node(inputArr[i]);
            TREE_INSERT(T, z ) ;
        }

        System.out.println("\nINITIAL ARRAY OF NODE KEYS");
        System.out.println( Arrays.toString(inputArr));
        System.out.println("\nSorted Tree Nodes using the NORMAL TREE INSERT PROCEDURE IN THE TEXTBOOK");
        INORDER_TREE_WALK(T.root);
        System.out.println("\nNORMAL TREE INSERT KEY COMPARISON: " + counter);
    }


    public static void TREE_INSERT(Tree T, Node z) {
        Node y = null;
        Node x = T.root;
        while(x != null){
            y = x;
            counter++;
            if(z.key < x.key){
                x = x.leftChild;

            }
            else{
                x = x.rightChild;
            }
        }
        z.parent = y;
        counter++;
        if(y == null){
            T.root = z;
        }

        else if(z.key < y.key){
            y.leftChild = z;
        }
        else{
            y.rightChild = z;
        }
    }


    public static void INORDER_TREE_WALK(Node x){
        if(x != null) {
            INORDER_TREE_WALK(x.leftChild);
            System.out.print(x.key + " ");
            INORDER_TREE_WALK(x.rightChild);
        }
    }

}


