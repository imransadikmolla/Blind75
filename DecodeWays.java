class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int prev2 = 1, prev1 = 1; // dp[-1] = dp[0] = 1

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            // Single-digit decode (if s[i] is not '0')
            if (s.charAt(i) != '0') {
                current += prev1;
            }

            // Two-digit decode (if valid between 10-26)
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            // Shift values for next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
