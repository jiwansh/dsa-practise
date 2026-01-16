package BinaryTree;

import java.util.*;

class SingleIterativeTraversal{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        SingleIterativeTraversal tree = new SingleIterativeTraversal();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(5);
        root.left.left = tree.new TreeNode(3);
        root.left.right = tree.new TreeNode(4);
        root.right.left = tree.new TreeNode(6);
        root.right.right = tree.new TreeNode(7);

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        singleTraversal(root, preorder, inorder, postorder);

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
    static class Pair{
        TreeNode t;
        int num;

        Pair(TreeNode t, int num){
            this.t =t;
            this.num = num;
        }
    }
    private static void singleTraversal(TreeNode root, List<Integer> preorder, List<Integer> inorder,
            List<Integer> postorder) {
       if(root==null){
        return;      
     }
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root, 1));
    
    while(!st.isEmpty()){
        Pair it = st.pop();

        if(it.num ==1){
           preorder.add(it.t.val);
           it.num++;
           st.push(it);

           if(it.t.left!=null){
            st.push(new Pair(it.t.left, 1));
           }
        }
        else if(it.num ==2){
          inorder.add(it.t.val);
          it.num++;
          st.push(it);

          if(it.t.right !=null){
             st.push(new Pair(it.t.right,1));
          }
        }
        else{
            postorder.add(it.t.val);
        }
    }
    }
}