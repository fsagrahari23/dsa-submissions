class Solution {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // Original graph -> adjacency list
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {

            Node no = que.poll();

            if (map.containsKey(no.val)) {
                continue;
            }

            map.put(no.val, new ArrayList<>());

            for (Node n : no.neighbors) {

                map.get(no.val).add(n.val);

                // Visit this node later
                if (!map.containsKey(n.val)) {
                    que.offer(n);
                }
            }
        }

        // Now map contains the complete adjacency list

        // Create all nodes
        HashMap<Integer, Node> nodes = new HashMap<>();

        for (int val : map.keySet()) {
            nodes.put(val, new Node(val));
        }

        // Connect the nodes
        for (int val : map.keySet()) {

            Node curr = nodes.get(val);

            for (int neighbor : map.get(val)) {
                curr.neighbors.add(nodes.get(neighbor));
            }
        }

        return nodes.get(node.val);
    }
}