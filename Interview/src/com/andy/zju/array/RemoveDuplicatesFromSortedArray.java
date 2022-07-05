package com.andy.zju.array;

import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer> ();

        int []a={1,2,2,3,3,4,4};
        for(int i=0;i<a.length;i++)
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        Set set=map.keySet();
        Iterator it=set.iterator();
        a=new int[set.size()];
        int j=0;
        while(it.hasNext()) {
           a[j]=(Integer) it.next();
           j++;
        }
        System.out.println(a);

    }
}
