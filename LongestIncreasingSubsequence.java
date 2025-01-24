import java.util.Arrays;

public class LongestIncreasingSubsequence {

//o(n^2) solution
    public static int lengthOfLISN2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is an LIS of length 1 by itself

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The length of the LIS is the maximum value in the dp array
        return Arrays.stream(dp).max().orElse(0);
    }
//o(nlogn) solution
 public int lengthOfLISNlogN(int[] nums) {
        if(nums.length==0)
            return 0;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }
            else{
                int index=lowerBound(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return list.size();   
    }
    public int lowerBound(List<Integer> sub, int target){
        int left = 0, right = sub.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sub.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lengthOfLISN2(nums)); // Output: 4
        System.out.println("Length of LIS: " + lengthOfLISNlogN(nums)); // Output: 4
    }
}
