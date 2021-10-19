package com.algdat.uke42;

import java.util.ArrayDeque;

class BsTreeNode{   // 创建一个BinaryTreeNode class
    char value;   //他的值
    BsTreeNode left_child;  //他左下方的node
    BsTreeNode right_child;  //他右下方的node
    BsTreeNode(char value){   //构造器
        this.value = value;
        this.left_child = null;
        this.right_child = null;
    }
    // 无需创建方法addRoot，因为通过构造器就可以生成root node了
    BsTreeNode addLeftChild(char value){
        this.left_child = new BsTreeNode(value);
        return this.left_child;
    }
    BsTreeNode addRightChild(char value){
        this.right_child = new BsTreeNode(value);
        return this.right_child;
    }
}

public class BsTree {
    public static void main(String[] args) {
        //添加第一个node，即root， level 0
        BsTreeNode root = new BsTreeNode('A');
        //添加root的两个barn，level 1
        BsTreeNode b = root.addLeftChild('B');
        BsTreeNode c = root.addRightChild('C');
        //分别添加level1两个noded额两个barn，level 2
        BsTreeNode d = b.addLeftChild('D');
        BsTreeNode e = b.addRightChild('E');
        BsTreeNode f = c.addLeftChild('F');
        BsTreeNode g = c.addRightChild('G');

        System.out.print("Nivå order: ");
        printLevelOrder(root);  // A B C D E F G
        System.out.println();

        System.out.print("Pre order: ");
        printPreOrder(root);   // A B D E C F G
        System.out.println();

        System.out.print("In order: ");
        printInOrder(root);    // D B E A F C G
        System.out.println();

        System.out.print("Post order: ");
        printPostOrder(root);  // D E B F G C A
        System.out.println();

        System.out.print("Per order without recursion: ");
        printDybdeFørstPreOrderNonRecurtion(root);   // A B D E C F G
    }

    /** Bredde først, 即分层遍历打印
     * 分三个步骤打印出Bs tree，利用ArrayDeque
     * @param root Binary tree的第一个node
     */
    static void printLevelOrder(BsTreeNode root){
        ArrayDeque<BsTreeNode> queue = new ArrayDeque<BsTreeNode>();  //首先创建一个ArrayDeque，数据类型是上面创建的class
        queue.addFirst(root);  //先添加第一个元素到ArrayDeque里面，因为这时的ArrayDeque是空的，所以用.addLast()和.addFirst()没差
        while (!queue.isEmpty()){  //当queue不为空时
            // 1. Ta ut noden først i køen
            BsTreeNode current = queue.removeFirst();  //将刚刚放进去的元素删除
            // 2. Legg till nodens barn i køen
            if(current.left_child != null) {  //要先判断当前元素是否有barn，如果有才能添加
                queue.addLast(current.left_child);
            }
            if(current.right_child != null) {
                queue.addLast(current.right_child);
            }
            // 3. Skrive ut
            System.out.print(current.value + " ");
        }
    }

    static void printPreOrder(BsTreeNode node){  //利用recursion来打印出pre order
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        printLevelOrder(node.left_child);
        printLevelOrder(node.right_child);
    }

    static void printInOrder(BsTreeNode node){   //利用recursion来打印出in order
        if(node == null){
            return;   // return 就是这步不走了，完事，开始下一步
        }
        printInOrder(node.left_child);
        System.out.print(node.value + " ");
        printInOrder(node.right_child);
    }

    static void printPostOrder(BsTreeNode node){   //利用recursion来打印出post order
        if(node == null){
            return;
        }
        printPostOrder(node.left_child);
        printPostOrder(node.right_child);
        System.out.print(node.value + " ");
    }

    /**
     * 通常情况下不用recursion，而是用 kø 或者 stack
     * @param root
     */
    static void printDybdeFørstPreOrderNonRecurtion(BsTreeNode root){   //不利用recursion来打印出pre order
        ArrayDeque<BsTreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            BsTreeNode current = stack.removeLast();
            if(current.right_child != null) {
                stack.addLast(current.right_child);
            }
            if(current.left_child != null) {
                stack.addLast(current.left_child);
            }
            System.out.print(current.value + " ");
        }
    }
}
