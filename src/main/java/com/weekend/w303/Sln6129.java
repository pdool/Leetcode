package com.weekend.w303;

public class Sln6129 {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;//答案
        int zeroCnt = 0;//当前0的个数
        for (int x : nums) {
            if (x == 0) {
                zeroCnt++;
                count += zeroCnt;
            } else {
                zeroCnt = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        new Sln6129().zeroFilledSubarray(nums);
    }
}
