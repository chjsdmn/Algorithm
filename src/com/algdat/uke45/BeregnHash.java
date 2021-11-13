package com.algdat.uke45;

public class BeregnHash {
    public static void main(String[] args) {
        String a = "ABC";
        int hash = 0;
        for(int i = 0; i < a.length(); i++){
            System.out.println(a.charAt(i) + ": " + (int)a.charAt(i));  //居然可以算出字母的数字表示！！！！
            //A: 65
            //B: 66
            //C: 67
            hash += a.charAt(i);
        }
        System.out.println(hash);  //198
    }
}
