package com.algdat.uke44;

import java.util.*;

public class LZW {
    public static void main(String[] args) {
        System.out.println(komprimer("ABBABABAC"));  //[65, 66, 66, 256, 259, 67]
        System.out.println(komprimer("AAAAAAAAAAA")); //[65, 256, 257, 258, 65]
    }

    /**
     * w 是第一个字母，
     * k 是w之后的一个字母
     * @param melding 要压缩成文件
     * @return
     */
    public static List<Integer> komprimer(String melding){
        Map<String, Integer> ordbok = new HashMap<>();   //map是键值对应结构，时候做字典，保存字母及其对应的编码
        List<Integer> result = new ArrayList<>();  //List作为最后输出的编码串，即压缩后的结果
        char w_i_char = melding.charAt(0);  //第一个字母w，类型是char
        String w = String.valueOf(w_i_char);  //通过String.valueOf()方法，把w的类型转化为string，方便之后的操作
        int w_i_code = w_i_char;  //把w表示成编码的形式，即int类型，为65
        ordbok.put(w, w_i_code);  //将第一个字母放入字典即HashMap，通过.put(K键, V值)函数
        int nesteCode = 256;  //设定下一个新增的code的参照值
        /**
         * for-loop中的w_i_char = k （w的下一个字母）
         */
        for(int i = 1; i < melding.length(); i++){  //从i从1开始，因为已经放入了一个字母，即第一个字母w
            w_i_char = melding.charAt(i);  //更新w_i_char为下一个字母，即下面注释掉的k
            //char K = melding.charAt(i);   //设置w之后的一个字母k，类型还是char
            String wk = w + w_i_char;  //建立w和k的组合字符串即wk，注意，String类型和char类型是可以相加的，结果类型为String！！！
            Integer ordCode = ordbok.get(wk);  //通过.get(K键)函数，获取V值，存在则返回K对应的V的值，不存在则返回null，注意，这里的结果类型要用Integer表示，而不是int！！！
            if(ordCode == null){  //字典里没有wk这条
               ordbok.put(wk, nesteCode++); //将wk加入字典
               result.add(w_i_code);  //将w，即第一个字母的code加入到结果List中
               w = String.valueOf(w_i_char);  //设置w=w_i_char，将w的string类型 = k的string类型
               w_i_code = w_i_char;  //设置w=w_i_char，将w的code = k的code，注意，因为w_i_code的类型是int，所以当他=k时，本来为char类型的k会自动转化成编码形式（int）
            }
            else{   //字典里有wk这条
                w = wk;  //设置w=wk，将w的string类型 = wk的string类型
                w_i_code = ordCode;  //设置w=wk，将w的code = wk的code，即再字典里找的的code
            }
        }
        //这步没懂。。。最后一个字母加入后，也要加进去???
        result.add(w_i_code);
        return result;
    }

}
