### **863. All Nodes Distance K in Binary Tree**

**Problem Statement**
Given the **root** of a binary tree, a **target node**, and an integer **k**, return the values of all nodes that have a distance of **k** from the target node. You can return the answer in any order.

**Main Logic:** Standard binary trees only allow downward movement to children. To find nodes at distance **k** in any direction (including upward), we treat the tree as an **undirected graph** by mapping each node to its neighbors (left child, right child, and parent). Once the graph is built, we perform a **Breadth-First Search (BFS)** starting from the target node to find all nodes exactly **k** units away.

---

### **Logic and Thinking Process**

* **Graph Construction (DFS):** We traverse the tree using DFS to build an adjacency list. For every node, we create an edge to its left child, right child, and its parent.
* **The "Messenger" Pattern:** By linking children back to their parents, we enable the traversal to move "up" the tree.
* **BFS for Shortest Distance:** BFS is the ideal algorithm for finding nodes at a specific distance **k** because it explores the graph in "waves" or levels. All nodes reached in the  wave are exactly distance **k** from the start.
* **Visited Tracking:** Since the graph is undirected, a node can point back to its parent, which points back to the node. We must use a **Set** to track visited nodes to avoid infinite loops or cycles.

---

### **Common Pitfalls**

* **Integer Overflow from Position Numbers:** While not directly applicable to this specific graph-based approach, in trees where you use position indexing (like ), indices can overflow standard integers in deep, skewed trees.
* **Miscounting the Distance:** In BFS, ensure you process the entire current size of the queue (one full level) before incrementing the distance counter.
* **Incorrect Level Tracking:** Failing to properly identify level boundaries in BFS will lead to incorrect distance results.
* **Assuming Nodes Exist:** Ensure the target node is actually present in the tree; though in this specific LeetCode problem, it is guaranteed.

---

### **Data Structure and Algorithm Used**

* **HashMap<TreeNode, List<TreeNode>>:** Acts as an **Adjacency List** to store the undirected graph.
* **Queue<TreeNode>:** Used for **Level-Order Traversal (BFS)** to explore nodes level by level.
* **HashSet<TreeNode>:** Tracks **visited nodes** to prevent the BFS from re-processing nodes (cycles).
* **DFS:** Used initially to traverse the tree and populate the graph/map.


### **Complexity Analysis**

* **Time Complexity: O(N)** — We visit every node once to build the graph and, in the worst case, every node once during the BFS traversal.
* **Space Complexity: O(N)** — We store all  nodes in the HashMap (Adjacency List), the visited Set, and the BFS Queue.

---

### **Similar Problems**

* **Amount of Time for Binary Tree to Be Infected (LeetCode 2385):** Identical graph conversion and BFS logic.
* **Find Distance in a Binary Tree (LeetCode 1740):** Finding the distance between two specific nodes.
* **All Paths from Source to Target:** Standard backtracking/traversal on graphs.

---

**FLASHCARD / MIND MAP RECALL TIP**
**Tree to Graph + BFS:** When a problem requires moving "up" toward the root or "sideways" through neighbors, map the parents to create an **undirected graph** and run **BFS** for exactly **k** steps.
