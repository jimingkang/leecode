package com.andy.draft;

import java.util.*;

public class WordBreak {
    public static void main(String[] ss){
      String[] dict=new String[]{"lee","code"};
      String str="leecodelee";

      Set<String> dict2=new HashSet<String>(Arrays.asList(dict));
Boolean [] res=new Boolean[str.length()+1];
        wordbreak(res,str,str.length(),dict2);
    }
    public static boolean wordbreak(Boolean [] res,String str,int len,Set<String> dict) {
        if(len==0)return true;
        if(res[len] != null ) {
            return res[len];
        }
        for (int i = 0; i <len ; i++) {
            if(!dict.contains(str.substring(i,len)))
            {
                continue;

            }
            boolean left=wordbreak(res,str,i,dict);
            if(left)
            {
                res[len]=true;
                break;
            }


        }
        return  res[len];
    }
}
