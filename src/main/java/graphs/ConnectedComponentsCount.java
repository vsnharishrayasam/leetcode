package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConnectedComponentsCount {


    static void dfs_helper(int i, Map<Integer, ArrayList<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        if (!graph.containsKey(i)) {
            return;
        }
        for (int neighbor : graph.get(i)) {
            if(!visited[neighbor]) {
                dfs_helper(neighbor, graph, visited);
            }

        }
    }


    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {
        if (n <= 0) return 0;
        if (edges.isEmpty()) return n;

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
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

        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs_helper(i, graph, visited);
            }
        }


        return connectedComponents;
    }


    public static void main(String[] args) {
        /*
        {
"n": 5,
"edges": [[0 ,1], [1, 2], [0, 2], [3, 4]]
}

output: 2


        {
            "n": 4,
                "edges": [[0 , 1], [0 , 3], [0 , 2], [2 , 1], [2 , 3]]
        }

     output: 1

*/

        int n = 5;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));

        System.out.println(number_of_connected_components(n, edges));

    }
}
