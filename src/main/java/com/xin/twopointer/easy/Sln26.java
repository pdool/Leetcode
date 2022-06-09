package com.xin.twopointer.easy;

public class Sln26 {

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    /**
     * 好傻。也有bug
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int len = nums.length;
        int i = 0;
        int j = 1;
        while (j < len && i < len) {
            int a = nums[i];
            if (a != nums[j]) {
                i++;
                if (j -i >1){
                    nums[i]= nums[j];
                }
                j++;
            } else {
                while (j < len) {
                    int b = nums[j];
                    if (a == b){
                        j++;
                    }else {
                        break;
                    }
                }
                if (j>=len){
                    break;
                }
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        int i = new Sln26().removeDuplicates(nums);
        System.out.println(i);
    }
}
