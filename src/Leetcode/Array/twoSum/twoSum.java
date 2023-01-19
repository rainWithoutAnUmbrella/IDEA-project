package Leetcode.Array.twoSum;

/*
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */

import java.util.Arrays;
import java.util.HashMap;

/*时间复杂度:O(n^2)遍历两次数组 空间复杂度:O(1)未使用额外空间*/
class Solution { //使用双重循环暴力求解
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) { //先固定数组中的一个数，循环遍历数组中的其他数，直到找到符合条件要求的值
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j}; //返回找到的对应两个数组的下标
                }
            }
        }
        return new int[]{-1, -1}; //未找到，返回下标[-1,-1];
    }
}

/*时间复杂度：O(n) 空间复杂度：哈希表O(n)*/
class Solution2 { //使用哈希表键值对方法 --只需遍历一次数组
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i); //将数组元素作为键，元素对应的下标作为值依次进行添加
            if (hashMap.containsKey(target - nums[i])) { //需要查找的元素其实就等于 target - nums[i] 的值
                return new int[]{i, hashMap.get(target - nums[i])}; //如果找到，直接返回对应的值，也就是对应的下标，此时只需遍历一次数组
            }
        }
        return new int[]{-1, -1};
    }
}

public class twoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 8, 7, 22};
        int target = 29;
        int notValidTarget = 5;
        int[] ints = solution.twoSum(nums, target);
        System.out.println("Solution 暴力方法测试");
        System.out.println("给定的数组:[1,5,8,7,22],target:29,计算得出返回的数组下标:" + Arrays.toString(ints));
        System.out.println("=========================");
        int[] ints1 = solution.twoSum(nums, notValidTarget);
        System.out.println("给定的数组:[1,5,8,7,22],target:5,计算得出返回的数组下标:" + Arrays.toString(ints1));
        System.out.println("=========================");
        System.out.println("空值和0测试");
        int[] nullptr = new int[]{};
        int[] zero = new int[]{0};
        int[] ints2 = solution.twoSum(nullptr, target);
        int[] zero1 = solution.twoSum(zero, target);
        System.out.println(Arrays.toString(ints2) + "   " + Arrays.toString(zero1));
        System.out.println("=========================");
        System.out.println("Solution2 哈希表测试");
        Solution2 solution2 = new Solution2();
        int[] ints3 = solution2.twoSum(nums, target);
        System.out.println("给定的数组:[1,5,8,7,22],target:29,计算得出返回的数组下标:" + Arrays.toString(ints3));
        System.out.println("=========================");
        int[] ints4 = solution2.twoSum(nums, notValidTarget);
        System.out.println("给定的数组:[1,5,8,7,22],target:5,计算得出返回的数组下标:" + Arrays.toString(ints4));
        System.out.println("=========================");
        System.out.println("空值和0测试");
        int[] ints5 = solution2.twoSum(nullptr, target);
        int[] ints6 = solution2.twoSum(zero, target);
        System.out.println(Arrays.toString(ints5) + "   " + Arrays.toString(ints6));
    }
}
