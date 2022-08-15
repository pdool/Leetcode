package com.weekend.w306;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import sun.security.krb5.internal.rcache.DflCache;

import java.util.*;

//  https://leetcode.cn/contest/weekly-contest-306/problems/construct-smallest-number-from-di-string/
public class Sln6150 {
    List<String> list = new ArrayList<>();

    public String smallestNumber(String pattern) {
        HashSet<Integer> used = new HashSet<>();
        Deque<Integer> sb = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            used.add(i);
            sb.add(i);
            backTrack(pattern, used,  sb);
            used.remove(i);
            sb.removeLast();
        }
        Collections.sort(list);
        return list.get(0);
    }

    private void backTrack(String pattern, HashSet<Integer> used, Deque<Integer> sb) {
        int index = sb.size()-1;
        if (index >= pattern.length()) {
            String  s = "";
            for (Integer integer : sb) {
                s += integer;
            }
            list.add(s);
            return;
        }
        char c = pattern.charAt(index);
        for (int i = 1; i < 10; i++) {
            if (used.contains(i)) {
                continue;
            }
            Integer last = sb.getLast();
            if (c == 'I') {
                if (i > last) {
                    used.add(i);
                    sb.add(i);
                    backTrack(pattern, used,  sb);
                    used.remove(i);
                    sb.removeLast();
                }
            } else {
                if (i < last) {
                    used.add(i);
                    sb.add(i);
                    backTrack(pattern, used,  sb);
                    used.remove(i);
                    sb.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = new Sln6150().smallestNumber("ID");
        System.out.println(s);
    }
}
