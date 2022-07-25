package com.weekend.w303;

import java.util.TreeSet;

public class Sln6124 {
    public char repeatedCharacter(String s) {
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return c;
            }else {
                set.add(c);
            }
        }
        return 'a';
    }
    public static void main(String[] args) {

    }
}
