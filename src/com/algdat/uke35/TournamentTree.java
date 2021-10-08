package com.algdat.uke35;

public class TournamentTree {
    public static class Node{
        char value;
        Node leftChild;   //以自定义类作为类型
        Node rightChild;  //以自定义类作为类型
        Node(char value){    //constructor
            this.value =value;
            this.leftChild=null;
            this.rightChild=null;
        }
        void print(){
            System.out.print(value +" ");  //hvorfor ikke this.value??
            if(this.leftChild!=null) this.leftChild.print();  //recursion?
            if(this.rightChild!=null) this.rightChild.print();
        }
    }

    public static Node playMatch(Node player1, Node player2){
        char winner=player1.value >player2.value ? player1.value : player2.value;
        Node parent=new Node(winner);   //create instance, winner is the value of parent itself.
        parent.leftChild=player1;       //assign leftChild to node parent
        parent.rightChild=player2;      //assign rightChild to node parent
        return parent;
    }

    public static void main(String[] args) {
        Node nodeA=new Node('A');
        Node nodeB=new Node('B');
        Node nodeC=new Node('C');
        Node nodeD=new Node('D');
        Node semi1=playMatch(nodeA,nodeC);
        Node semi2=playMatch(nodeB,nodeD);
        Node finals=playMatch(semi1,semi2);
        finals.print();  // D C A C D B D
    }
}
