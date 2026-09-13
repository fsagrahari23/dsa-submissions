class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        mp = {}

        for n in nums:
            mp[n] = mp.get(n, 0) + 1

        l = list(mp.keys())

        l.sort(key=lambda x: mp[x], reverse=True)

        return l[:k]