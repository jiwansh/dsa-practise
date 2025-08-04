package Arrays.maxSubArrraySum;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum); // must check before resetting
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
