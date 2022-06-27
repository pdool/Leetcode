package com.xin.backtrack;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sln40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> itemList = new ArrayList<>();
        int selectIndex = 0;
        backtrack(resultList, candidates, itemList, target, selectIndex);
        return resultList;
    }

    // 子问题 target -n selectIndex
    //  有重复子集 [10,1,2,7,6,1,5] 8  out [[1,7],[1,6,1],[2,6],[7,1]] ans [[1,1,6],[1,2,5],[1,7],[2,6]]
    //
    private void backtrack(List<List<Integer>> resultList, int[] candidates, List<Integer> itemList, int target, int selectIndex) {
        if (target == 0) {
            Collections.sort(itemList);
            if(!resultList.contains(itemList)){
                resultList.add(new ArrayList<>(itemList));
            }
            return;
        }
        if (selectIndex >= candidates.length) {
            return;
        }
        for (int i = selectIndex;i< candidates.length;i++){
            backtrack(resultList, candidates, itemList, target, selectIndex + 1);
            if(target - candidates[i] >0){
                itemList.add(candidates[i]);
                backtrack(resultList, candidates, itemList, target - candidates[i], i+1);
                itemList.remove(itemList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = new Sln40().combinationSum2(nums, target);
        System.out.println();
        //  TODO 还是没解决
    }
}
