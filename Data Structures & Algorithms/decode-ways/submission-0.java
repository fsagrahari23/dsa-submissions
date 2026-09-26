class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        int count = 1;

        for(int i=1;i<s.length();i++){
           if(s.charAt(i-1)!=0){
            count +=1;
           }
        }

        return count;
    }
}
