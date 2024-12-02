package graphs;

import java.util.*;

public class BFSEdgeList {

    private static ArrayList<Integer> bfs_traversal(int n, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<Integer> output = new ArrayList<>();
        if (n <= 0) {
            return output;
        }
        boolean[] visited = new boolean[n];
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (ArrayList<Integer> edge : edgeList) {
            int u = edge.get(0);
            int v = edge.get(1);
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs_helper(i, graph, output, visited);
            }
        }


        return output;

    }

    private static void bfs_helper(int i, Map<Integer, ArrayList<Integer>> graph, ArrayList<Integer> output, boolean[] visited) {

        if (!visited[i]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int u = queue.poll();
                if(visited[u]){
                    continue;
                }
                visited[u] = true;
                output.add(u);
                if (!graph.containsKey(u)) { // Important
                    continue;
                }
                for (int neighbor : graph.get(u)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        /* {
                "n": 6,
                "edges": [
                [0, 1],
                [0, 2],
                [1, 3],
                [2, 3]
                ]
                }

                [0, 1, 2, 4, 3, 5]

         */

        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<ArrayList<Integer>>();
        int n = 4;
        edgeList.add(new ArrayList<>(Arrays.asList(0, 1)));
        edgeList.add(new ArrayList<>(Arrays.asList(0, 2)));
        edgeList.add(new ArrayList<>(Arrays.asList(1, 3)));
        edgeList.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println(bfs_traversal(n, edgeList));
    }


}
