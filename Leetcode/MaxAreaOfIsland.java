// 695. Max Area of Island

// constraints
// 1. what are the dimensions of the grid? (maximum m and n value)
// 2. can we modify the input grid(marked as visited ) or we need an extra visited matrix

// edge cases
// 1. grid contains only 1
// 2. grid contains only 0
// 3. empty grid

// basic idea
// go through all the '1's, when we find a '1', we find an island, use dfs or bfs to visit all connected '1's, 
// record the maximum area of island which is the maximum numbe of connected '1's
// return max area

// coding 
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        // edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;

    }

    private int dfs (int[][] grid, int i, int j) {
        // base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        // visit all four directions (up, down, left, right)
        area += dfs(grid, i-1, j);
        area += dfs(grid, i+1, j);
        area +=dfs(grid, i, j-1);
        area += dfs(grid, i, j+1);
        return area;
    }
    
    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        // test case1
        int[][] emptyGrid = new int[0][0];
        System.out.println(solution.maxAreaOfIsland(emptyGrid));

        // test case2
        int[][] grid1 = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
        };
        System.out.println(solution.maxAreaOfIsland(grid1));
        
        // test case 3
        int[][] grid2 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        System.out.println(solution.maxAreaOfIsland(grid2));        
    }

}
