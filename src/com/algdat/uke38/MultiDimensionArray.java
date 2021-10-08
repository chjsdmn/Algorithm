package com.algdat.uke38;
//Set element in position (3, 4) (i.e., number 22 below) to 9
// [ [ 0  1  2  3  4  5] ;
//   [ 6  7  8  9 10 11] ;
//   [12 13 14 15 16 17] ;
//   [18 19 20 21 22 23] ;
//   [24 25 26 27 28 29] ];
public class MultiDimensionArray {
    /**
     * 创建二维array
     *
     */
    public static void main(String[] args){
        /**方法一： 散落在memory中
         * each row is contiguous in memory,
         * but that element 5 and 6 are not contiguous in memory.
         * 貌似是每个元素（5*6）都不挨着
         */
        int[][] a = new int[5][]; //Først alloker et array med 5 pekere til int[]
        for(int i = 0; i < a.length; i++){
            a[i] = new int[6];  //Så, for hver peker, alloker et int-array med lengde 6
        }
        a[3][4] = 9;
        //System.out.println(a[3*6+4]); ERROR!!

        /**方法二： Allocate contiguous memory, more efficient
         *  貌似每个元素（5*6）都挨着
         */
        int[] a2 = new int[5*6]; // use a single index
        a2[3*6+4] = 9;  // calculated as row_number * number_of_columns + column_number:
        //System.out.println(a2[3][4]); ERROR!!
    }

}
