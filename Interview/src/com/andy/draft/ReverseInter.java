package leecode;

public class ReverseInter {
    public static void main(String[]ss){

        System.out.println(reverse(-120));
    }
    public static int reverse(int a){
        int tmp=Math.abs(a);
        int reverse=0;
      while(tmp>0)
      {
          reverse=10*(reverse+(tmp%10));
          tmp=tmp/10;
      }
        if(a>0) return reverse/10;
      else return  0-reverse/10;
    }
}
