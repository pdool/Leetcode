package com.xin.dp.medium;

import java.util.ArrayList;
import java.util.List;

public class SlnOfferII085 {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backTrack(resultList,n,n,new StringBuffer());
        return resultList;
    }

    private void backTrack(List<String> resultList, int left, int right, StringBuffer sb) {
        if (left == 0 && right == 0){
            resultList.add(sb.toString());
            return;
        }
        if (left >0){
            sb.append("(");
            backTrack(resultList,left -1,right,sb);
            sb.deleteCharAt(sb.length() -1);
        }
        if (right > left){
            sb.append(")");
            backTrack(resultList,left,right-1,sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
