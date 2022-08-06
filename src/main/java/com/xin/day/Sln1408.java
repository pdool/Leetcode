package com.xin.day;

import java.util.ArrayList;
import java.util.List;

public class Sln1408 {

    public List<String> stringMatching(String[] words) {
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            for (String s : words) {
                if (s.equals(word)){
                    continue;
                }
                if (word.contains(s) && !resultList.contains(s)){
                    resultList.add(s);
                }
            }
        }
        return resultList;
    }
}
