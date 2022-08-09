package com.xin.day;

public class Sln1413 {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = nums[i] + n;
            min = Math.min(n,min);
        }
        return -min +1 ;
    }

    public static void main(String[] args) {
//        int[] nums =  {-3,2,-3,4,2 };
        int[] nums =  {1,-2 ,3};
        int i = new Sln1413().minStartValue(nums);
        System.out.println();
    }
}
