package com.xin.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sln491 {

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        List<Integer> itemList = new ArrayList<>();
//        backtrack(resultList,nums,itemList,0);
//        return resultList;
//    }
//
//    private void backtrack(List<List<Integer>> resultList, int[] nums, List<Integer> itemList,int pos) {
//        if (pos == nums.length -1 && itemList.size() >=2){
//            resultList.add(new ArrayList<>(itemList));
//        }
//        for (int i = pos; i < nums.length; i++) {
//            if ( nums[i] >= itemList.get(itemList.size() -1)){
//                itemList.add(nums[i]);
//                backtrack(resultList,nums,itemList,pos +1);
//                itemList.remove(itemList.size() -1);
//            }
////            backtrack(resultList,nums,itemList,pos +1);
//        }
//    }

    public static void main(String[] args) {
    int[] nums = {4,4,3,2,1};
        List<List<Integer>> subsequences = new Sln491().findSubsequences(nums);
        System.out.println(subsequences);
    }
}
