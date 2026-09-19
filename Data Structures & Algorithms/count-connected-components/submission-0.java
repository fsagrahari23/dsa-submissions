class Solution {
    int[] parent;
    int[] rank;

    void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    void union(int a, int b) {
        int px = find(a);
        int py = find(b);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } 
        else if (rank[px] < rank[py]) {
            parent[px] = py;
        } 
        else {
            parent[py] = px;
            rank[px]++;
        }
    }

    int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        init(n);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return set.size();
    }
}