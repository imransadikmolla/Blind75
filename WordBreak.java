import java.util.*;

public class WordBreak {
  // TC = O(n*2×m)
    public boolean wordBreakDP(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: Empty string can be segmented

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }

        return dp[n];
    }

  // TC = O(n*2×m)
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) continue;
            visited[start] = true;

            for (int end = start + 1; end <= s.length(); end++) {
                if (wordSet.contains(s.substring(start, end))) {
                    if (end == s.length()) return true;
                    queue.add(end);
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreakDP(s, wordDict)); // Output: true
        System.out.println(solution.wordBreakBFS(s, wordDict)); // Output: true
    }
}
