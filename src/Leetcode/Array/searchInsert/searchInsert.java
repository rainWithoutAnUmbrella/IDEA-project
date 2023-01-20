package Leetcode.Array.searchInsert;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。

https://leetcode.cn/problems/search-insert-position/

示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2
示例2:
输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:
输入: nums = [1,3,5,6], target = 7
输出: 4

提示:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为无重复元素的升序排列数组
-104 <= target <= 104
*/

class Solution { //二分查找法，时间复杂度:O(log(n)) 空间复杂度:O(1)
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        while (left < right) { //二分法中的left 小于 right
            int middle = left + (right - left) / 2; //每次循环后重新定义中间索引
            if (nums[middle] < target) { //分情况，当中间值小于目标值时，更新left的指向位置
                left = middle + 1; //因为middle也比target小，所以middle无需参加下一轮的循环
            } else {
                right = middle;
            }
        }
        return left;
    }
}

public class searchInsert {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3};
        int target = 4;
        int i = solution.searchInsert(nums, target);
        System.out.println("4应该插入到" + i + "位置");
        int target2 = 3;
        int i1 = solution.searchInsert(nums, target2);
        System.out.println("3应该在" + i1 + "的位置");
    }
}
