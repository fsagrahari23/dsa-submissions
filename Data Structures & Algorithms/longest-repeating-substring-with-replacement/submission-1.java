class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int max = 0;

        while(r<s.length()){
            int idx = s.charAt(r)-'A';

            freq[idx]++;
            maxFreq = Math.max(maxFreq,freq[idx]);

            int ws = r-l+1;

            if(ws-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max = Math.max(max,r-l+1);
            r++;
        }

      
        return max;
    }
}