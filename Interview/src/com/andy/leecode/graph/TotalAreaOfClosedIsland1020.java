package com.andy.leecode.graph;

public class TotalAreaOfClosedIsland1020 {
    public static void testInt( Integer a){
        //a=a+1;
    }
    int max=0;
    public static void main(String[] args) {

       /* Integer a=new Integer(9);
        testInt(a);
        System.out.print(a);*/

 /*     int[][] island={{0,1,0,0},
                        {0,1,1,0},
                        {0,0,0,1},
                        {1,0,0,0}};*/

        int[][] island={{0,0,0,1,1,1,0,1,0,0},
                        {1,1,0,0,0,1,0,1,1,1},
                        {0,0,0,1,1,1,0,1,0,0},
                        {0,1,1,0,0,0,1,0,1,0},
                        {0,1,1,1,1,1,0,0,1,0},
                        {0,0,1,0,1,1,1,1,0,1},
                        {0,1,1,0,0,0,1,1,1,1},
                        {0,0,1,0,0,1,0,1,0,1},
                        {1,0,1,0,1,1,0,0,0,0},
                        {0,0,0,0,1,1,0,0,0,1}};
/*        int[][] island={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}
                ;*/

    /*   int[][] island={{0,0,0,0,0,0,0,1},
                        {0,1,1,1,1,0,0,1},
                        {0,1,0,1,0,0,0,1},
                         {0,1,1,1,1,0,1,0},
                         {0,0,0,0,0,0,0,1}};*/
        //int[][] island= {{1,1,0,1,1},{1,0,1,0,1},{1,0,0,0,1}};
        TotalAreaOfClosedIsland1020 p=new TotalAreaOfClosedIsland1020();
        System.out.print(p.TotalAreaOfClosedIsland(island));
    }


    public  int      TotalAreaOfClosedIsland(int[][] island){

         int cnt=0;
        int rows=island.length;
        int cols=island[0].length;
        int glabalmax=0;

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(island[i][j]==1) {
                  boolean flag=dfs(island, i, j, rows, cols);
                   if(flag) glabalmax=glabalmax+max;
                   max=0;

                }
            }
        }
        return glabalmax;
    }
    public  boolean      dfs(int[][] island,int x,int y, int rows ,int cols){
        if(x<0||x>=rows||y<0||y>=cols) {

            return false;
        }

        if(x==0||y==0||x==(rows-1)||y==(cols-1))
            if( island[x][y] == 1 )
                return false;
        if(island[x][y]==0)
            return true;

        island[x][y]=0;
        max++;
        boolean up=dfs(island,x-1,y,rows,cols);
        boolean down=dfs(island,x+1,y,rows,cols);
        boolean left=dfs(island,x,y-1,rows,cols);
        boolean right=dfs(island,x,y+1,rows,cols);

        return up&&down&&left&&right;



    }
}
