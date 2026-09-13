class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        n = len(nums)

        a = [1] * n
        b = [1] * n
        ans = [1] * n

        # Prefix product
        for i in range(1, n):
            a[i] = a[i - 1] * nums[i - 1]

        # Suffix product
        for i in range(n - 2, -1, -1):
            b[i] = b[i + 1] * nums[i + 1]

        # Combine
        for i in range(n):
            ans[i] = a[i] * b[i]

        return ans