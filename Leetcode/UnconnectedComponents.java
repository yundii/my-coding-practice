// 323. Number of Connected Components in an Undirected Graph

// constraints
// 1. the maximum value of n
// 2. is there duplicate edge in edges list
// 3. self edge? 

// edge cases
// 1. (1, []): 1
// 2. (n, []): n

// basic idea
// dfs, set to record visited nodes, 

import java.util.*;

public class UnconnectedComponents {
    public int countComponents(int n, int[][] edges) {
        // step 1: build adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int j = 0; j < edges.length; j++){
            int node1 = edges[j][0];
            int node2 = edges[j][1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        // step2: dfs to find all components
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;


    }
    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor: adjList.get(node)){
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        UnconnectedComponents solution = new UnconnectedComponents();
        // case1 (1, [])
        int[][] edges1 = new int[][]{};
        System.out.println(solution.countComponents(1, edges1));

        // case 2 
        int[][] edges2 = new int[][]{{0, 1}};
        System.out.println(solution.countComponents(3, edges2));
    }
    
}
