import java.util.*;

class Solution {
    public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // Step 1: Build undirected graph
        buildGraph(root, null);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int currentDistance = 0;

        while (!q.isEmpty()) {
            // Reach level k, collect all node values in current queue
            if (currentDistance == k) {
                for (TreeNode node : q) {
                    ans.add(node.val);
                }
                return ans;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Check all neighbors (left, right, and parent)
                // Use computeIfAbsent for cleaner logic
                for (TreeNode neighbor : map.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            currentDistance++;
        }
        return ans;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;

        // Ensure current node exists in map
        map.computeIfAbsent(node, x -> new ArrayList<>());

        if (parent != null) {
            // Parent is already in map because of top-down DFS
            map.get(node).add(parent);
            map.get(parent).add(node);
        }

        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
}
