
class Solution {
    class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
    public boolean isSumProperty(Node root) {
        // Base Case 1: Null nodes are valid
        if (root == null)
            return true;
        
        // Base Case 2: Leaf nodes are valid by default
        if (root.left == null && root.right == null)
            return true;
        
        int currSum = 0;
        
        // Accumulate child values
        if (root.left != null)
            currSum += root.left.data;
        
        if (root.right != null)
            currSum += root.right.data;
      
        // If current node fails the property, return false immediately
        if (root.data != currSum)
            return false;
        
        // Recursively check left and right subtrees
        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}
