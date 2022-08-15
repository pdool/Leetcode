package com.xin.greedy;

//    https://leetcode.cn/problems/minimum-time-to-make-rope-colorful/
public class Sln1578 {
    //  贪心算法
    public int minCost(String colors, int[] neededTime) {
        int i = 0, len = colors.length();
        int ret = 0;
        while (i < len) {
            char ch = colors.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < len && colors.charAt(i) == ch) {
                maxValue = Math.max(maxValue, neededTime[i]);
                sum += neededTime[i];
                i++;
            }
            ret += sum - maxValue;
        }
        return ret;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] nums = {1, 2, 3, 4, 5};
        int i = new Sln1578().minCost(colors, nums);
        System.out.println(i);
    }
}
