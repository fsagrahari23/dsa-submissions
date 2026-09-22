class Solution {
    public void rotate(int[][] matrix) {
        int  m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        
         for(int j=0;j<m;j++){
            int l = 0;
            int r = n-1;
            while(l<r){
                int temp = matrix[j][l];
                matrix[j][l]=matrix[j][r];
                matrix[j][r]=temp;
                r--;
                l++;
            }
        }

      
    }
}
