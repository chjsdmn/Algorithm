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


}
