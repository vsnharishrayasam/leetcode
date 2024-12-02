package graphs;


public class dfs {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Edge e1 =  new Edge(vertex1, vertex2, 0);
        Edge e2 =  new Edge(vertex2, vertex3, 1);
        Edge e3 =  new Edge(vertex3, vertex4, 2);
        Edge e4 =  new Edge(vertex4, vertex5, 3);
        vertex1.edges.add(e1);
        vertex2.edges.add(e2);
        vertex3.edges.add(e3);
        vertex4.edges.add(e4);
        hasCycle(vertex1);

    }

    static boolean hasCycle(Vertex root) {
        int[] visited = new int[5];
        dfs(root, visited);
        return false;

    }

    static void dfs(Vertex root, int[] visited) {
        if (root == null) {
            return;
        }
        visited[root.v] = 1;
        System.out.println("Visiting " + root.v);
        for(Edge e: root.edges) {
           if(visited[e.end.v] == 1) {
               //already visited
           }
           else {
               dfs(e.end, visited);
           }
        }

    }



}
