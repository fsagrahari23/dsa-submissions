class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      HashSet<String> set = new HashSet<>();

      for(String st:wordDict){
        set.add(st);
      }  

      return solve(s,set,0,0);
    }

    boolean solve(String s , HashSet<String> set,int idx,int j){
        if(idx==s.length())return true;
        if(j>=s.length())return false;
        boolean take=false;
        if(set.contains(s.substring(idx,j+1))){
           take = solve(s,set,j+1,j+1);
        }
        boolean skip = solve(s,set,idx,j+1);

        return take||skip;
    }
}
