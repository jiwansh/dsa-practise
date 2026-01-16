import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root==null)
        return ans;
        
        helper(root, new StringBuilder(),ans);
        return ans;
    }
     void helper(TreeNode root, StringBuilder curr,List<String> ans){
        if(root==null)
        return;

        int currLen = curr.length();

        if(currLen>0)
        curr.append("->");
        
        curr.append(root.val);

        if(root.left==null && root.right==null){
            ans.add(curr.toString());
        }
        
        helper(root.left,curr,ans);
        helper(root.right,curr,ans);

        curr.setLength(currLen); // backracked to initial state
      
        
    }
}