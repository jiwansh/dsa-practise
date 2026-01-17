### **257. Binary Tree Paths**

**Problem Statement**
The goal is to find every possible path that begins at the **root** and terminates at a **leaf node**.

**Main Logic:** We perform a Depth-First Search (DFS) to explore every branch. A path is only "captured" when we hit a leaf node (left and right children are both null). We use **backtracking** to maintain a single `StringBuilder` throughout the traversal rather than creating new objects at every step.

---

**Logic & Thinking Process**

* **The Path Building:** As we move down, we append the node's value. If the `StringBuilder` is not empty, we add the `"->"` separator first.
* **The StringBuilder Advantage:** Unlike a standard `String` (which is immutable and creates a new object every time you modify it), a `StringBuilder` is a mutable container. By using it, we avoid the heavy memory overhead of creating new string objects at every level of the tree.
* **Backtracking Strategy:** To ensure that one branch's path doesn't "bleed" into another, we must restore the `StringBuilder` to its previous state. We do this by recording the length of the builder *before* adding the current node's data and resetting it once we finish exploring that node’s children.

---

**Backtracking Template for Tree Paths**
This problem follows a standard recursive backtracking pattern:

1. **Base Case:** If the node is `null`, return.
2. **Save State:** Record the current state (in this case, `int currLen = curr.length()`).
3. **Make Move:** Add the current node to the path (`curr.append(...)`).
4. **Check Condition:** If it's a leaf node, convert the builder to a string and add to the final answer list.
5. **Recurse:** Move to `left` and `right` children.
6. **Undo Move (Backtrack):** Reset the state for the parent caller (`curr.setLength(currLen)`).

---

**Data Structure & Algorithm Used**

* **StringBuilder:** Chosen for **mutability**. Since `String` is immutable, passing a `String` directly would implicitly create a new object in memory for every recursive call. Using `StringBuilder` allows us to use **one object** for the entire process.
* **DFS (Depth-First Search):** Traverses as deep as possible along each branch before backtracking.
* **Backtracking:** Crucial for "cleaning up" the shared `StringBuilder` so it accurately represents the current path during each recursive step.


**Complexity Analysis**

* **Time Complexity: O(N)** — Every node is visited once. However, converting the `StringBuilder` to a `String` at each leaf adds a small overhead proportional to the path length.
* **Space Complexity: O(H)** — Where **H** is the height of the tree, representing the maximum depth of the recursion stack.

---

**Edge Cases**

* **Single Node:** The root is immediately recognized as a leaf; `ans` gets `["root.val"]`.
* **Skewed Tree:** Backtracking ensures the `StringBuilder` length remains accurate even in deep  paths.
* **Null Root:** Handled by the initial check, returning an empty list.

---

**Similar Problems**

* **Path Sum II (LeetCode 113):** Similar logic but requires an `ArrayList<Integer>` instead of a `StringBuilder`. Note that with an `ArrayList`, you must manually remove the last element to backtrack.
* **Sum Root to Leaf Numbers (LeetCode 129):** Sum up numbers formed by paths.

---
