package com.xin.day;

public class Sln1184 {

    //  前缀和
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] pre = new int[distance.length];
        pre[0]= 0;
        int sum = distance[0];
        for (int i = 1; i < distance.length; i++) {
            pre[i] = pre[i-1] + distance[i-1];
            sum += distance[i];
        }
        int dis = pre[destination] - pre[start];
        int result = Math.min(Math.abs(dis),sum - Math.abs(dis));
        return result;

    }

    public static void main(String[] args) {
        int[] distance = {1,2,3,4};
        int start = 0, destination = 2;
        int i = new Sln1184().distanceBetweenBusStops(distance, start, destination);
        System.out.println();
    }
}
