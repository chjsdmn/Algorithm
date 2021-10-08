package com.algdat.uke37;

import java.util.Arrays;

public class GenericsSort {
    public static class Person implements Comparable<Person>{   //Comparable是一个接口interface，
        String first_name;
        String last_name;
        Person(String first_name, String last_name){
            this.first_name = first_name;
            this.last_name = last_name;
        }
        public int compareTo(Person other){
            int last_name_compare = this.last_name.compareTo(other.last_name);  //this??
            if(last_name_compare == 0){
                return this.first_name.compareTo(other.first_name); //this??
            }
            else{
                return last_name_compare;
            }
        }
        public String toString(){   //why??
            return first_name + "-" + last_name;  //this??
        }
    }
    public static void main(String[] args){
        Integer[] a = {6,3,2,4,1};
        Character[] b = {'a', 'A', 'c', 'Q', 'h'};
        String[] c= {"hello", "world", "Hello", "World", "SB"};
        Person[] d= {new Person("Lee", "Zhang"),
                     new Person("Jacky", "Chen"),
                     new Person("Anna", "Zhao"),
                     new Person("Cathy", "Chen")
        };
        System.out.println(Arrays.toString(sort(a)));
        System.out.println(Arrays.toString(sort(b)));
        System.out.println(Arrays.toString(sort(c)));
        System.out.println(Arrays.toString(sort(d)));
    }
    public static
    <T extends Comparable<? super T>>
    T[] sort(T[] a){
        for(int i = 0; i < a.length - 1; i++){
            int maks_index = maks(a, i, a.length);
            T tmp = a[i];
            a[i] = a[maks_index];
            a[maks_index] = tmp;
        }
        return a;
    }
    public static
    <T extends Comparable<? super T>>
    int maks(T[] a, int fra, int til){
        int maks_index = fra;
        T maks_verdi = a[fra];
        for(int i = fra + 1; i < til; i++){
            if(a[i].compareTo(maks_verdi) > 0){
                maks_verdi = a[i];
                maks_index = i;
            }
        }
        return maks_index;
    }
}
