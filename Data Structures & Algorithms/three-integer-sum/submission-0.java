class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int sum = nums[l] + nums[r];

                if (sum == target) {

                    result.add(Arrays.asList(
                        nums[i],
                        nums[l],
                        nums[r]
                    ));

                    l++;
                    r--;

                    // Skip duplicates
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }

                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }
}