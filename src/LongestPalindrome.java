public class LongestPalindrome {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     *
     * leetcode第5题：最长回文子串
     * 难度：中等
     * https://leetcode-cn.com/problems/longest-palindromic-substring
     * 采用动态规划的方式来做，用一个二维数组来存储对应的子串是否为回文串（palindrome(i,j)代表从i到j的子串，该值为true时表示该子串
     * 为回文串），这样，只要找到j-i最大的点就可以了。
     */
    public static String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        char[] cs = s.toCharArray();
        int max = 0;
        int m = 0;
        int n = 0;
        for (int i = palindrome.length - 2; i >=0; i--) {
            for(int j = i;j < palindrome.length; j++) {
                if (j==i) {
                    palindrome[i][j] = true;
                }
                else if(j == i + 1) {
                    palindrome[i][j] = cs[i] == cs[j];
                }
                else {
                    palindrome[i][j] = (cs[i] == cs[j]) && palindrome[i + 1][j - 1];
                }
                if(palindrome[i][j] && max < j-i){
                    max = j-i;
                    m = i;
                    n = j;
                }

            }
        }
        return s.substring(m,n+1);
    }
}
