package com.andy.leecode.graph;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] island={{0,1,0,0},
                        {0,1,1,0},
                        {0,0,0,1},
                        {1,0,0,0}};
        MaxAreaOfIsland695 p=new MaxAreaOfIsland695();
        System.out.print(p.MaxAreaOfIsland(island));
    }
     int max=0;
    public  int      MaxAreaOfIsland(int[][] island){

         int cnt=0;
        int rows=island.length;
        int cols=island[0].length;

        int globalmax=0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(island[i][j]==1) {
                    dfs(island, i, j, rows, cols);
                    cnt++;
                    globalmax=Math.max(globalmax,max);
                    max=0;
                }
            }
        }
        return globalmax;
    }
    public  void      dfs(int[][] island,int x,int y, int rows ,int cols){
        if(x<0||x>=rows||y<0||y>=cols||island[x][y]==0) {
           // if(x>0&&x<rows&&y>0&&y<cols&&island[x][y]==0)
            return ;
        }

        island[x][y]=0;
        max++;
        dfs(island,x-1,y,rows,cols);
        dfs(island,x+1,y,rows,cols);
        dfs(island,x,y-1,rows,cols);
        dfs(island,x,y+1,rows,cols);


    }
}
