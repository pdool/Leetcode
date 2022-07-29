package com.prev;

public class Sln303 {
    class NumArray {
        int[] prevArr;
        public NumArray(int[] nums) {
            prevArr = new int[nums.length +1];

            for (int i = 0; i < nums.length; i++) {
                prevArr[i+1] = prevArr[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return prevArr[j + 1] - prevArr[i];
        }
    }
}
