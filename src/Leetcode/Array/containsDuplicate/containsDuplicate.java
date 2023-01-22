package Leetcode.Array.containsDuplicate;

/*
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

https://leetcode.cn/problems/contains-duplicate/

示例 1：
输入：nums = [1,2,3,1]
输出：true

示例 2：
输入：nums = [1,2,3,4]
输出：false

示例3：
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true

提示：
1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

import java.util.Arrays;
import java.util.HashSet;

class Solution { //排序法 判断相邻元素是否相等，相等返回true 时间复杂度：O(n log n) 空间复杂度：O(log n)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

class Solution2 { //利用HashSet存储不相同元素的特性，如果add添加失败，返回false，则证明数组中有相同元素 时间复杂度：O(n) 空间复杂度：O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}

public class containsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Solution solution = new Solution();
        boolean b = solution.containsDuplicate(nums);
        System.out.println(b);
        Solution solution2 = new Solution();
        boolean b1 = solution2.containsDuplicate(nums);
        System.out.println("=========================");
        System.out.println(b1);
    }
}
