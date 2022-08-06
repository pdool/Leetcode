package com.xin.twopointer.easy;

public class Sln9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int begin = 0;
        int end = str.length()-1;
        while (end >= begin){
            char b = str.charAt(begin);
            char e = str.charAt(end);
            if (b != e){
                return false;
            }
            begin++;
            end --;
        }
        return true;
    }
}
