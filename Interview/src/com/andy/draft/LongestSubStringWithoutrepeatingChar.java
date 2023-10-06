package com.andy.draft;

import java.util.HashMap;
import java.util.HashSet;

/*
video ref:https://www.youtube.com/watch?v=hw0zHamgaks
 */
public class LongestSubStringWithoutrepeatingChar {
    public static  void main(String[]ss){
        System.out.println(lengthOfLongestSubstring("qrsvbspk"));

    }
    public static int lengthOfLongestSubstring(String ss){
        int ret=0;
        HashSet<Character> set=new HashSet<Character>();
        for (int i = 0,j=0; i < ss.length(); i++) {
            if(set.contains(ss.charAt(i))){
                set.remove(ss.charAt(j++));  //最巧妙的是这里删除j所在位置的字符，而i继续增长，j为字串开始位置;不用擔心刪除了a,而保留了bcd在set裏面，只要最大長度被ret記錄就行，而且此時i移動到了最後4，j也等於1
            }
           // else{
                set.add(ss.charAt(i));
                ret=Math.max(ret,set.size());
          //  }


        }

return ret;
    }

    public static int lengthOfLongestSubstring2(String ss){
        int ret=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i = 0,j=0; i < ss.length() ; i++) {
            if(map.containsKey(ss.charAt(i))){
              j=Math.max(j,map.get(ss.charAt(i))+1);  //不是map.remove(ss.charAt(j++)); ，不需要删除，只要更新j的位置即可
            }

                map.put(ss.charAt(i),i);           //会覆盖相同的字符，也即是更新老字符位置 为新的i
                ret=Math.max(ret,i-j+1);



        }

        return ret;
    }
}
