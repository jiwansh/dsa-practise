# Two Sum [TWO SUM]{https://leetcode.com/problems/two-sum}
You are given an array nums and an integer target. You need to find the indices of two distinct numbers in the array that sum up to the target.
It is guaranteed that exactly one solution exists, and the same element cannot be used twice.

## Intuition
Brute force would check every pair, but that is O(n²) time.
To optimize, use a HashMap to store numbers we've already seen along with their indices.
This allows us to check in constant time whether the complement (target - current number) has been seen before.

## Approach

- Initialize a HashMap to map numbers → indices.

- Iterate through the array. For each number:

- Compute the complement: target - currentNum.

- If the complement is in the map, we found the two numbers.

- Otherwise, store the current number and its index in the map.

- Return the indices when found.


## Time Complexity

- O(n) — Single pass through the array with constant-time HashMap lookups.

## Space Complexity

- O(n) — For storing up to n elements in the map.

## Similar Problems

167. Two Sum II – Input Array is Sorted

Two Sum IV – Input is a BST

3Sum (Extension of Two Sum)

## Real-life Use Case

- Budgeting tools: Identifying two expenses that sum up to a specific limit.

- Fraud detection: Detecting transactions that add up to a flagged amount.

- Pair matching problems in games or logistics where two values must meet a target sum.