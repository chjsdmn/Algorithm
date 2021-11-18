package com.algdat.uke45;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {
    public static void main(String[] args) {
        String[] str = {"Hei", "på deg", "God", "Test", "Hallo"};
        int size = str.length;

        //建立一个arraylist，并且每一项都是一个linkedlist，因为如果有多个的hashrest相同，在arraylist中就会拥有相同的index，这时候他们就可以排列在一个linkedlist里面
        ArrayList<LinkedList<String>> hashMap = new ArrayList<>(size);

        //将arraylist里的每一项加入一个linkedlist
        for(int i = 0; i < size; i++){
            hashMap.add(i, new LinkedList<>());
        }
        //往linkedlist里面加入值
        for(int i = 0; i < str.length; i++) {
            int indeks = beregnHashRest(beregnHash(str[i]), size);  //取得每个string在arraylist中的index
            //.addFirst(),新来的元素都插在前面，因为hashmap的发明者觉得后来的元素使用的频率比较高!
            hashMap.get(indeks).addFirst(str[i]);   //每个hashMap.get(indeks)都是一个linkedlist
            System.out.println("Index: " + indeks + " - " + str[i]);
        }

        //Søke etter en streng
        //在arraylist中查找
        String test = "Test2";
        int hash = beregnHash(test);
        int index = beregnHashRest(hash, size);
        System.out.println(hashMap.get(index));  //[Hallo, Test]
        System.out.println(hashMap.get(index).contains(test));  //false .contains(item)，有就返回true，没有就是false
    }

    //算出每个string的hash值，这里是每个字母的数字和
    //Sum av alle bokstavene (ikke optimalt).
    //for (int i=0; i<data.length(); ++i) {
    // hash = hash + (int) data.charAt(i);
    public static int beregnHash(String a){
        int hash = 0;
        for(int i = 0; i < a.length(); i++){
            hash += a.charAt(i);
        }
        if(hash < 0){   //如果和过大，超过储存范围，就会变成负数，所以这里使负数变正数
            return -hash;
        }
        return hash;
    }

    //将hash值除以arraylist的长度，取余数
    public static int beregnHashRest(int hash, int hashMapSize){
        int hashRest = hash % hashMapSize;

        return hashRest;
    }

    //另一种方法计算hash
    static int hash(String data) {
        int hash = 0;
        for (int i=data.length()-1; i>= 0; --i) {
            char c = data.charAt(i);
            hash = (hash + c)*31;
        }
        if (hash < 0) {
            hash = -hash;
        }
        return hash;
    }

}
