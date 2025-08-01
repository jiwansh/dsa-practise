public class Solution {
    public int maxLength(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int sum = 0, maxLen = 0;

        while (right < n) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 4, 2, 1};
        int k = 6;
        Solution sol = new Solution();
        System.out.println(sol.maxLength(arr, k)); // Output: 4
    }
}