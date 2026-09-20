class Solution {

    int[] parent;

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return false;
            }

            parent[pu] = pv;
        }

        return true;
    }

    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}