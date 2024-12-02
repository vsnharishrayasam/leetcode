package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DFSEdgeList {

    static void dfs_helper(int source, int[] visited, Map<Integer, ArrayList<Integer>> adjacencyMap, ArrayList<Integer> output) {
        visited[source] = 1;
        output.add(source);
        if(adjacencyMap.containsKey(source)) {
            for(int neighbor: adjacencyMap.get(source)) {
                if (visited[neighbor] == 0) {
                    dfs_helper(neighbor, visited, adjacencyMap, output);
                }
            }

        }
    }

    static ArrayList<Integer> dfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer> output = new ArrayList<>();
        if (n <= 0) {
            return output;
        }
        int[] visited = new int[n];
        Map<Integer, ArrayList<Integer>> adjacencyMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            if(!adjacencyMap.containsKey(u)) {
                adjacencyMap.put(u, new ArrayList<>());
            }
            if(!adjacencyMap.containsKey(v)) {
                adjacencyMap.put(v, new ArrayList<>());
            }
            adjacencyMap.get(u).add(v);
            adjacencyMap.get(v).add(u);

        }
        // At this point the adjacencyList is constructed

        for(int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs_helper(i, visited, adjacencyMap, output);
            }
        }



        return output;
    }


    public static void main(String[] args) {
        /*
{
"n": 6,
"edges": [
[0, 1],
[0, 2],
[1, 4],
[3, 5]
]
}
Output:

[0, 1, 4, 2, 3, 5]
Below are some other valid outputs if the DFS traversal starts from the vertex 0:

[0, 2, 1, 4, 5, 3]
[0, 2, 1, 4, 3, 5]
[0, 1, 4, 2, 5, 3]
DFS starting from any other node will also be considered valid.

Notes
There are n nodes in the graph and each node has a distinct value from 0 to n - 1.
Edges are represented in the form of a two-dimensional list where each inner list consists of two values [u, v]. This represents an undirected edge from node u to node v.
The list won't contain duplicate edges. That is, if [u, v] is present, then there will be no other occurrence of [u, v] or [v, u].
If multiple DFS traversals exist, you may return any.
Constraints:

1 <= n <= 104
0 <= number of edges <= 104
0 <= value of each vertex <= n - 1
No self loop is present.


        * */

        ArrayList<ArrayList<Integer>> edges = new ArrayList();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4)));
        edges.add(new ArrayList<>(Arrays.asList(3, 5)));

        System.out.println(dfs_traversal(6, edges));


    }

}
