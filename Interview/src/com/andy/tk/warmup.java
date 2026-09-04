package com.andy.tk;

import javax.xml.stream.events.Characters;
import java.util.*;

public class warmup {
   public static void main(String[] args) {
int[][] islands=new int[][]{{1,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,1,0}};
int rows=islands.length;
int cols=islands[0].length;
boolean[][] visited=new boolean[rows][cols];

bfs(islands,visited,0,0,rows,cols);
    }
   static void bfs(int[][] islands,boolean[][] visited,int x,int y,int rows,int cols){
 if(x<0||y<0||x>=rows||y>=cols)
     return;
        //
       // Queue q=new LinkedList<>();
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j <cols ; j++) {
               if(islands[i][j]==1){
                   visited[i][j]=true;
                   bfs(islands,visited,i+1,j,rows,cols);
                   bfs(islands,visited,i-1,j,rows,cols);
                   bfs(islands,visited,i,j+1,rows,cols);
                   bfs(islands,visited,i,j-1,rows,cols);

               }
           }
       }
    }



//backtrace
static void backtrace(int i, int j, int[][] nums, List<List> res){
  //  for()
}

//leetcode 3

public int lengthOfLongestSubstring(String s) {
    int i=0;
    int j=0;
    int max=0;
    StringBuffer sb=new StringBuffer();
    Map<Character,Integer> m=new HashMap();

    for(;j<s.length();j++)
    {
        char c=s.charAt(j);
        if(m.containsKey(c)){
            i=Math.max(i,m.get(c)+1);

        }
        m.put(c,j);
        max= Math.max(max,j-i+1);

    }
    return max;

}

}