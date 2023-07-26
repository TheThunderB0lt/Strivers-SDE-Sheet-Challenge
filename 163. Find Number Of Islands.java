public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
      //  boolean visited[][] = new boolean[mat.length][mat[0].length];
      int count =0;
      for(int i =0;i<mat.length;i++){
          for(int j =0;j<mat[0].length;j++){
              if(mat[i][j] == 1){
                  count++;
                  dfs(mat,i,j);
              }
          }
      }
      return count;
    }
      public static void dfs(int a[][],int row,int col){
    if(row>=a.length||col>=a[0].length||col<0||row<0||a[row][col] == 0){
        return;
    }
   // visited[row][col] = true;
    a[row][col] = 0;
    dfs(a,row+1,col);
    dfs(a,row,col+1);
    dfs(a,row-1,col);
    dfs(a,row,col-1);
    dfs(a,row-1,col+1);
    dfs(a,row+1,col+1);
    dfs(a,row-1,col-1);
    dfs(a,row+1,col-1);
}
}