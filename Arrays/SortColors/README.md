# Sort Colors
You are given an array nums containing only the integers 0, 1, and 2, representing colors red, white, and blue respectively. You need to sort the array in-place so that all 0s come first, then all 1s, and then all 2s.

## Intuition:
We need a linear-time, constant-space algorithm to rearrange the elements.

Since there are only three distinct values, we can either count and overwrite (naive but better), or use pointers to swap values to their correct region (optimal).

### Approach 1: Counting Sort (Better Approach)
Main Logic:

Count the number of 0s, 1s, and 2s.

Overwrite the array with those counts in order.

### Time Complexity: O(n)
### Space Complexity: O(1) (in-place write, only variables used)

## Similar Problems:

- Leetcode 88. Merge Sorted Array

- Leetcode 905. Sort Array By Parity

### Real-life Use Case:
Sorting low, medium, high priority tasks or classifying objects by category where only a fixed number of labels exist.

## Approach 2: Dutch National Flag Algorithm (Optimal Approach)
Main Logic:
### Use three pointers:

- left: position to place next 0

- curr: current index

- right: position to place next 2

## Traverse the array with curr:

while curr<=right, 

If nums[curr] == 0: swap with left, move both left and curr

If nums[curr] == 1: just move curr

If nums[curr] == 2: swap with right, move right only

## Follow Up Question:
Why not left<=right, why curr<=right?
-  Because: curr is the lead hero as 
-- It guarantees that every index is visited once and evaluated properly.

-- left is just a helper to track placement of 0s — it has no role in controlling the loop.


Time Complexity: O(n)
Space Complexity: O(1) (in-place and single pass)

Similar Problems:

Leetcode 283. Move Zeroes

Leetcode 26. Remove Duplicates from Sorted Array

## Real-life Use Case:
Real-time sorting of three categories of events/logs (e.g., Info, Warning, Error), arranging visual colors, inventory types, etc., in constant space and fast speed.