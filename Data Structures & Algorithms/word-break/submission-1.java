class Solution {
    Boolean[][] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
      HashSet<String> set = new HashSet<>();
      dp = new Boolean[s.length()+1][s.length()+1];

      for(String st:wordDict){
        set.add(st);
      }  

      return solve(s,set,0,0);
    }

    boolean solve(String s , HashSet<String> set,int idx,int j){
        if(idx==s.length())return true;
        if(j>=s.length())return false;
        if(dp[idx][j]!=null){
            return dp[idx][j];
        }
        boolean take=false;
        if(set.contains(s.substring(idx,j+1))){
           take = solve(s,set,j+1,j+1);
        }
        boolean skip = solve(s,set,idx,j+1);

        return dp[idx][j]=(take||skip);
    }
}
