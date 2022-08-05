package com.xin.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Sln93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> resultList = new ArrayList<>();
        backtrack(s, resultList, new ArrayList<>(), 0);
        return resultList;
    }

    /**
     *
     * @param s 原字符串
     * @param resultList 最终结果
     * @param item 回溯中间结果
     * @param index 当前到哪个字符了
     */
    private void backtrack(String s, List<String> resultList, List<String> item, int index) {
        //  分成了4段，并且已经超过了索引
        if (index >= s.length() && item.size() == 4) {
            resultList.add(String.join(".", item));
            return;
        }
        //  超过4段，或者已经分完了
        if (item.size() > 4 || index > s.length() - 1) {
            return;
        }
        //  只有1-3 位
        for (int i = index; i < s.length() && i < index + 3; i++) {
            String numStr = s.substring(index, i + 1);
            if (isValid(numStr)) {
                item.add(numStr);
                backtrack(s, resultList, item, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }

    /**
     * 验证字符串是不是在255以内
     * @param numStr
     * @return
     */
    private boolean isValid(String numStr) {
        //  0开始的，不符合
        if (numStr.length() != 1 && numStr.startsWith("0")) {
            return false;
        }
        //  正常的数字转换，不可以超过255
        int num = Integer.parseInt(numStr);
        if (num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> strings = new Sln93().restoreIpAddresses("101023");
        System.out.println(strings);
    }
}
