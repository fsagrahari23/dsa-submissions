class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int i=0;
        while(i!=32){
            int r = n&1;
            ans = ans*2+r;
            n>>=1;
            i++;
        }

        return ans;
    }
}
