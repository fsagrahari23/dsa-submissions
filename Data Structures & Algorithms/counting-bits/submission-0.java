class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[5];

        for(int i=0;i<=n;i++){
          arr[i]=Integer.bitCount(i);
        }

        return arr;
    }
}
