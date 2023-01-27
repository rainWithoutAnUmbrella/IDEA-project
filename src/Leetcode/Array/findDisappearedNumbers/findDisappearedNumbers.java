package Leetcode.Array.findDisappearedNumbers;
/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

示例 1：
输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]

示例 2：
输入：nums = [1,1]
输出：[2]

提示：
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution { //哈希表
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>(); //HashSet用来存放给定的数组元素
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) { //如果HashSet中不存在该数，则添加到list集合中
                list.add(i);
            }
        }
        return list;
    }
}

public class findDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}

