package com.andy.zju.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
    static HashMap<Character,String> map=new HashMap();

    public static void main(String[] args) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");

        List<String> result=  letterCombinations("23");
        System.out.println(result.toString());
    }
    public static List<String> letterCombinations(String digits) {

        ArrayList<String> result=new ArrayList<String>();
        StringBuffer sb=new  StringBuffer();

            find_DFS(result,sb,0,digits.length(),digits);


        return result;
    }
    //DFS
    public static void find_DFS(List<String> result,StringBuffer sb,int start,int end,String digits) {

        if(start>=digits.length())
        {
            result.add(sb.toString());
            return ;

        }
        String str=map.get(digits.charAt(start));
        for (int i = 0; i <str.length() ; i++) {

            sb.append(str.charAt(i));
            find_DFS(result,sb,start+1,str.length(),digits);
            sb.deleteCharAt(sb.length()-1);

        }

    }

}