// 1091. Shortest Path in Binary Matrix

// constraints
// 1. the range of dimesion of matrix

// edge cases
// 1. starting cell grid[0][0] or endoing cell grid[n-1][n-1] = 1, return -1
// 2. grid is 1*1 and grid[0][0] = 1, return 1;

// basic idea
// since we need to find all possible paths, we need to use bfs
// simple bfs worst case is O(n^2), bidirectional bfs search simultaneously from both start and end, stopping when two searches meet
// making it twice as fast as regular bfs, O(n^2/2)
// initialize a queue, start from (0, 0), store (x, y, distance)
// initialize a set, track nodes visited from (0, 0)

// coding

import java.util.*;

public class BinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        // 8 directions
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // (x, y, distance)
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while(! queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], step = curr[2];
            if (x== n-1 && y == n-1) {
                return step;
            }
            for (int[] dir: directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, step+1});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
        BinaryMatrix solution = new BinaryMatrix();
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0},
        };
        System.out.println(solution.shortestPathBinaryMatrix(grid));
        
        int[][] grid1 = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 1, 0},
        };
        System.out.println(solution.shortestPathBinaryMatrix(grid1));
    }

    
}

// time complexity
