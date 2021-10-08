package com.algdat.uke38;

/** Recurtion
 * 1. 必须自己call自己，
 * 2. 参数要发生变化
 * 3. 必须要有一个可以让他停止的条件，比如if等
 */
public class RecursjonN {
    public static void main(String[] args){
        int n = 5;
        System.out.println(fakultet(n));  //120
        int m =52;
        System.out.println(fakultet(m));  //0, 因为超出了int的表示范围

    }
    static int fakultet(int n){
        if(n == 1){
            return 1;
        }
        return n * fakultet(n-1);
    }
}
