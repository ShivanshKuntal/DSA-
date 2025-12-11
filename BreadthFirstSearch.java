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

    // Method to perform Breadth-First Search starting from a given vertex
    void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];  // Mark all vertices as not visited
        LinkedList<Integer> queue = new LinkedList<>(); // Create a queue for BFS

        // Mark the start vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            // Dequeue a vertex from the queue and print it
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            Iterator<Integer> i = adjList[startVertex].listIterator();
            while (i.hasNext()) {
                int adjVertex = i.next();
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    // Main method to test the BFS implementation
    public static void main(String args[]) {
        Graph g = new Graph(6);  // Create a graph with 6 vertices

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("Breadth-First Traversal starting from vertex 0:");

        // Perform BFS starting from vertex 0
        g.BFS(0);
    }
}
