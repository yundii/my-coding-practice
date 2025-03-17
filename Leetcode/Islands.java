// 200. Number of Islands

// constraints
//1. What are the dimensions of the grid? (e.g., maximum m and n values?)
//2. Can we modify the input grid (e.g., marking visited cells)? If not, we may need an extra visited matrix.

// edge cases
// 1. grid contains only 0
// 2. grid contains only 1

// basic idea
// the basic idea is to go through all '1's, when we find a '1', it means we find a new island.
// then, we use dfs or bfs to visit all connected '1's, mark them as visited. to avoid counting the same island multiple times,
// we keep a counter and increase it each time we find a new island. At the end, we return counter

// loop through the grid, when we find a '1', increase the counter

// use dfs to mark the entire island
// continue scanning for new island

class Islands {
    private void dfs(char[][] grid, int i, int j) {
        // base case: Stop if out of bounds or water ('0')
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // marked as visited
        grid[i][j] = '0';
        // Visit all four directions (up, down, left, right)
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // loop through the grid, when we find a '1', increase the counter
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Islands solution = new Islands();
        char[][] grid1 = null;
        System.out.println(solution.numIslands(grid1));

        char[][] emptyGrid = new char[0][0];
        System.out.println(solution.numIslands(emptyGrid));

        char[][] grid2 = {
            {'1', '1', '1', '0', '0'},
            {'0', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1'},
            {'0', '0', '1', '0', '1'},
        };
        System.out.println(solution.numIslands(grid2));
    }
}