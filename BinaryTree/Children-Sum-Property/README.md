### **Children Sum Property in a Binary Tree**

**Problem Statement**
Given the root of a binary tree, check if every non-leaf node satisfies the **Children Sum Property**. This property states that for any node, its value must be equal to the **sum of the values of its left and right children**. Leaf nodes and null nodes are considered valid by default.

**Main Logic:** We perform a recursive check on each node. If a node is a leaf, it is valid. For a non-leaf node, we calculate the sum of its available children and compare it to the node's value. If they match, we recursively verify that the subtrees also follow the rule.

### **Logic and Thinking Process**

* **Base Cases:**
* A `null` node is naturally valid (`return true`).
* A **leaf node** is valid by definition because it has no children to sum up (`return true`).


* **Local Verification:** For the current node, we sum the values of `left` and `right` children (treating null as 0). If the node's data does not equal this sum, the property is violated immediately.
* **Global Propagation:** It is not enough for the root to satisfy the sum; its children must also satisfy the sum property within their own subtrees. We use the `&&` operator to ensure the truth value propagates up from the leaves to the root.

---

### **Common Pitfalls**

* **Misidentifying Leaf Nodes:** A common mistake is forgetting to check if a node is a leaf before calculating the sum. Without the `root.left == null && root.right == null` check, the code might return `false` for leaf nodes because their "child sum" (0) doesn't match their value.
* **Missing Null Checks for Children:** Attempting to access `root.left.data` without checking if `root.left` is null will cause a `NullPointerException`.
* **Not Checking the Whole Tree:**
Some beginners only check the root and its immediate children. You must recursively call the function on both subtrees to ensure the property holds throughout the entire structure.

---

### **Data Structure and Algorithm Used**

* **Recursion (DFS):** We use a top-down Depth-First Search approach to validate each node.
* **Boolean Logic:** We combine the results of the current node's check with its children's recursive checks using logical `AND`.



### **Complexity Analysis**

* **Time Complexity: O(N)** — Every node in the binary tree is visited exactly once.
* **Space Complexity: O(H)** — Where **H** is the height of the tree. This is the space used by the recursion stack. In a worst-case (skewed tree), this is **O(N)**; in a balanced tree, it is **O(log N)**.

---

### **Similar Problems**

* **Check for Balanced Tree:** Similar recursive structure where you check a property at each node and propagate the result.
* **Sum Tree:** A variation where each node must equal the sum of **all** nodes in its subtrees, not just its immediate children.
* **Evaluate Boolean Binary Tree (LeetCode 2331):** Uses children's values to determine the parent node's value based on logical operators.

---

**FLASHCARD / MIND MAP RECALL TIP**
**Leaf is True, Root = L + R:** Check the sum locally, then use `&&` to ensure the entire "family tree" follows the rule.
