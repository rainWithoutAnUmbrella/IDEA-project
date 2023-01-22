package Leetcode.Array.majorityElement;

/*
给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

https://leetcode.cn/problems/majority-element/

示例1：
输入：nums = [3,2,3]
输出：3

示例2：
输入：nums = [2,2,1,1,1,2,2]
输出：2

提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
*/

import java.util.Arrays;

class Solution { //排序法，题目要求出现次数 > nums.length / 2 的元素，如果对数组排序，那么中位数就是所求的数
    //时间复杂度：O(n log n)-排序所耗费 空间复杂度：O(log n)-排序所耗费
    public int majorityElement(int[] nums) { //注意测试用例，题目中规定元素出现次数超过数组长度的一半时，此元素才被称为多数元素
        Arrays.sort(nums); //对数组排序后，中位数就是众数
        return nums[nums.length / 2];
    }
}

class Solution2 { //投票法，遇到相同的数，count++，不相同的，count--，最后剩下的就是多数元素 时间复杂度：O(n) 空间复杂度：O(1)
    public int majorityElement(int[] nums) {
        int count = 1; //首先选举数组第一个元素作为当前阵营
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) { //如果遇到相同元素，则count++
                count++;
            }
            if (nums[i] != candidate) { //如果遇到不同元素，则当前阵营元素和遇到的元素互相抵消1，count--
                count--;
            }
            if (count == 0) { //如果当前count==0，就是说目前不存在阵营，则下一个元素成为新的阵营
                candidate = nums[i + 1];
            }
        }
        return candidate; //返回最后剩下的
    }
}

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 2, 2, 3, 3, 3, 3, 3};
        Solution solution = new Solution();
        int i = solution.majorityElement(nums);
        System.out.println("nums中的多数元素：" + i);
        System.out.println("=========================");
        Solution solution2 = new Solution();
        int i1 = solution2.majorityElement(nums);
        System.out.println("nums中的多数元素：" + i1);
    }
}
