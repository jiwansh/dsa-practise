#  Given an array and a sum k, we need to print the length of the longest subarray that sums to k.


## Example:
Input: arr = [1, 2, 3, 1, 1, 1, 4, 2, 1], k = 6
Output: 3
## Explanation: One valid subarray is [1, 1, 4] or [2, 1, 3], both of length 3.

## Intuition:
Since all elements in the array are positive, increasing the window size increases the sum. This makes it ideal for using a sliding window approach, where we keep expanding the window until the sum exceeds the target and then shrink it from the left.

## Approach:

Use two pointers left and right to represent the sliding window.

Initialize sum = 0 and maxLen = 0.

Loop through the array with right pointer:

Add arr[right] to sum.

While sum > k, shrink the window from the left by subtracting arr[left] and incrementing left.

If sum == k, update maxLen with the length of the current window.

Return maxLen at the end.

## Main Logic:
The window always moves forward. We grow the window to increase the sum and shrink it from the left when the sum exceeds k. The moment the sum equals k, we update the result with the current window size.


## Time and Space Complexity:
Time Complexity: O(n), since each element is visited at most twice (once by right, once by left)
Space Complexity: O(1), no extra space used apart from variables

## Similar Problems:

Longest Subarray with Given Sum (with negative numbers) – use HashMap

Leetcode 560: Subarray Sum Equals K

Minimum Size Subarray Sum

Count subarrays with a given sum

## Real-life Use Case:
Suppose you're monitoring your calorie intake each day. You want to find the longest streak of consecutive days where your total calorie intake adds up exactly to your weekly goal. This problem helps identify such continuous periods without going over the target.

