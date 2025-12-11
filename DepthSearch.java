import java.util.*;

// Class representing a graph using an adjacency list
class Graph {
    private int numVertices;        // Number of vertices in the graph
    private LinkedList<Integer>[] adjList; // Adjacency list

    // Constructor to initialize the graph
    Graph(int vertices) {
        numVertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    // Recursive method to perform Depth-First Search starting from a given vertex
    void DFSUtil(int vertex, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                DFSUtil(adjVertex, visited);
            }
        }
    }

    // Method to perform DFS for the entire graph
    void DFS(int startVertex) {
        // Mark all vertices as not visited initially
        boolean[] visited = new boolean[numVertices];

        // Call the recursive helper function to perform DFS traversal
        DFSUtil(startVertex, visited);
    }

    // Main method to test the DFS implementation
    public static void main(String args[]) {
        Graph g = new Graph(6);  // Create a graph with 6 vertices

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("Depth-First Traversal starting from vertex 0:");

        // Perform DFS starting from vertex 0
        g.DFS(0);
    }
}
