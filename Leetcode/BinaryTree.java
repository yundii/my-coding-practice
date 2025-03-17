// 102. Binary Tree Level Order Traversal
// the property of binary tree: has two children, left child and right child.

// constraints
// 1. the range of node value
// 2. the range of number of nodes

// edge cases
// 1. empty tree
// 2. has one node

// basic idea
// use a queue for level order traversal
// start from the root node, proceed nodes level by level, take the nodes of this level, add all their childnode into the queue,
// remove the previous level, add a list of this level into res arraylist.

// coding

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int i) {
        val = i;
    }
}

public class BinaryTree {
    public List<List<Integer>> leverOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);

        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree solution = new BinaryTree();

        // test case 1
        TreeNode emptyTree = null;
        System.out.println(solution.leverOrder(emptyTree));

        // test case 2
        TreeNode tree1 = new TreeNode(1);
        System.out.println(solution.leverOrder(tree1));

        // test case 3
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(12);
        tree2.right.left = new TreeNode(5);
        tree2.right.right = new TreeNode(7);
        System.out.println(solution.leverOrder(tree2));
    }
}
