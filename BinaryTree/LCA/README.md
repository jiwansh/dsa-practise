### **Lowest Common Ancestor (LCA) of a Binary Tree (LeetCode 236)**

**Problem Statement**
The goal is to find the **Lowest Common Ancestor (LCA)** of two nodes, **p** and **q**, in a binary tree. The LCA is the deepest node in the tree that has both **p** and **q** as descendants.

**Main Logic:** We use a **Bottom-Up Recursive Search**. Each node asks its children if they have found **p** or **q**. The first node that receives a "found" signal from both its left and right subtrees identifies itself as the junction point, which is the LCA.

---

### **Approach 1: The Path-Comparison Method (Initial Approach)**

**Logic and Thinking Process:**

1. **Find Paths:** Find the complete path from the **Root to p** and store it in a list.
2. **Find Paths:** Find the complete path from the **Root to q** and store it in a second list.
3. **Compare:** Iterate through both lists simultaneously starting from the root.
4. **Identify LCA:** The last node that is identical in both lists before they diverge is the LCA.

**Why it is not the "Most Optimized":**

* **Space Overhead:** Storing two full paths requires **O(N)** extra space in the worst case (a skewed tree).
* **Redundant Work:** You traverse the tree multiple times and use `addAll` operations, which create extra copies of lists and increase the constant time factor.

---

### **Approach 2: The Optimized DFS Method (The "Messenger" Logic)**

**Logic and Thinking Process:**
This approach uses **Post-Order Traversal** to report findings upward without storing paths.

1. **Base Case:** If the current node is **null**, **p**, or **q**, return the current node.
2. **The Search:** Recurse into the left and right children.
3. **The Decision (Junction vs. Messenger):**
* **Case A (The Junction):** If the left and right recursion both return a non-null value, it means **p** is on one side and **q** is on the other. This current node is the **LCA**.
* **Case B (The Messenger):** If only one child returns a node and the other returns **null**, it means both targets are in the same subtree or only one has been found. We "message" (return) that found node up to the parent.

---

### **Detailed Answers to Some Doubts**

**Doubt 1: How are we sure the "Messenger" doesn't miss a deeper LCA?**
Because recursion processes the tree from bottom to top, the **very first** node that sees both **p** and **q** coming from its children will capture itself as the LCA. Once that "LCA Node" is returned to its parent, the parent will see a result on one side and **null** on the other, so it simply continues passing that already-found LCA upward. It acts as a messenger for the result found deeper down.

**Doubt 2: What if p or q is not present in the tree?**
The standard optimized code **assumes both nodes exist**. If **p** exists but **q** is missing, the code will find **p**, think it might be the LCA, and return it all the way to the root. To fix this for cases where nodes might be missing, you must use **boolean flags** (e.g., `pFound`, `qFound`) and traverse the **entire tree** to confirm both targets were actually touched.

---

### **Complexity Analysis**

* **Time Complexity:** **O(N)** because we visit every node in the tree exactly once.
* **Space Complexity:** **O(H)** where **H** is the height of the tree. This is the space used by the recursion stack. No extra lists or builders are used.

---

### **Edge Cases**

* **p is an ancestor of q:** The recursion hits **p**, returns it immediately, and **p** is correctly returned as the LCA.
* **Nodes in separate subtrees:** The recursion finds them in different branches; the node where they meet (junction) returns itself.
* **Single Node Tree:** If the root is **p** or **q**, it returns the root.

---

### **Similar Problems**

* **LCA of a Binary Search Tree (LeetCode 235):** Uses node values to decide whether to move left or right without searching the whole tree.
* **LCA of a Binary Tree II (LeetCode 1644):** Requires handling missing nodes using the boolean flag logic.

---
