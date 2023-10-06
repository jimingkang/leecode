package com.andy.leecode.graph;

public class NumbersOfIsland200 {
    public static void main(String[] args) {
        int[][] island={{0,1,0,0},
                        {0,1,1,0},
                        {0,0,0,1},
                        {1,0,0,0}};
        System.out.print(NumberOfgIsland(island));
    }
    public static int      NumberOfgIsland(int[][] island){

         int cnt=0;
        int rows=island.length;
        int cols=island[0].length;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(island[i][j]==1) {
                    dfs(island, i, j, rows, cols);
                    cnt++;
                }

            }
        }
        return cnt;
    }
    public static void      dfs(int[][] island,int x,int y, int rows ,int cols){
        if(x<0||x>=rows||y<0||y>=cols||island[x][y]==0)
            return ;
        island[x][y]=0;
        dfs(island,x-1,y,rows,cols);
        dfs(island,x+1,y,rows,cols);
        dfs(island,x,y-1,rows,cols);
        dfs(island,x,y+1,rows,cols);

    }
}
