//PURPOSE OF PROGRAM: TO SORT AN ARRAY OF ELEMENTS USING THE BINARY SEARCH TREE ALGORITHM, A MODIFIED TREE INSERTION PROCEDURE
//                    AND IN-ORDER TREE WALK;
//                     THIS PROGRAM CHECKS THE NUMBER OF KEY COMPARISONS WHEN USING THE MODIFIED TREE-INSERTION METHOD;

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 2;
//DATE: FEBRUARY 20TH 2022;

package BinarySearchTree;

import java.util.Arrays;

public class Modified_Binary_Search_Tree {




        static class Tree{
            Node root;
        }

        static Tree T = new Tree();


//    static int [] inputArr = {40,25,50,20,4237,55,13,22,31,39,41,44,53,61};
    static int [] inputArr = {3,7,8,9,11,25,29,36,44,46,48,56,58,60,65};
//    static int [] inputArr = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
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
                TREE_INSERT_MODIFIED(inputArr[i]);
            }
            System.out.println("\nINITIAL ARRAY OF NODE KEYS");
            System.out.println( Arrays.toString(inputArr));
            System.out.println("\nSorted Tree Nodes using the MODIFIED TREE INSERT PROCEDURE");
            INORDER_TREE_WALK(T.root);
            System.out.println("\nMODIFIED TREE INSERT KEY COMPARISON: " + counter);


        }

        public static void TREE_INSERT_MODIFIED( int key) {
            Node newNode = new Node(key);
            if (T.root == null) {
                T.root = newNode;
            }

            else {
                Node x = T.root;
                Node parent;

                while (true) {
                    parent = x;
                    counter++;
                    if (key < x.key) {
                        x = x.leftChild;

                        if (x == null) {
                            parent.leftChild = newNode;
                            return;
                        }

                    } else {
                        x = x.rightChild;

                        if (x == null) {
                            parent.rightChild = newNode;
                            return;
                        }

                    }

                }
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
