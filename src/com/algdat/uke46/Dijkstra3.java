package com.algdat.uke46;

import java.util.Arrays;

/**
 * 根据老师上课讲的例子，自己在网上找到的代码，带入而成
 * 并且打印出path
 */
public class Dijkstra3 {
    public static int M = 100000;
    //定义10个顶点
    private static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static void main(String[] args) {
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{M, M, 10, 12, M, M, M, M, M, M};
        matrix[1] = new int[]{M, M, M, M, M, M, M, 9, 12, 13};    //The shortest way from A to B is A -> D -> E -> H -> B = 45
        matrix[2] = new int[]{10, M, M, 11, M, 12, 13, M, M, M};  //The shortest way from A to C is A -> C = 10
        matrix[3] = new int[]{12, M, 11, M, 11, 12, 11, M, M, M}; //The shortest way from A to D is A -> D = 12
        matrix[4] = new int[]{M, M, M, 11, M, M, M, 13, 11, M};   //The shortest way from A to E is A -> D -> E = 23
        matrix[5] = new int[]{M, M, 12, 12, M, M, M, M, 12, 11};  //The shortest way from A to F is A -> C -> F = 22
        matrix[6] = new int[]{M, M, 13, 11, M, M, M, M, 11, 12};  //The shortest way from A to G is A -> C -> G = 23
        matrix[7] = new int[]{M, 9, M, M, 13, M, M, M, 10, M};    //The shortest way from A to H is A -> D -> E -> H = 36
        matrix[8] = new int[]{M, 12, M, M, 11, 12, 11, 10, M, M}; //The shortest way from A to I is A -> C -> F -> I = 34
        matrix[9] = new int[]{M, 13, M, M, M, 11, 12, M, M, M};   //The shortest way from A to J is A -> C -> F -> J = 33

        //调用dijstra算法计算最短路径
        dijkstra(matrix, 0);  //[0, 45, 10, 12, 23, 22, 23, 36, 34, 33]
    }
    public static void dijkstra(int[][] matrix, int start){
        boolean[] visitedVertex = new boolean[matrix.length];
        int[] shortestPath = new int[matrix.length];
        String[] path = new String[matrix.length];
        //初始化最初的最短路径[0, M, 10, 12, M, M, M, M, M, M]
        //初始化最初的路径 A -> 各个顶点
        for(int i = 0; i < matrix.length; i++){
            shortestPath[i] = matrix[start][i];
            path[i] = vertex[start] + " -> " + vertex[i];
        }
        //每循环一次就更新一次shortestPath，从i=1开始！！因为n个顶点循环n-1次就可以
        for(int i = 1; i < matrix.length; i++) {
            int min = M;
            int index = 0; //表示在不同数组中（visitedVertex，shortestPath等）每个顶点的状态
            for(int j = 0; j < matrix.length; j++) {
                //j != start，因为自己到自己没意义，貌似。。。
                //!visitedVertex[j] 这点必须没有使用过
                //shortestPath[j] < min 这里是为了找到shortestPath中最短的一条路径，即从start开始到哪一个点距离最短
                if(j != start && shortestPath[j] < min && !visitedVertex[j]) {
                    min = shortestPath[j];
                    index = j;
                }
            }
            //找到以后，这点在visitedVertex中就变成了已经使用过的点，之后的路径可以通过这点来到达
            visitedVertex[index] = true;
            //利用已经为true的点，来继续寻找最短路径
            for (int j = 0; j < matrix.length; j++) {
                //j == index，不知道为啥，貌似是因为自己到自己没意义继续比较
                //matrix[index][j] == M，不知道为啥，貌似是因为如果是最大值没意义继续比较
                if (j == index || matrix[index][j] == M) {
                    continue; //意思是，跳过之后的运算，从新一轮循环开始
                }
                //如果从顶点到已经使用过的点的距离 + 从已经使用过的点到目标点的距离 小于 从顶点到目标点的距离
                //那么，就将从顶点到目标点的距离更新为 从顶点到已经使用过的点的距离 + 从已经使用过的点到目标点的距离
                //因为这里是要更新shortestPath数组
                if (shortestPath[index] + matrix[index][j] < shortestPath[j]) {
                    shortestPath[j] = shortestPath[index] + matrix[index][j];
                    path[j] = path[index] + " -> " + vertex[j]; //更新路径，即 A->G->F等，举个例子。。。
                }
            }
        }

        //Print paths
        for(int j = 0; j < matrix.length; j++){
            if(j != start) {
                if (shortestPath[j] == M) {
                    System.out.println("There is no way from "+ vertex[start] + " to " + vertex[j]);
                } else {
                    System.out.println("The shortest way from " + vertex[start] + " to " + vertex[j] + " is " + path[j] + " = " + shortestPath[j]);
                }
            }
        }
    }
}
