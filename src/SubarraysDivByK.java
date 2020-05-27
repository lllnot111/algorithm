import java.util.HashMap;

public class SubarraysDivByK {
    /**
     * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
     *
     * Example 1:
     *
     * Input: A = [4,5,0,-2,-3,1], K = 5
     * Output: 7
     * Explanation: There are 7 subarrays with a sum divisible by K = 5:
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     *  
     * Note:
     *
     * 1 <= A.length <= 30000
     * -10000 <= A[i] <= 10000
     * 2 <= K <= 10000
     *
     * LeetCode第974题：和可被 K 整除的子数组
     * 难度：中等
     * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int k = sum % K;
            if (k < 0) {
                k = K + k;
            }
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        for (Integer item : map.values()) {
            count += item * (item - 1) / 2;

        }
        return map.containsKey(0) ? count + map.get(0) : count;
    }
}
