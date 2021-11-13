package com.algdat.uke44;
import java.util.PriorityQueue;


public class Huffman {

    public static void main(String[] args) {
        char[] symbols = {'E', 'T', 'I', 'A', 'N'};
        double[] frequencies = {0.4, 0.3, 0.1, 0.167, 0.033};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // make Nodes and add them into priorityQueue
        for(int i = 0; i < symbols.length; i++){
            priorityQueue.add(new Node(symbols[i], frequencies[i]));
        }

        //由于之前设置了toCompare，所以这里remove出来的就是frequency最小的Node
        while (priorityQueue.size() > 1){
            Node a = priorityQueue.remove();
            Node b = priorityQueue.remove();
            Node c = new Node(a, b);   //由于构造器的设定，这里可以通过两个子Node来生成一个新的Node，并且frequency是两个子Node的总和
            priorityQueue.add(c);    //再加进priorityQueue
        }

        Node root = priorityQueue.remove();   //这里移除的其实就是在queue里的最后一个Node，所以去root
        root.makeBitCode("");
        System.out.println(root);
        //并不是kanoniske huffman treet。。。。但是每个字母的bit位数是对的，说明只是左右方向没有搞对而已。。。
        //E: 0
        //T: 10
        //N: 1100
        //I: 1101
        //A: 111

    }

    static class Node implements Comparable<Node>{
        char symbol;
        double frequency;
        Node leftChild;
        Node rightChild;
        String bitCode;

        //Konstruktør
        Node(char symbol, double frequency){
            this.symbol = symbol;
            this.frequency = frequency;
            this.leftChild = null;
            this.rightChild = null;
            this.bitCode = "";
        }

        //Konstruktør
        Node(Node leftChild, Node rightChild){
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.symbol = ' ';
            this.frequency = leftChild.frequency + rightChild.frequency;
            this.bitCode = "";

        }

        /**
         * Override compareTo method, 要有public在前面！
         * @param other 用于比较两个Node的frequency，因为之后要使用PriorityQueue，所以要在这里规定如何比较
         * @return 会自动使用，不用特意call这个函数
         */
        public int compareTo(Node other){
            return Double.compare(this.frequency, other.frequency);  //要用Double.compare（），因为frequency是double类型
        }

        /**
         * Rekursiv metode
         * @param bitCode
         */
        void makeBitCode(String bitCode){
            this.bitCode = bitCode;
            if(this.leftChild != null){
                this.leftChild.makeBitCode(this.bitCode + "0");
            }
            if(this.rightChild != null){
                this.rightChild.makeBitCode(this.bitCode + "1");
            }
        }

        /**
         * Rekursiv metode
         *
         */
        public String toString(){
           String res = "";
           if(this.leftChild == null && this.rightChild ==null){
               res = this.symbol + ": " + this.bitCode + "\n";
           }
           if(this.leftChild != null){
               res += this.leftChild.toString();
           }
           if(this.rightChild != null){
               res += this.rightChild.toString();
           }
           return res;
        }
    }
}





