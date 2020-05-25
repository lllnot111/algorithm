public class ReverseString {
    /**
     * reverse a sentence
     * eg: This is a book
     * return: book a is This
     * time complexity O(n),space complexity O(1)
     * 通过一个递归实现，类似翻转链表
     * 微软面试 - 养兔子的大叔的文章 - 知乎
     * https://zhuanlan.zhihu.com/p/55993035
     */
    public String reverseList(String[] s, int m, int n) {
        if (m == n - 1) {
            return s[m];
        }

        return reverseList(s,m+1, n) + " " + s[m];
    }

    public void reverseString(String s) {
        String[] ss = s.split(" ");
        String res = reverseList(ss, 0, ss.length);
        System.out.println(res);
    }
}
