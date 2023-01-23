package Leetcode.Array.moveZeroes;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意，必须在不复制数组的情况下原地对数组进行操作。

https://leetcode.cn/problems/move-zeroes/

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]

提示:
1 <= nums.length <= 104
-231<= nums[i] <= 231- 1

进阶：你能尽量减少完成的操作次数吗？

*/

import java.util.Arrays;

class Solution { //将0全部移动到数组末尾 时间复杂度：O(n) 空间复杂度：O(1)
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        int index = 0; //index用于将非零元素重新赋值给数组，从下标0开始，每次增1
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) { //如果元素不是零，将元素赋值给数组首位，第二个非零元素赋值给数组第二位，依次类推
                nums[index] = nums[i];
                index++; //如果遍历到最后一个非零元素完成，index表示当前添加到的非零元素的索引，而index++表示从index后开始元素都为0
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }
}

//双指针解法更耗时，且思路差不多
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 5, 0, 1, 0, 5, 0, 6, 0, 7};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println("将0移动到末尾后的结果");
        System.out.println(Arrays.toString(nums));
    }
}
