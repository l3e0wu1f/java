
/**
 * class MyGraph. Will use Matrix to represent a simple weighted directed graph. There is no loop at vertex.
 * No more than one edge from vertex i to another vertex j. The vertices are numbered as 1, 2, ..., n
 * The graph with n vertices is reprented by an (n+1) by (n+1) matrix with row 0 and column 0 unused.
 * If there is an edge from vertex i to vertex j (i != j), then entry on row i column j of the matrix will 
 * be 1. If there is no edge between vertex i to vertex j (i != j), then the entry on row i column j of the 
 * matrix will be Integer.MAX_VALUE
 * 
 * @author Josh Lewis
 * @version 04-28-2019
 */
import java.util.*;
public class MyGraph
{
    private int[][] graph;
    private int numberOfVertices;
    
    /**
     * create a graph with given number of vertices with no edges
     * @param numberOfVertices number of vertices of the graph
     */
    public MyGraph(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
        graph = new int[numberOfVertices+1][numberOfVertices+1];
    }
    
    /**
     * create a graph with given matrix representation
     * @param graph The matrix representation on the given graph. Assume column 0 and row 0 are not used
     */
    public MyGraph(int [][] graph){
        this.graph = graph;
        // change any 0 to infinity if the 0 is not on diagonal
        for(int i = 1; i < graph.length; i++){
            for(int j = 1; j < graph.length; j++){
                if(i == j) graph[i][j] = 0;
                else if(i != j && graph[i][j] == 0)
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        numberOfVertices = graph.length - 1; 
    }
    
    /**
     * return a String that represent the vertices in order if the BFS algorithm is used to traversal the graph
     * starting from the given vertex. If the startVertex not exists, return an error message
     * @param startVertex The vertex where the traversal starts
     * @return A String that describes the vertices visited in order
     */
    public String bfs(int startVertex){
        
        if (startVertex < 1 || startVertex > numberOfVertices)
            System.out.print("Invalid vertex!");
        String visitedList = "";
        LinkedList<Integer> visited = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        
        int presentVertex = startVertex;
        while (visited.size() != numberOfVertices) {
            visitedList += " " + presentVertex;
            visited.add(presentVertex);
            for (int i = 0; i < numberOfVertices; i++)
                if (graph[presentVertex][i] != Integer.MAX_VALUE && !visited.contains(i) && !queue.contains(i))
                    queue.add(i);
            if (queue.isEmpty())
                break;
            else
                presentVertex = queue.remove(0);
        }
        
        return visitedList;
    }
    
    /**
     * return a String that represents the vertices in order if the DFS algorithm is used to traversal the graph
     * starting from the given vertex. If the startVertex not exist, return an error message
     * @param startVertex The vertex where the traversal starts
     * @return An ArrayList of Integer that represents the vertices visited in order
     */
    public String dfs(int startVertex){
        if (startVertex < 1 || startVertex > numberOfVertices)
            System.out.print("Invalid vertex!");
        String visitedList = "";
        
        LinkedList<Integer> visited = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        
        int presentVertex = startVertex;
        while (visited.size() != numberOfVertices) {
            queue.add(presentVertex);
            boolean flag = false;
            visitedList += " " + presentVertex;
            for (int i = 0; i < numberOfVertices; i++)
                if (graph[presentVertex][i] != Integer.MAX_VALUE && !visited.contains(i) && !queue.contains(i)) {
                    queue.add(i);
                    flag = true;
                }
            if (!flag)
                visited.add(presentVertex);
            if (queue.isEmpty())
                break;
            else
                presentVertex = queue.remove(queue.size() - 1);
        }
        return visitedList;
    }
}
