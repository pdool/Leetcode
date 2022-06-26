package com.xin.topologicsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sln210 {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
    //  答案超时了
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer> resultList = new ArrayList<>();
//        List<List<Integer>> inCount = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            inCount.add(new ArrayList<>());
//        }
//        // 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
//        for (int[] target : prerequisites) {
//            int to = target[0];
//            int from = target[1];
//            List<Integer> fromList = inCount.get(to);
//            fromList.add(from);
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < inCount.size(); i++) {
//            if (inCount.get(i).size() == 0) {
//                queue.add(i);
//                resultList.add(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            Integer peek = queue.poll();
//            for (List<Integer> integers : inCount) {
//                integers.remove(peek);
//            }
//            for (int i = 0; i < inCount.size(); i++) {
//                if (inCount.get(i).size() == 0 && !resultList.contains(i)) {
//                    queue.add(i);
//                    resultList.add(i);
//                }
//            }
//        }
//
//        if (resultList.size() != numCourses){
//            return new int[0];
//        }
//        int[] result = new int[numCourses];
//        for (int i = 0; i < resultList.size(); i++) {
//            result[i]= resultList.get(i);
//        }
//        return result;
//
//    }

    public static void main(String[] args) {
        int[][] a = {{1,0},{1,2},{0,1}};
        new Sln210().findOrder(3,a );
    }
}
