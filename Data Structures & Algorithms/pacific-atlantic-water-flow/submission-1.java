class Solution {

    int[][] dir = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        List<List<Integer>> list = new ArrayList<>();

        HashSet<Integer> map = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int key = i * n + j;

                if (map.contains(key)) {
                    list.add(Arrays.asList(i, j));
                    continue;
                }

                if (solve(i, j, heights, map)) {
                    map.add(key);
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }

    boolean solve(
        int i,
        int j,
        int[][] heights,
        HashSet<Integer> map
    ) {

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{i, j});

        boolean[][] isVis = new boolean[m][n];
        isVis[i][j] = true;

        boolean pac = false;
        boolean atl = false;

        while (!que.isEmpty()) {

            int[] arr = que.poll();

            int ci = arr[0];
            int cj = arr[1];

            for (int[] d : dir) {

                int ni = ci + d[0];
                int nj = cj + d[1];

                if (ni < 0 || nj < 0) {
                    pac = true;
                    continue;
                }

                if (ni >= m || nj >= n) {
                    atl = true;
                    continue;
                }

                if (isVis[ni][nj]) {
                    continue;
                }

                if (heights[ni][nj] > heights[ci][cj]) {
                    continue;
                }

                int key = ni * n + nj;

                if (map.contains(key)) {
                    return true;
                }

                isVis[ni][nj] = true;

                que.add(new int[]{ni, nj});
            }
        }

        return pac && atl;
    }
}