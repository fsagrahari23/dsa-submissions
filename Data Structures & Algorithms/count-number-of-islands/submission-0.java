class Solution {

    int m;
    int n;

    int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {

                    count++;

                    solve(grid, i, j);
                }
            }
        }

        return count;
    }

    boolean inBound(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    void solve(char[][] grid, int i, int j) {

        grid[i][j] = '0';

        for (int[] d : dir) {

            int x = i + d[0];
            int y = j + d[1];

            if (!inBound(x, y)) {
                continue;
            }

            if (grid[x][y] == '1') {
                solve(grid, x, y);
            }
        }
    }
}