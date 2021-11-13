package com.algdat.uke46;

import java.util.Arrays;
/**
 * 自己在网上找到的代码
 * 没有打印出path。。。
 */
public class Dijkstra2 {
    public static int[] vertex = {1, 2, 3, 4, 5, 6};
    public static int MAX = Integer.MAX_VALUE;    // 无法到达时距离设为 Integer.MAX_VALUE
    public static void main(String[] args) {
        //自己到自己设成0或者MAX都可以
        int[][] weight={
                {0,1,12,MAX,MAX,MAX},
                {MAX,0,9,3,MAX,MAX},     //From 1 til 2 er 1 -> 2 = 1
                {MAX,MAX,0,MAX,5,MAX},   //From 1 til 3 er 1 -> 2 -> 4 -> 3 = 8
                {MAX,MAX,4,0,13,15},     //From 1 til 4 er 1 -> 2 -> 4 = 4
                {MAX,MAX,MAX,MAX,0,4},   //From 1 til 5 er 1 -> 2 -> 4 -> 3 -> 5 = 13
                {MAX,MAX,MAX,MAX,MAX,0}  //From 1 til 6 er 1 -> 2 -> 4 -> 3 -> 5 -> 6 = 17
        };
        int start = 0;  // 选择出发点
        solution(weight,start);   //[0, 1, 8, 4, 13, 17]
    }

    private static void solution(int[][] weight, int start) {
        boolean[] visitedPunkt = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] shortestDistance = new int[weight.length];     // 记录 start 点到各点的最短路径长度
        String[] path = new String[weight.length];
        //初始化最短路径，即[0,1,12,MAX,MAX,MAX]
        for (int i = 0; i < shortestDistance.length; i++) {
            shortestDistance[i] = weight[start][i];
            path[i] = vertex[start] + " -> " + vertex[i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        //没查找一次，最短路径，即[0,1,12,MAX,MAX,MAX]就会被更新一次
        for(int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            // 找出一个未标记的离出发点最近的节点
            for(int j = 0; j < weight.length; j++){
                if(j != start && !visitedPunkt[j] && shortestDistance[j] < min){
                    min = shortestDistance[j];
                    index = j;
                }
            }
            // 标记该节点为已经访问过
            visitedPunkt[index] = true;

            for (int j = 0; j < weight.length; j++){
                if (j == index || weight[index][j] == Integer.MAX_VALUE) {  // index 点不能到达 j
                    continue;
                }
                if (shortestDistance[index] + weight[index][j] < shortestDistance[j]){
                    shortestDistance[j] = shortestDistance[index] + weight[index][j];  //更新最短路径, 即weight[start][i]已经和初始化不一样了
                    path[j] = path[index] + " -> " + vertex[j];
                }
            }
        }
        for(int j = 0; j < weight.length; j++){
            if(j != start){
                if(shortestDistance[j] == MAX){
                    System.out.println("There is no way from " + vertex[start] + " to " + vertex[j]);
                }
                else {
                    System.out.println("From " + vertex[start] + " to " + vertex[j] + " is " + path[j] + " = " + shortestDistance[j]);
                }
            }
        }
    }
}
