class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        l = []

        for s in strs:

            added = False

            for group in l:
                if self.isAnag(group[0], s):
                    group.append(s)
                    added = True
                    break

            if not added:
                l.append([s])

        return l

    def isAnag(self, s, t):
        if len(s) != len(t):
            return False

        mp = {}

        for c in s:
            mp[c] = mp.get(c, 0) + 1

        for c in t:
            if c not in mp:
                return False

            mp[c] -= 1

        for count in mp.values():
            if count != 0:
                return False

        return True