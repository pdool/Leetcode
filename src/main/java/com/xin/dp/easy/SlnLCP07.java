package com.xin.dp.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlnLCP07 {
//    public int numWays(int n, int[][] relation, int k) {
//        Map<Integer, List<Integer>> transMap = new HashMap<>();
//
//        for (int i = 0; i < relation.length; i++) {
//            int from = relation[i][0];
//            int to = relation[i][1];
//            List<Integer> orDefault = transMap.getOrDefault(from, new ArrayList<>());
//            orDefault.add(to);
//            transMap.put(from,orDefault);
//        }
//        int dfs = dfs(transMap, n, k, 0);
//        return dfs;
//    }
//    int dfs(Map<Integer, List<Integer>> transMap,int n,int k ,int current){
//        if (k ==0 && current == n-1){
//            return 1;
//        }
//        if (k<=0){
//            return 0;
//        }
//        List<Integer> integers = transMap.get(current);
//        int sum =0;
//        if (integers != null){
//            for (Integer integer : integers) {
//                sum += dfs(transMap,n,k-1,integer);
//            }
//
//        }
//        return sum;
//    }
    //  dp
public int numWays(int n, int[][] relation, int k) {
    int[][] dp = new int[k + 1][n];
    dp[0][0] = 1;
    for (int i = 0; i < k; i++) {
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            dp[i + 1][dst] += dp[i][src];
        }
    }
    return dp[k][n - 1];
}
    public static void main(String[] args) {
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int i = new SlnLCP07().numWays(5, relation, 3);
        System.out.println(i);
    }
}
