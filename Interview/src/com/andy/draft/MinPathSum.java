package com.andy.draft;

public class MinPathSum {
    public static void main(String []ss){
int[][] grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid)
    {
        int rows= grid.length;
        int dp[][]=new int[grid.length][grid.length];
        dp[0][0]=grid[0][0];

        for(int j=1;j<rows;j++)
            dp[0][j]=dp[0][j-1]+grid[0][j];
        for(int i=1;i<rows;i++)
            dp[i][0]=dp[i-1][0]+grid[i][0];
        for(int i=1;i<rows;i++)
            for(int j=1;j<rows;j++)
            {


                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);

            }
        return dp[rows-1][rows-1];
    }
}
