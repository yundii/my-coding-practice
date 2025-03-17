// 261. Graph Valid Tree
// connected acyclic undirected graph 
// n nodes with n-1 edges

// constraints
// what is the maximum possible value for n
// is there duplicate edge in the input
// can the graph have self-edges?
// will the input contain at least one edge? 

// edge cases
// 1. not n nodes with n-1 edges: false
// 2. one node: true

// basic idea
// bfs and dfs both works,
// but bfs is better for this question because using a queue to visit neighbors level bu level, make sure we visit each node once, 
// it is better for detect cycles and check connectivity, and avoid deep recursion.

// queue & hset, adjecent list 

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }
        // step1: build adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < edges.length; j++) {
            int node1 = edges[j][0];
            int node2 = edges[j][1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        // step 2: use bfs to check connectivity and cycle
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hset = new HashSet<>();
        hset.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor: adjList.get(curr)) {
                if (hset.contains(neighbor)) continue;
                queue.add(neighbor);
                hset.add(neighbor);
            }

        }
        return hset.size() == n;

    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        // test case1: valid tree
        int[][] case1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution.validTree(5, case1));
        // test case2: exist cycle
        int[][] case2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {1, 4}};
        System.out.println(solution.validTree(5, case2));
        // test case3: unconnected
        int[][] case3 = {{0, 1}, {2, 3}};
        System.out.println(solution.validTree(4, case3));
    }
    
}
