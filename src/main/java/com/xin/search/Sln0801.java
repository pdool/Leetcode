package com.xin.search;

public class Sln0801 {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int mod = 1000000007;
        int a1 = 1;
        int a2 = 2;
        int a3 = 4;
        int result = a3;
        for (int i = 4; i <= n; i++) {
            //  这地方取模还是没懂
            result = ((a1  + a2)%mod + a3 ) % mod;

            a1 = a2;
            a2 = a3;
            a3 = result;
        }
        return result;
    }
    //  到底哪里取模
    public static void main(String[] args) {
        new Sln0801().waysToStep(61);
    }
}
