
import java.util.*;

class Solution {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        // Root starts at index 0
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            // Get the starting index of this level to normalize IDs
            int min = q.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                // Normalize current ID to prevent overflow
                int curr_id = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) first = curr_id;
                if (i == size - 1) last = curr_id;

                // Standard 2*i+1 and 2*i+2 indexing
                if (node.left != null)
                    q.offer(new Pair(node.left, curr_id * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, curr_id * 2 + 2));
            }
            // Update global max width
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}

```
