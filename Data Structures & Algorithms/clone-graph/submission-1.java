class Solution {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Queue<Node> que = new LinkedList<>();

        // Create clone of starting node
        map.put(node, new Node(node.val));

        que.offer(node);

        while (!que.isEmpty()) {

            Node curr = que.poll();

            for (Node neighbor : curr.neighbors) {

                // If neighbor hasn't been cloned
                if (!map.containsKey(neighbor)) {

                    map.put(
                        neighbor,
                        new Node(neighbor.val)
                    );

                    que.offer(neighbor);
                }

                // Connect cloned current node
                // to cloned neighbor
                map.get(curr).neighbors.add(
                    map.get(neighbor)
                );
            }
        }

        return map.get(node);
    }
}