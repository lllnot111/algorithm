public class FindDuplicate {
    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
     *
     * Example 1:
     *
     * Input: [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: [3,1,3,4,2]
     * Output: 3
     * Note:
     *
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     *
     * leetcode第287题：寻找重复数
     * 难度：中等
     * https://leetcode-cn.com/problems/find-the-duplicate-number
     */
    public int findDuplicate(int[] nums) {
        int bits = 31;
        int n = nums.length - 1;
        while (n>>bits == 0) {
            bits--;
        }
        int x = 0;
        int y = 0;
        int res = 0;
        for (;bits>=0;bits--) {
           for(int i = 0;i<nums.length;i++){
               if((nums[i]&1<<bits) == 1<<bits){
                   x++;
               }
               if((i&1<<bits) == 1<<bits) {
                   y++;
               }
           }
            if (x > y) {
                res = res|1<<bits;
            }
            x=0;
            y=0;
        }
        return res;
    }
}
