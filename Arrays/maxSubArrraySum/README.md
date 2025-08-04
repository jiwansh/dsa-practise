# Question: https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

## Example Input:
nums = [-2,1,-3,4,-1,2,1,-5,4]
## Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

## Intuition:
We want to find a subarray with maximum sum. The brute force approach would consider all subarrays and find the max sum, but that’s inefficient.
Instead, we can use Kadane’s Algorithm, which builds up the sum dynamically and tracks the maximum encountered so far.

## Approach:

Initialize sum = 0 and max = Integer.MIN_VALUE.

Traverse the array:

Add current element to sum.

Update max if sum is greater.

If sum < 0, reset sum = 0 (start a new subarray).

Return max after the loop ends.

Important: The order of operations matters. We must update max before resetting sum, or we will lose negative max subarrays.

## Main Logic:
We are accumulating a running sum. If the sum ever becomes negative, it can’t contribute to a future max subarray, so we reset. But before resetting, we always check if the current sum is the best seen so far.


## Time Complexity:
O(n) – Single pass over the array.

## Space Complexity:
O(1) – Constant space.

## Similar Problems:

Maximum Product Subarray

Subarray Sum Equals K

Longest Subarray with Given Sum K

## Real Life Analogy:
Think of daily profit/loss over time. You want to find the best period to invest (maximum gain). If you start losing more than you gained, it’s better to reset and look for a fresh opportunity — but always remember to record the best period before resetting.