package com.weekend.w303;

import javax.swing.tree.RowMapper;
import java.util.*;

public class Sln6125 {
    public int equalPairs(int[][] grid) {
        Map<String ,Integer> rowSet = new HashMap<>();
        Map<String,Integer > columnSet = new HashMap<>();

        int len = grid.length;

        for (int i = 0; i < len; i++) {
            int[] row = grid[i];
            StringBuffer sb = new StringBuffer();
            for (int i1 : row) {
                sb.append(i1);
                sb.append("-");
            }
            Integer orDefault = rowSet.getOrDefault(sb.toString(), 0);
            rowSet.put(sb.toString(),orDefault+1);
        }
        for (int i = 0; i < len; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < len; j++) {
                int value = grid[j][i];
                sb.append(value);
                sb.append("-");
            }
            Integer orDefault = columnSet.getOrDefault(sb.toString(), 0);
            columnSet.put(sb.toString(),orDefault+1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : rowSet.entrySet()) {
            String key = stringIntegerEntry.getKey();
            int value = stringIntegerEntry.getValue();
            Integer orDefault = columnSet.getOrDefault(key, 0);
            count = count + orDefault*value;
        }

        return count;

    }
}
