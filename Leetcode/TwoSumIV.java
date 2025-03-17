// constraints

// edge cases

// basic idea
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int i) {
        val = i;
    }
}

class TwoSumIV {
    public boolean twoSum(TreeNode root, int k) {
        HashSet<Integer> visited = new HashSet<>();
        return dfs(root, k, visited);
    }

    private boolean dfs(TreeNode node, int target, HashSet<Integer> hset) {
        if (node == null) return false;
        if (hset.contains(target-node.val)) {
            return true;
        }else {
            hset.add(node.val);
        }
        return dfs(node.left, target, hset) || dfs(node.right, target, hset);

    }
    public static void main(String[] args) {
        TwoSumIV solution = new TwoSumIV();
        // Edge case 1: BST has one node
        TreeNode root1 = new TreeNode(1);
        System.out.println(solution.twoSum(root1, 3));
        // Edge case 2: BST is null
        System.out.println(solution.twoSum(null, 0));
        // Edege case 3: 
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(-1);
        root3.right = new TreeNode(1);
        System.out.println(solution.twoSum(root3, 0));
        // Edge case 4: all value is larger than k
        TreeNode root4 = new TreeNode(5);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(8);
        System.out.println(solution.twoSum(root4, 1));


    }
}

// time complexity : O(n) space complexity: O(n)