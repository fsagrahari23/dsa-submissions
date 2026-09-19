class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indeg = new int[numCourses];

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        // Build graph
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adjList.putIfAbsent(prerequisite, new ArrayList<>());
            adjList.get(prerequisite).add(course);

            indeg[course]++;
        }

        Queue<Integer> que = new LinkedList<>();

        // Courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                que.offer(i);
            }
        }

        int count = 0;

        while (!que.isEmpty()) {
            int node = que.poll();
            count++;

            for (int ne : adjList.getOrDefault(node, new ArrayList<>())) {
                indeg[ne]--;

                if (indeg[ne] == 0) {
                    que.offer(ne);
                }
            }
        }

        return count == numCourses;
    }
}