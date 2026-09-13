class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
       mp = {}

       for i in range(len(nums)):
          c = target-nums[i];

          if c in mp:
            return [mp[c],i];
          mp[nums[i]]=i;
    
       return []