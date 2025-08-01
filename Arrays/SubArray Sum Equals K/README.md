# Subarray Sum equlas K (Positive, Negative)

Given an array of integers (which can include negative numbers) and an integer k, you need to find the total number of continuous subarrays whose elements add up to exactly k.

Unlike the previous problem, this one allows negative numbers, so a sliding window approach doesn't work. Instead, we use prefix sums and hashing.

## Intuition
We want to count subarrays ending at every index where the sum of elements equals k. If we keep track of the cumulative sum up to each point, then for any current sum currSum, we can check if currSum - k has occurred before.

Why? Because if currSum - k = prevSum, then the subarray between that previous index and the current one must sum to k.

## Approach

- Maintain a HashMap to store cumulative sum frequencies.

- Initialize map with {0 → 1} to handle the case when the sum from the start equals k.

- Traverse the array, maintaining a running sum (currSum).

- At each step, check if currSum - k exists in the map. If it does, it means there's a subarray ending at this index that sums to k.

- Add the frequency of currSum - k to the count.

- Update the map with currSum for future use.



## Time Complexity

O(n) — single traversal with constant-time HashMap operations.

Space Complexity

O(n) — in worst-case, all prefix sums are different and stored.

## Similar Problems

- 325. Maximum Size Subarray Sum Equals k

- Subarray Sums Divisible by K

- Path Sum III (Tree version)

# Real-life Use Case

- Financial data: Finding periods where net gain/loss equals a target.

- Health metrics: Finding continuous days where calorie intake was equal to a target.

- Signal processing: Detecting signal sections that average to a threshold over time.