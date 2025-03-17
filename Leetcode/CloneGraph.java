// 133. Clone Graph
// constraints
// 1. the range of number of nodes in graph
// 2. the range of node value
// 3. can graph have cycle or self-loop?
// 4. is there any disconnected node/ part?
// 5. is it guaranteed that node values are unique?
// 6. should the cloned graph have the same order of neighbors?
// 7. can graph have duplicate edges?

// edge cases
// 1. empty graph
// 2. one node with no neighbor

// basic idea
// dfs: 1. recursive hashmap 2. iterative stack & hashmap
// bfs: iterative queue & hashmap

import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int i) {
        val = i;
        neighbors = new ArrayList<>();
    }
    public Node(int i, List<Node> list) {
        val = i;
        neighbors = list;
    }
}

// coding
public class CloneGraph {
    private Map<Node, Node> hmap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (hmap.containsKey(node)) return hmap.get(node);
        Node clone = new Node(node.val);
        hmap.put(node, clone);
        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
    
    // testing
    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();
        // empty graph
        System.out.println(solution.cloneGraph(null));
        // one node with no neighbor
        Node node1 = new Node();
        System.out.println(solution.cloneGraph(node1).val);
    }
}

// time complexity


