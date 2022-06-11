package com.xin.dp;

public class Sln213 {

    //    public int rob(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = nums[0];//   偷
//        dp[0][1] = 0; // 不偷
//        for (int i = 1; i < nums.length; i++) {
//            if (i == nums.length -1) {//最后一个只能不偷
//                if (nums.length% 2 == 0){
//                    dp[i][0] = dp[i - 1][1] + nums[i];
//                }
//            } else {
//                dp[i][0] = dp[i - 1][1] + nums[i];
//            }
//            dp[i][1] = dp[i - 1][0];
//        }
//        return Math.max(dp[nums.length - 1][1],dp[nums.length - 1][0]);
//    }
//    刚开始没有理解题目的输入，以为第一个值和最后一个值一样
    //  思路，把最后一间房单拿出来，计算剩下的 [0,len -2] 和 [1,len -1]
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int rob = new Sln213().rob(nums);
        System.out.println(rob);
    }
}
