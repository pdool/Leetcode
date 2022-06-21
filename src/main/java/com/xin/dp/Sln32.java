package com.xin.dp;

import java.util.Deque;
import java.util.LinkedList;

public class Sln32 {
    //  栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    //  栈，双指针
    //  每一个位置作为中间点进行扫描
    // dp
}
