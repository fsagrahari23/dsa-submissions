class Solution {
    public int maxSubArray(int[] nums) {
        int i=0;
        int j=0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        while(j<nums.length){
           while(i<nums.length&&currSum+nums[i]<nums[i]){
            currSum-=nums[i];
            i++;
           }
           currSum+=nums[j];
           maxSum = Math.max(maxSum,currSum);
           j++;
        }

        return maxSum;
    }
}
