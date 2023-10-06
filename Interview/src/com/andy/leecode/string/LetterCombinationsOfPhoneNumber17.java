package com.andy.leecode.string;

import java.util.*;

public class LetterCombinationsOfPhoneNumber17 {
    static HashMap<Character,String> hashMap=new HashMap<>();
    public static void main(String[] args) {
        //char[] test=new char[]{'1','2','3'};
        String input="23";

                hashMap.put('2',"abc");
       // hashMap.put('3',"def");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        //int [] ast= asterriod_collision(test);
        List<StringBuffer>res=new ArrayList<>();
        subset(res,input);
        for (StringBuffer li:res) {
            //for (int i = 0; i <li.() ; i++) {
                System.out.print(li+",");
           // }
            System.out.println();

        }
    }
    public static void subset(List<StringBuffer>res, String ast) {
        char[] arr=ast.toCharArray();
        Queue<Character>  q=new LinkedList();

        for (char a:arr
             ) {
            StringBuffer sb=new StringBuffer();
            char [] sub=hashMap.get(a).toCharArray();
            for (Character aa:
                 sub) {
                q.offer(aa);
            }
int length=q.size();
            for (int i = 0; i <length ; i++) {
                char tmp=  q.remove();
                sb.append(tmp);
            }



        }


    }



}
