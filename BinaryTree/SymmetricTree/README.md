### Symmetric Tree (LeetCode 101)
A symmetric tree is essentially a mirror image of itself around its center. In terms of tree structure, this means the left subtree must be a mirror of the right subtree.

## Problem Statement 
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## Logic & Thinking Process 
To determine if a tree is symmetric, we don't compare a node with its own children; instead, we compare two subtrees (left and right) simultaneously.

## Mirror Condition: 
For two nodes to be mirrors of each other:

Their values must be equal.

The left child of the left node must be a mirror of the right child of the right node.

The right child of the left node must be a mirror of the left child of the right node.

The "Fold" Intuition: Imagine folding the tree down the middle. If the nodes overlap perfectly with matching values, the tree is symmetric.

## Data Structure & Algorithm Used

Recursion (DFS): We use a recursive helper function to traverse two nodes at a time.

Boolean Logic: The symmetry of the current level depends on the symmetry of all levels below it, requiring a series of AND operations.

## Complexity Analysis

Time Complexity: O(N) — We visit every node in the tree once to perform the comparison.

Space Complexity: O(H) — Where H is the height of the tree, representing the maximum depth of the recursion stack. In the worst case (skewed tree), this is O(N).

## Edge Cases

Single Node Tree: The root is passed to isSymmetric, which then calls helper(null, null), returning true. Correct.

Asymmetric Values: If the structure matches but values differ (e.g., left is 2, right is 3), left.val != right.val catches it.

Asymmetric Structure: If the left subtree has a node where the right doesn't, left == null || right == null combined with left == right catches the mismatch.

## Similar Problems

Same Tree (LeetCode 100): Check if two trees are identical (not mirrors).

Invert Binary Tree (LeetCode 226): Physically transform a tree into its mirror image.

Flip Equivalent Binary Trees: Check if trees can be made identical by flipping subtrees