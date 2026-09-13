class Solution:

    def encode(self, strs: List[str]) -> str:
        s=""
        i=0;

        if len(strs) == 0:
            return "No"
        for st in strs:
            if i==0:
                s=st
            else:
                s=s+"encode"+st
            i=i+1
        
        return s;



    def decode(self, s: str) -> List[str]:

        if s == "No":
            return []
        return s.split("encode")
