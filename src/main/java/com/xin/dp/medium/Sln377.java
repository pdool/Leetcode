package com.xin.dp.medium;

public class Sln377 {
    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
     * 请你从 nums 中找出并返回总和为 target 的元素组合的个数
     * @param nums
     * @param target
     * @return
     */
    //  深度搜索 超时
//    public int combinationSum4(int[] nums, int target) {
//        if (target <0){
//            return 0;
//        }
//        if (target == 0){
//            return 1;
//        }
//        int sum = 0;
//        for (int num : nums) {
//            sum += combinationSum4(nums,target - num);
//        }
//        return sum;
//    }
    //  dp f(n) = f(n-num[0]) + f(n-num[1]) + ....
    // 类似凑硬币
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int i = new Sln377().combinationSum4(nums, 4);
        System.out.println();
    }
}
