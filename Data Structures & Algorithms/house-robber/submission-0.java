class Solution {
    public int rob(int[] nums) {
        
        return solve(nums,0);
    }

    int solve(int[] nums,int idx){
        if(idx>=nums.length)return 0;

        int take = nums[idx]+solve(nums,idx+2);
        int skip = solve(nums,idx+1);

        return Math.max(take,skip);
    }
}
