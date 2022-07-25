package com.weekend.w303;

import com.sun.org.apache.xpath.internal.operations.And;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sln6127 {
    public long countExcellentPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        Map<String,Boolean> result = new HashMap<>();
        for (int num : nums) {
            for (int i : nums) {
                String  s = i+"_"+ num;
                String  s1 = num+"_"+ i;
                if (result.containsKey(s) || result.containsKey(s1)){
                    continue;
                }
                if (isOk(num, i,k)) {
                    set.add(s);
                    set.add(s1);
                    result.put(s,true);
                    result.put(s1,true);
                }else {
                    result.put(s,false);
                    result.put(s1,false);
                }

            }
        }
        return set.size();
    }

    private boolean isOk(int num, int i,int k) {
        int or = num | i;
        int an = num& i;
        return (Integer.bitCount(or) + Integer.bitCount(an) )>=k;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        new Sln6127().countExcellentPairs(nums,k);
    }
}
