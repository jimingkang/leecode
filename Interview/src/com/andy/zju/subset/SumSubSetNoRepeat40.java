package com.andy.zju.subset;

import java.util.*;

public class SumSubSetNoRepeat40 {

    public static void main(String[] ss){
       // int[] test=new int[]{10,1,2,7,6,1,5};
        //int target=8;

        int[] test=new int[]{
                4,4,2,1,4,2,2,1,3
                //10,1,2,7,6,1,5

        };
        int target=6; //8


        int[] test2=new int[test.length+1];
       // int target=6;
       //int [] ast= asterriod_collision(test);
        List<List<Integer>>res=new ArrayList<>();
        test2[0]=0;
        for (int i = 1; i <test.length+1 ; i++) {
            test2[i]=test[i-1];
        }
        sumsubset(res,test2,new ArrayList<>(),0,target);
        HashMap<Integer,List> hashMap=new HashMap<>();
      for (List li:res) {
         li.sort(new Comparator() {
             @Override
             public int compare(Object o1, Object o2) {
                 return (Integer)o1-(Integer)o2;
             }
         });
          HashSet set=new HashSet();

            for (int i = 0; i <li.size() ; i++) {

                    set.addAll(li);
            }
            hashMap.put(set.hashCode(),li);


        }
        List<List<Integer>>res2=new  ArrayList<>();
        System.out.println(hashMap);
        hashMap.values().stream().forEach(a->{res2.add(a);
        });
        System.out.println(res2);


    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        int[] candidates2=new int[candidates.length+1];

        candidates2[0]=0;
        for (int i = 1; i <candidates.length+1 ; i++) {
            candidates2[i]=candidates[i-1];
        }
        sumsubset(res,candidates2,new ArrayList<>(),0,target);
        HashMap<Integer,List> hashMap=new HashMap<>();
        for (List li:res) {
            int sum=1;
            for (int i = 0; i <li.size() ; i++) {
                sum=sum*10+Integer.parseInt(String.valueOf(li.get(i)));
            }
            hashMap.put(sum,li);


        }
        List<List<Integer>>res2=new  ArrayList<>();

        hashMap.values().stream().forEach(a->{res2.add(a);
        });
        return res2;
    }
    public  static void sumsubset(List<List<Integer>>res,int[] ast,List<Integer> cur, int index,int target) {
        if(ast.length-1==0)
            return;
        if(ast.length-1==1)
        {
            if(ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                res.add(tmp);
            }
            return;

        }
        if(ast.length-1==2)
        {
            if(ast[2]+ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                tmp.add(ast[2]);
                res.add(tmp);
            }
            if(ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                // tmp.add(ast[1]);
                res.add(tmp);
            }
            if(ast[2]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[2]);

                res.add(tmp);
            }
            return;

        }
        if(target<0)
            return;
        if(target==0)
        {

            res.add(new ArrayList<Integer>(cur));
            return;
        }
        //else if(target>0) {
        //HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = index+1; i <ast.length ; i++) {
            cur.add(ast[i]);
            sumsubset(res, ast, cur, i, target - ast[i]);
            cur.remove(cur.size() - 1);

        }

        //}


    }
}
