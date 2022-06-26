package com.xin.backtrack;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.TreeMap;

public class Sln401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> resultList = new ArrayList<>();
        boolean[] selected = new boolean[10];
        backtrack(turnedOn,resultList,selected);
        return resultList;
    }

    private void backtrack(int turnedOn, List<String> resultList, boolean[] selected) {
        if(turnedOn == 0){
            addToResult(resultList,selected);
            return;
        }
        for (int i =0;i<10;i++){
            if (selected[i]){
                continue;
            }
            selected[i] = true;
            backtrack(turnedOn -1,resultList,selected);
            selected[i] = false;
        }
    }

    private void addToResult(List<String> resultList, boolean[] selected) {
        int h = 0;
        for (int i = 0; i < 4; i++) {
            if (selected[i]){
                h += Math.pow(2, 3 - i);
            }
            if (h >=12){
                return;
            }
        }
        int m = 0;
        for (int i = 4; i < 10; i++) {
            if (selected[i]){
                m += Math.pow(2, 9 - i);
            }
            if (m >=60){
                return;
            }
        }
        String item = h + ":" + (m < 10 ? "0" : "") + m;
        if (!resultList.contains(item)){
            resultList.add(item);
        }
    }

    public static void main(String[] args) {
        boolean[] r = {false,true,false,false};
        List<String> strings = new Sln401().readBinaryWatch(2);
        System.out.println(strings);
    }
}
