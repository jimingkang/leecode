package com.andy.leecode.stack;

import java.util.LinkedList;

public class ValidParentheses20 {
    public static void main(String[] args) {
        //
        System.out.println(isValid(")("));
        System.out.println(isValid("()"));
        System.out.println(isValid("(])"));
         System.out.println(isValid("(){}}{"));
        System.out.println(isValid("([}}])"));
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack=new LinkedList<Character> ();

        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)=='{' ||s.charAt(i)=='['||s.charAt(i)=='(')
            {
                stack.push(s.charAt(i));
            }
        else if(s.charAt(i)=='}' ||s.charAt(i)==']'||s.charAt(i)==')'){
                char top='0';
            char tmp=s.charAt(i);

                if(!stack.isEmpty())
                 top=(char)stack.peek();
                if((top=='{'&&tmp=='}')||(top=='['&&tmp==']')||(top=='('&&tmp==')'))
                 stack.pop();
                else
                    stack.push(s.charAt(i));




        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
