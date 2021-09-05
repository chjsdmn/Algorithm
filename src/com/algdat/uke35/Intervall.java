package com.algdat.uke35;

import java.util.Arrays;

public class Intervall {
    public static void main(String[] args){
        char[] a={'A','B','C','D','E','F','G','H','I','J'};
        char[] b= Arrays.copyOfRange(a,1,3);  //Arrays.copyOfRange(array,[fra,til))-----halfopen intervall
        for(char x:a) System.out.print(x+", ");  //foreach 遍历数组 for(元素类型char 元素变量x : 遍历对象obj)
        System.out.println();
        for (char k : b) System.out.print(k + " ");
    }


    public static class BinaryTree {
        public static void main(String[] args){
            int id=11;
            int parentId=parent(id);
            int siblingId=sibling(id);
            int grandParentId=grand(id);
            int uncleId=uncle(id);
            System.out.println("Parent Id is "+parentId);
            System.out.println("Sibling Id is "+siblingId);
            System.out.println("Grandparent Id is "+grandParentId);
            System.out.println("Uncle Id is "+uncleId);
        }

        public static int parent(int id){
            //if(id%2==0)   不这么写也行，因为函数的返回值是int，所以即使不会整除，java也会自动把小数转换为向下取的整数
                return id/2;
            //else
                //return (int)Math.floor(id/2);
        }

        public static int sibling(int id){
            if(parent(id)*2==id)
                return id+1;
            else
                return id-1;
        }

        public static int grand(int id){
            return parent(parent(id));
        }

        public static int uncle(int id){
            return sibling(parent(id));
        }

    }
}
