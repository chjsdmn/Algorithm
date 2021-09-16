package com.algdat.uke37;

import java.util.Arrays;

public class Generics {
    public static void main(String[] args){
        //int[] a0={3,7,9,2,1,6};
        Integer[] a={3,7,9,2,1,6};   //注意 类型要写成全名！
        Character[] b={'A', 'F', 'S', 'O', 'Z', 'B', 'a', '2'};
        String[] c={"abc", "def", "efef", "zzz", "ofo"};
        Person[] d={new Person("Lee", "Zhang"), new Person("Jacky", "Chen"), new Person("Anna", "Zhao"), new Person("Cathy", "Chen")}; //创建Person类型的数组
        //System.out.println(maks(a0, 0, 6));
        //sort(a0);
        sortGenerics(a);
        sortGenerics(b);
        sortGenerics(c);
        sortGenerics(d);
    }
    //建立Person class， 为了能让Person类型的数组也可以使用generics类型的方法
    public static class Person implements Comparable<Person>{  //Person class如果要使用sortGenerics方法，需要implements Comparable，并且建立一个compareTo方法
        String first_name;
        String last_name;
        Person(String first_name, String last_name){
            this.first_name = first_name;
            this.last_name = last_name;
        }
        public int compareTo(Person other){  //因为implements了Comparable，所以要写入这个系统自带compareTo方法，让我们自建的Person类也可以使用
            int last_compare = this.last_name.compareTo(other.last_name);
            if(last_compare == 0){
                return this.first_name.compareTo(other.first_name);
            }
            else{
                return last_compare;
            }
        }
        public String toString(){ //写入系统自带toString方法，让我们自建的Person类也可以使用
            return first_name + "-" + last_name;
        }
    }

    /*public static void sort(int[] a){
        for(int i = 0; i < a.length; i++) {
            int maks_index = maks(a, i, a.length);
            int tmp = a[i];
            a[i] = a[maks_index];
            a[maks_index] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }*/
    public static
    <T extends Comparable<? super T>>   //一般用 T 代表geriatrics类型，要T引用（implement） Comparable class
    void sortGenerics(T[] a) {    //参数的数组也是T类型
        for (int i = 0; i < a.length; i++) {
            int maks_index = maksGenerics(a, i, a.length);
            T tmp = a[i];   //T类型的数组里面的值也是T类型
            a[i] = a[maks_index];
            a[maks_index] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }
    /*public static int maks(int[] a, int begin, int end){
        int maks_index=begin;
        int maks_value=a[begin];
        for(int i=begin+1; i<end; i++){
            if(a[i]>maks_value){
                maks_value=a[i];
                maks_index=i;
            }
        }
        return maks_index;
    }*/
    public static
    <T extends Comparable<? super T>>
    int maksGenerics(T[] a, int begin, int end){
        int maks_index=begin;
        T maks_value=a[begin];
        for(int i=begin+1; i<end; i++){
            if(a[i].compareTo(maks_value) > 0){  //比较的时候要用.compareTo（），而不是比较符号
                maks_value=a[i];
                maks_index=i;
            }
        }
        return maks_index;
    }
}

