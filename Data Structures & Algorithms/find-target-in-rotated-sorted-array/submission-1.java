class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if(target==nums[mid]){
                return mid;
            }else if(nums[mid]>target){
                 if(target<nums[l]){
                    l=mid+1;
                 }else{
                    r=mid;
                 }
            }else{
                if(target>nums[l]){
                    l=mid+1;
                 }else{
                    r=mid;
                 }
            }
           
        }

        return ans;
    }
}
