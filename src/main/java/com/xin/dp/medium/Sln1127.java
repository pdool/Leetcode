package com.xin.dp.medium;

public class Sln1127 {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][1001];
        int maxLen=0;//保存结果
        for(int k=1;k<n;k++){
            for(int j=0;j<k;j++){
                int d=nums[k]-nums[j]+500;//统一加偏移量，使下标非负
                dp[k][d]=dp[j][d]+1; //根据 d 去填充dp[k][d]
                maxLen=Math.max(maxLen,dp[k][d]);//维护最大值
            }
        }
        return maxLen+1;
    }
    public static void main(String[] args) {
        int[] nums = {83,20,17,43,52,78,68,45};
        int i = new Sln1127().longestArithSeqLength(nums);
        System.out.println();
    }
}
