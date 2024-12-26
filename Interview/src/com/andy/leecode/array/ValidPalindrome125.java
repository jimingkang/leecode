package com.andy.leecode.array;

class ValidPalindrome125 {

    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
         s=s.toUpperCase().replace(" ", "");
        int l=0;
        int r=s.length()-1;
        boolean flag=true;
        while(l<=r)
        {
            if(!(s.charAt(l)<='Z' &&s.charAt(l)>='A'))
            {
  l++;
            }
            
            if(!(s.charAt(r)<='Z' &&s.charAt(r)>='A'))
            {
 r--;
            }
           
            if(s.charAt(l)!=s.charAt(r))
            {
                flag=false;
            break;
            }
           
            
                l++;
                r--;
            

        }
        return flag;
        
    }
}