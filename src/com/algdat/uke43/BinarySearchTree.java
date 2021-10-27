package com.algdat.uke43;

public class BinarySearchTree {

    public static void main(String[] args) {
        BST tree = new BST();
        int[] a = { 9, 7, 1, 3, 5, 11, 13, 10, 8 };
        for(int i = 0; i < a.length; i++){
            tree.insert(a[i]);
            tree.print();
            System.out.println();
        }

        System.out.println(tree.search(10));   //adress
        System.out.println(tree.search(20));  //null
    }
    public static class Node{
        Node parent;
        Node leftChild;
        Node rightChild;
        int value;

        Node(){

        }
        Node(int value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

        Node(int value, Node parent){
            this.value = value;
            this.parent = parent;
            this.leftChild = null;
            this.rightChild = null;
        }

        Node(int value, Node parent, Node leftChild, Node rightChild){
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        void printPreorderRecursive(){
            System.out.print(this.value + " ");
            if(this.leftChild != null) {
                this.leftChild.printPreorderRecursive();
            }
            if(this.rightChild != null){
                this.rightChild.printPreorderRecursive();
            }
        }
    }

    public static class BST{
        Node root;

        Node search(int value){
            Node m = root;
            while (m != null && m.value != value){
                if(value > m.value){
                    m = m.rightChild;
                }
                else if(value < m.value){
                    m = m.leftChild;
                }
                else {
                    break;
                }
            }
            return m;
        }

        void insert(int value){
            if(root == null){
                root = new Node(value);
            }
            else{
                Node m = root;
                Node n = null;  // parent til m
                while (m != null){
                    n = m;
                    if(value >= m.value){
                        m = m.rightChild;
                    }
                    else{
                        m = m.leftChild;
                    }
                }
                if(value >= n.value){
                    n.rightChild = new Node(value, n);
                }
                else{
                    n.leftChild = new Node(value, n);
                }
            }
        }

        void print(){
            this.root.printPreorderRecursive();
        }
    }
}
