package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsGraphATree {

    static boolean dfs_helper(int root, int[] parent, boolean[] visited, Map<Integer, ArrayList<Integer>> graph) {
        // return true if you find a cycle or else continue and return false

        visited[root] = true;
        if (!graph.containsKey(root)) {
            return false;
        }
        for (int neighbor : graph.get(root)) {
            if (!visited[neighbor]) {
                parent[neighbor] = root;
                if (dfs_helper(neighbor, parent, visited, graph))
                    return true;
            } else {
                // neighbor already visited
                if (parent[root] != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

    static Boolean is_it_a_tree(Integer node_count, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {
        if (edge_start.size() != edge_end.size()) return false;
        if (edge_start.size() != node_count - 1) return false;

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edge_start.size(); i++) {
            int u = edge_start.get(i);
            int v = edge_end.get(i);
            if (!graph.containsKey(u)) graph.put(u, new ArrayList<>());
            if (!graph.containsKey(v)) graph.put(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // At this point the graph is constructed

        int[] parent = new int[node_count];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[node_count];

        if (dfs_helper(0, parent, visited, graph)) return false;

        for (int i = 0; i < node_count; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        /*
                {
                "node_count": 4,
                "edge_start": [0, 0, 0],
                "edge_end": [1, 2, 3]
                }
                OUTPUT: 1

                {
                "node_count": 4,
                "edge_start": [0, 0, 1, 2],
                "edge_end": [3, 1, 2, 0]
                }
                OUTPUT: 0
                {
                "node_count": 4,
                "edge_start": [0, 0],
                "edge_end": [1, 2]
                }
                OUTPUT: 0
                {
                "node_count": 4,
                "edge_start": [0, 0, 0, 1],
                "edge_end": [1, 2, 3, 0]
                }
                OUTPUT: 0


         */


        int node_count = 4;
        ArrayList<Integer> edge_start = new ArrayList<>(Arrays.asList(0, 0, 0));
        ArrayList<Integer> edge_end = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(is_it_a_tree(node_count, edge_start, edge_end));

    }
}
