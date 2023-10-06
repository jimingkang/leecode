package com.andy.draft;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String []ss){
String str="abc";
System.out.println(combination(str));
    }
    public static void swap(char a,char b){
        char tmp=a;
        a=b;
        b=tmp;
    }
   public static void combination(String str,int begin,int end){
       // if(begin==a.)
            System.out.println(str.charAt(begin));
        swap(str.charAt(begin),str.charAt(begin+1));
        combination(str,begin+1,end);
       swap(str.charAt(begin),str.charAt(begin+1));
   }
    public static int combination(String str)
    {
        List a=new ArrayList();
        for (char aa:
             str.toCharArray()) {
            a.add(aa);

        }
        for (int i=0;i<a.size();i++) {
            combination(str,i,a.size()-1);

        }


        return 0;

    }
}
