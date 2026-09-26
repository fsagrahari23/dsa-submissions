class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        if(nums.length==1 && nums[0]==0)return true;
        dp = new Boolean[nums.length+1];
       
       return solve(nums,0);
    }

    boolean solve(int[] nums,int idx){
        if(idx>=nums.length-1)return true;
        if(nums[idx]==0)return false;

        if(dp[idx]!=null)return dp[idx];

        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,idx+i)){
                return dp[idx]= true;
            }
        }

        return dp[idx]=false;
    }
}
