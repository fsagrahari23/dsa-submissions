class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1 && nums[0]==0)return true;
        int i=0;
        while(i<nums.length){
            
            if(nums[i]==0){
                return false;
            }
            i = i + nums[i];
            System.out.println(i);
            if(i>=nums.length-1){
                return true;
            }
        }

        return i>=nums.length;
    }
}
