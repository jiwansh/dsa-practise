import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
         map.put(0,1);   // initial sum 0 has occurred once
         int currSum = 0;
         int count = 0;
         for(int i : nums){
            currSum += i;
            if(map.containsKey(currSum - k)){
                count += map.get(currSum - k);  // valid subarrays ending here
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
         }
         return count;
    }
}
