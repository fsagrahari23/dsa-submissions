class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mp = {}

        for c in s:
            if c in mp:
                mp[c]=mp[c]+1;
            else:
                mp[c]=1;
        
        for c in t:
            if c in mp:
                mp[c]= mp[c]-1;
            else:
                mp[c]=1;
        
        for v in mp.values():
            if v!=0:
                return False;

        return True;


