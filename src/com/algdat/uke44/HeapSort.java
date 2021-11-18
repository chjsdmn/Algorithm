package com.algdat.uke44;

import java.util.Arrays;

/**
 * 有BUG！不是都好用！！！
 */
public class HeapSort {
    public static void main(String[] args) {
        int values[] = {-99, 5, 9, 6, 3, 20, 7};
        //int[] values = {-99,15,8,19,16,5,21,7,23,10,14,3,11,6,17,19,19};
        minimumHeapTree(values);
        System.out.println(Arrays.toString(values));  // [-99, 1, 3, 8, 9, 5]
        heapSorting(values);
        System.out.println(Arrays.toString(values));  // [-99, 9, 8, 5, 3, 1]
    }

    /**
     * 利用array的index来假象成树型进行排列
     * 假象一个minimum heap tree结构的int[]，进行heapsorting，结果是从大到小排列
     * 1.总是将array的第一个元素和最后一个元素交换
     * 2.然后将父结点和两个左右结点比较，通过交换，将其中最小的结点交换到父结点的位置
     * 3.继续将array的第一个元素和还没有交换过的最后一个元素交换
     * 4.重复2的操作
     * @param values
     */
    static void heapSorting(int[] values){
        for(int i = 1; i < values.length; i++){
            int first = 1; //因为总是和第一个元素交换，所以每次循环first总是为1
            int last = values.length - i; // 因为总是和没有交换过的最后以后元素交换，所以是length-i ！！！！
            int tmp = values[first];   //第一个元素和最后一个元素交换
            values[first] = values[last];
            values[last] = tmp;
            int current = first;   //设置当前元素，总是从第一个元素开始
            int leftChild = current * 2;  //设置假象中的左节点
            int rightChild = current * 2 + 1;  //设置假象中的右节点
            while (true){
                //当左结点的index小于最后一个元素时，比较父结点（当前结点）和两个左右结点，如果左结点最小，左节点与当前结点交换
                if(leftChild < last && values[leftChild] < values[rightChild] && values[leftChild] < values[current]){
                    int tmp2 = values[leftChild];
                    values[leftChild] = values[current];
                    values[current] = tmp2;
                    current = leftChild;  //交换后当前结点向下移动
                }
                //当右结点的index小于最后一个元素时，比较父结点（当前结点）和两个左右结点，如果右结点最小，右节点与当前结点交换
                else if(rightChild < last && values[rightChild] < values[leftChild] && values[rightChild] < values[current]){
                    int tmp2 = values[rightChild];
                    values[rightChild] = values[current];
                    values[current] = tmp2;
                    current = rightChild;   //交换后当前结点向下移动
                }

                //位置都正确，或者左右结点（index）已经超过了last结点的index，while循环break
                else{
                    break;
                }
                leftChild = current * 2;  //左结点向下移动
                rightChild = current * 2 + 1;  //右结点向下移动
            }
        }
    }

    /**
     * 假象把int[]，转化成一个minimum heap tree，即一个所有父结点都等于或小于他的子节点的komplett tree
     * @param values
     */
    static void minimumHeapTree(int[] values){
        for(int i = 0; i < values.length; i++){
            int current = i;
            int parent = i / 2;
            while (parent > 0 && values[parent] > values[current]){  //如果父比子节点大，就交换
                int tmp = values[parent];
                values[parent] = values[current];
                values[current] = tmp;
                current = parent;   //交换完毕后，向树的上方推进，将parent推出while循环，即parent==0，结束while循环
                parent = current / 2;
            }
        }
    }


}
