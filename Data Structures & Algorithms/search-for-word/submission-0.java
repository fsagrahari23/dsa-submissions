class Solution {

    int m;
    int n;

    int[][] dir = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    boolean[][] isVis;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        isVis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (solve(i, j, board, word, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    boolean solve(int i, int j,
                  char[][] board,
                  String word,
                  int idx) {

        // Entire word matched
        if (idx == word.length()) {
            return true;
        }

        isVis[i][j] = true;

        for (int[] d : dir) {

            int x = i + d[0];
            int y = j + d[1];

            if (!inBound(x, y)) {
                continue;
            }

            if (!isVis[x][y] &&
                board[x][y] == word.charAt(idx)) {

                if (solve(x, y, board, word, idx + 1)) {
                    return true;
                }
            }
        }

        // Backtrack
        isVis[i][j] = false;

        return false;
    }
}