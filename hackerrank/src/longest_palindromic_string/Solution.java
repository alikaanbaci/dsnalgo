package longest_palindromic_string;

import java.util.Arrays;

public class Solution {
    private boolean [][] dp;
    private int maxI = 0;
    private int maxJ = 0;

    /* Dynamic Programming */
    public String longestPalindromeDP(String s) {

        if(s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        dp = new boolean[n][n];

        for(boolean [] b : dp){
            Arrays.fill(b, false);
        }

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; i+j < n; j++) {
                if(s.charAt(j) == s.charAt(i+j)) {
                    if(i < 2 || dp[j+1][i+j-1]) {
                        dp[j][i+j] = true;

                        if(maxI < i) {
                            maxI = i;
                            maxJ = i+j;
                        }

                    }
                }
            }
        }

        return s.substring(maxJ-maxI, maxJ+1);
    }

    /* Brute Force Solution */
    public String longestPalindrome(String s) {
        String max = "";
        String searching = "";
        int size = s.length();

        for(int i = 0; i < size; i++) {
            for(int j = i; j<size; j++) {
                searching = s.substring(i, j+1);
                if(isPalindrome(searching)) {
                    if(max.length() < searching.length()) {
                        max = searching;
                    }
                }
            }
        }

        return max;
    }

    private Boolean isPalindrome(String s) {

        int size = s.length();

        if(size == 1) return true;

        for(int i = 0; i < size/2; i++) {
            if(s.charAt(i) != s.charAt(size-1-i)) {
                return false;
            }
        }

        return true;
    }

    public void longest(String s) {

    }
}
