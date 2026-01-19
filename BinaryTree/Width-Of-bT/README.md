### **662. Maximum Width of Binary Tree**

**Problem Statement**
The goal is to find the **maximum width** of a binary tree. The width of one level is defined as the number of nodes between the leftmost and rightmost non-null nodes in that level, including any `null` nodes that would exist in a complete binary tree between them.

**Main Logic:** We treat the tree as a **Complete Binary Tree** where every node has an index. By assigning a unique ID to each node, the width of a level is simply **(last_index - first_index + 1)**.

---

### **Logic & Thinking Process**

**1. The Indexing Secret**
To calculate the distance between nodes including "missing" nulls, we use the standard heap-based indexing for binary trees:

* If a parent is at index **i**:
* Left Child index = **2 * i + 1**
* Right Child index = **2 * i + 2**



**2. Handling Integer Overflow (The "min" trick)**
In a very deep tree, the indices can grow exponentially and cause an integer overflow. To prevent this, your code uses a clever trick: at the start of every level, we subtract the **minimum index** of that level from all nodes in that level. This resets the starting index of each level to 0, keeping the numbers small and manageable.

**3. Level Order Traversal (BFS)**
We use a Queue to process nodes level by level. At each level:

* Identify the index of the first node.
* Identify the index of the last node.
* Calculate `last - first + 1` and update our maximum answer.

---

### **Data Structure & Algorithm Used**

* **Queue (LinkedList):** Standard for **BFS**. It allows us to process the tree level by level.
* **Pair Class:** Used to store both the `TreeNode` and its corresponding **index** together in the queue.
* **BFS:** The only suitable algorithm here because width is defined on a level-by-level basis.


### **Complexity Analysis**

* **Time Complexity: O(N)** — Every node is added to and removed from the queue exactly once.
* **Space Complexity: O(W)** — Where **W** is the maximum width of the tree. The queue stores at most one level of nodes at a time. In the worst case, this is O(N).

---

### **Edge Cases**

* **Skewed Tree:** If the tree is just a long line, the width will be 1 at every level.
* **Empty Tree:** Handled by the initial null check.
* **Large Depth:** The index normalization (`curr_id - min`) prevents the `int` indices from overflowing.

---

### **Similar Problems**

* **Binary Tree Level Order Traversal (LeetCode 102):** The base logic for moving level by level.
* **Diameter of Binary Tree (LeetCode 543):** Another "width" related problem, but measures the longest path between any two nodes.

---

### **FLASHCARD / MIND MAP RECALL TIP**

**Width = Last - First + 1**: Use BFS and assign indices (**2i+1**, **2i+2**). Subtract the **min index** at each level to avoid overflow.
