package graphs;

import java.util.*;

public class BipartiteGraph {
    public static boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int[] color = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(color[i] != 1 && color[i] != 2) {
                if(!dfs_helper(graph, i, color)) {
                    return false;
                }
            }
        }

    return true;

    }

    static boolean dfs_helper(int[][] graph, int i, int[] color) {
        if(color[i] != 0) {
            return true;
        }
        if(color[i] != 1 && color[i] != 2) {
            color[i] = 1;
        }

        for(int j = 0; j < graph[i].length; j++) {
            int neighbor = graph[i][j];
            if(color[neighbor] != 0 && color[neighbor] == color[i]) {
                return false;
            }
            if(color[i] == 1) {
                color[neighbor] = 2;
            } else if(color[i] == 2) {
                color[neighbor] = 1;
            }
            if (!dfs_helper(graph, neighbor, color)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] graph1 = new int[4][4];
        graph1[0] = new int[]{1, 2, 3};
        graph1[1] = new int[]{0, 2};
        graph1[2] = new int[]{0, 1, 3};
        graph1[3] = new int[]{0, 2};


        int[][] graph2 = new int[4][4];
        graph2[0] = new int[]{1, 3};
        graph2[1] = new int[]{0, 2};
        graph2[2] = new int[]{1, 3};
        graph2[3] = new int[]{0, 2};

        int[][] graph3 = new int[5][5];
        graph3[0] = new int[]{3};
        graph3[1] = new int[]{2, 4};
        graph3[2] = new int[]{1};
        graph3[3] = new int[]{0, 4};
        graph3[4] = new int[]{1, 3};

        System.out.println(isBipartite(graph1));
    }
}
