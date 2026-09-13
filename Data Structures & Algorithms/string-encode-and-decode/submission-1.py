class Solution:

    def encode(self, strs: List[str]) -> str:
        s=""
        i=0;
        for st in strs:
            if i==0:
                s=st
            else:
                s=s+","+st
            i=i+1
        
        return s;



    def decode(self, s: str) -> List[str]:
        return s.split(",")
