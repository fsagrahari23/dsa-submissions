class Solution:

    def encode(self, strs: List[str]) -> str:
        s=""
        for st in strs:
            if s=="":
                s=st
            else:
                s=s+","+st
        
        return s;



    def decode(self, s: str) -> List[str]:
        return s.split(",")
