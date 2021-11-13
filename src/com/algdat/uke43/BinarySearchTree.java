package com.algdat.uke43;

public class BinarySearchTree {

    public static void main(String[] args) {
        BST tree = new BST();
        int[] a = { 9, 7, 8, 1, 3, 5, 11, 13, 10, 8, 8 };
        for(int i = 0; i < a.length; i++){
            tree.insert(a[i]);
            tree.print();
            System.out.println();
        }

        System.out.println(tree.search(10));   // true/ adress
        System.out.println(tree.search(20));  //false/ null
        System.out.println(tree.delete(8));
        tree.print();  //9 7 1 3 5 8 8 11 10 13
        System.out.println(tree.delete(8));
        tree.print();  //9 7 1 3 5 8 11 10 13
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

    public static class BST {
        Node root;

        /*Node search(int value){
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
        }*/
        boolean search(int value){
            Node m = root;
            while (m != null){
                if(value > m.value){
                    m = m.rightChild;
                }
                else if(value < m.value){
                    m = m.leftChild;
                }
                else {
                    return true;
                }
            }
            return false;
        }

        void insert(int value){
            if(root == null){   //先判断树是否为空

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

        boolean delete(int value){
            /*if(value == null){
                return false;
            }*/
            Node p = root;
            Node m = null; //parent til p
            while (p != null){  //寻找value所对应的结点，即p最后停留在哪里
                if(value > p.value){
                    m = p;  //这步要放在里面，因为当要删除的值等于p的值的时候，m不应该设置成p！！！！！！
                    p = p.rightChild;
                }
                else if(value < p.value){
                    m = p;   //这步要放在里面，因为当要删除的值等于p的值的时候，m不应该设置成p！！！！！！
                    p = p.leftChild;
                }
                else {
                    break;
                }
            }
            if(p == null){  //value不存在于树中
                return false;
            }
            //找到了value！！并且p有一个子结点或者没有子结点的时候
            if(p.rightChild == null || p.leftChild == null){  //当p有一个子结点或者没有子结点的时候, 没有也包含在这个条件里面，即p.rightChild == null && p.leftChild == null!!!!!
                //下面的if语句是先创建Node r，然后再赋值，所以r可能为null
                Node r = p.leftChild != null? p.leftChild : p.rightChild; //r是p的左结点如果p的左结点不为null，r是p的右结点如果p的右结点不为null
                /*Node r;
                if(p.leftChild != null){
                    r = p.leftChild;
                }
                else{
                    r = p.rightChild;
                }*/
                if(p == root){  //如果p是根结点，即没有父结点，则p的子，即r为根
                    root = r;
                    if(r != null){  //确认r是否为null，因为null不能有parent！！！
                        r.parent = null;
                    }
                }
                // 如果p有父节点
                else if(p == m.leftChild){  //当p是f父结点的左子时
                    m.leftChild = r;
                    if(r != null){  //确认r是否为null，因为null不能有parent！！！
                        r.parent = m;
                    }
                }
                else{  //当p是f父结点的右子时
                    m.rightChild = r;
                    if(r != null){   //确认r是否为null，因为null不能有parent！！！
                        r.parent = m;
                    }
                }
            }
            //找到了value！！并且p有两个子结点的时候, 我们要找到p在inorder中的下一个结点，这个结点就是p右侧数中最下方的左结点，并且这个结点再没有左结点！！将这个结点的值赋给p，然后将这个值删掉，因这个值没有左结点
            else{
                Node s = p;  //创建结点s，使他等于p
                Node r = p.rightChild; //因为是要找p在inorder中的下一个结点，所以要从p的右节点下手，创建r为p的右节点
                while (r.leftChild != null){  //因为是要找最下方的左结点并且这个结点再无左结点，所以要确保左结点不为空，一直循环到左节点为空，所以只在左侧一侧循环就好
                    s = r;   //这个操作使得s成为r的父节点
                    r = r.leftChild;
                }
                //找到了r！即p在inorder中的下一个结点，就是p右侧数中最下方的左结点
                p.value = r.value;   //将这个结点的值赋值给p
                if(s != p){    //如果r的父节点不等于p
                    s.leftChild = r.rightChild;
                    if(r.rightChild != null){   //确认r.rightChild是否为null，因为null不能有parent！！！
                        r.rightChild.parent = s;
                    }
                }
                else {  //如果r的父节点等于p，即p就是r的父节点
                    s.rightChild = r.rightChild;
                    if(r.rightChild != null){  //确认r.rightChild是否为null，因为null不能有parent！！！
                        r.rightChild.parent = s;
                    }
                }
            }
            return true;
        }

        void print(){
            this.root.printPreorderRecursive();
        }
    }
}
