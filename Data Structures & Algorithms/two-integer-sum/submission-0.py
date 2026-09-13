class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums.sort()
        l = 0;
        r = len(nums)-1;

        while l < r:

             if nums[l]+nums[r] == target:
                return [l,r];
             elif nums[l]+nums[r] > target:
                r= r-1
             else:
                l=l+1
        return [];