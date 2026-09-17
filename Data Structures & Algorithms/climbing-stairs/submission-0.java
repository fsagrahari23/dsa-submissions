class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=1;
        int b = 2;

        

        for(int i=3;i<=n;i++){
          // fn = fn -1 + fn -2;
         
         int  c=a+b;
          a=b;
          b=c;
        }

        return b;
    }
}
