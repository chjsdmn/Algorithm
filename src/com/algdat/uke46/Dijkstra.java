package com.algdat.uke46;

/**
 * https://www.cxyzjd.com/article/qq_40554133/104417517
 * 自己在网上找到的代码
 *  有打印path， 但是不太明白。。。
 */
public class Dijkstra {
    public static int M = 100000;
    //定义七个顶点
    private static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    public static void main(String[] args) {
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{M, 5, 7, M, M, M, 2};   //A到B的最短路径为：A->B，最短距离是：5
        matrix[1] = new int[]{5, M, M, 9, M, M, 3};  //A到C的最短路径为：A->C，最短距离是：7
        matrix[2] = new int[]{7, M, M, M, 8, M, M};  //A到D的最短路径为：A->G->F->D，最短距离是：12
        matrix[3] = new int[]{M, 9, M, M, M, 4, M};  //A到E的最短路径为：A->G->E，最短距离是：6
        matrix[4] = new int[]{M, M, 8, M, M, 5, 4};  //A到F的最短路径为：A->G->F，最短距离是：8
        matrix[5] = new int[]{M, M, M, 4, 5, M, 6};  //A到G的最短路径为：A->G，最短距离是：2
        matrix[6] = new int[]{2, 3, M, M, 4, 6, M};
        //调用dijstra算法计算最短路径
        dijstra(matrix, 0);
    }
    public static void dijstra(int[][] matrix, int start) {
        //最短路径长度
        int[] shortestPath = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visitedPunkt= new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = vertex[start] + "->" + vertex[i];
        }

        //初始化起点，将起点放入S
        shortestPath[start] = 0;
        visitedPunkt[start] = 1;

        for (int i = 1; i < matrix.length; i++) {       //i从1开始，因为起点已经加入S了
            int min = M;
            int index = -1;

            //找出某节点到起点路径最短
            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visitedPunkt[j] == 0 && matrix[start][j] < min) {
                    min = matrix[start][j];  //2, 即 A 到 G
                    index = j;  //index = 6
                }
            }

            //更新最短路径，标记起点到该节点的最短路径已经求出
            shortestPath[index] = min; //第一次循环结束时 shortestPath[6] = 2;
            visitedPunkt[index] = 1;   //第一次循环结束时 visitedPunkt[6] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visitedPunkt[m] == 0 && matrix[start][index] + matrix[index][m] < matrix[start][m]) {
                    matrix[start][m] = matrix[start][index] + matrix[index][m];
                    path[m] = path[index] + "->" + vertex[m];
                }
            }
        }

        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != start) {
                if (shortestPath[i] == M) {
                    System.out.println(vertex[start] + "到" + vertex[i] + "不可达");
                } else {
                    System.out.println(vertex[start] + "到" + vertex[i] + "的最短路径为：" + path[i] + "，最短距离是：" + shortestPath[i]);
                }
            }
        }
    }
}


