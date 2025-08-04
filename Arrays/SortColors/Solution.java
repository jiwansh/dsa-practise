package Arrays.SortColors;
class Solution {
    //Approach 1
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i : nums) {
            if (i == 0) count0++;
            else if (i == 1) count1++;
            else count2++;
        }

        int index = 0;
        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }
    //Approach 2
 
    public void sortColors2(int[] nums) {
        int left = 0, curr = 0, right = nums.length - 1;

        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                curr++;
                left++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}