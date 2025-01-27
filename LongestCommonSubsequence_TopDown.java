public class LongestCommonSubsequence_TopDown {
    public static int lcs(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        // Initialize the memoization array with -1
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        return lcsHelper(s1, s2, s1.length(), s2.length(), memo);
    }

    private static int lcsHelper(String s1, String s2, int m, int n, int[][] memo) {
        // Base Case: If either string is empty, LCS is 0
        if (m == 0 || n == 0) {
            return 0;
        }

        // Check if the value is already computed
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        // If characters match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + lcsHelper(s1, s2, m - 1, n - 1, memo);
        } else {
            // If characters don't match
            memo[m][n] = Math.max(lcsHelper(s1, s2, m - 1, n, memo), lcsHelper(s1, s2, m, n - 1, memo));
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of LCS: " + lcs(s1, s2)); // Output: 4
    }
}
