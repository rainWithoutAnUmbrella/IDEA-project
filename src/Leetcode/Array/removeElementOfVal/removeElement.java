package Leetcode.Array.removeElementOfVal;
/*
给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

https://leetcode.cn/problems/remove-element/

说明:
为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
  print(nums[i]);
}

示例 1：

输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
示例 2：

输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

提示：

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
*/

class Solution { //使用额外创建的数组来存放答案，时间复杂度:O(n^2) 空间复杂度:O(n)
    public int removeElement(int[] nums, int val) {
        int numslen = nums.length;
        int[] tempNums = new int[numslen];
        int countValNotZero = 0;
        if (numslen == 0) { //特殊情况的判断
            return 0;
        }
        for (int num : nums) {
            if (num != val) { //把数组中非val的元素先赋值给临时数组
                tempNums[countValNotZero] = num;
                countValNotZero++;
            }
        }
        //再把临时数组中的数重新赋值给原数组
        if (countValNotZero >= 0) System.arraycopy(tempNums, 0, nums, 0, countValNotZero);
        return countValNotZero;
    }
}

class Solution2 { //双指针解法-原地修改数组 时间复杂度:O(n) 空间复杂度:O(1)
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0; //left指针初始指向数组的首元素，用来重新赋值
        for (int right = 0; right < len; right++) { //right指针用来遍历数组，空间复杂度：O(n)
            if (nums[right] != val) { //当right指向的元素不为需要删除的元素时，则此时对应的nums[right]一定是符合要求的元素，将其依次从数组开头赋值
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}

public class removeElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3};
        int val = 3;
        Solution solution = new Solution();
        System.out.println("=========================");
        int i = solution.removeElement(nums, val);
        System.out.println("给定数组为[2,2,3,3],应得到的答案：");
        for (int j = 0; j < i; j++) {
            System.out.print(" " + nums[j]);
        }
        System.out.println("=========================");
        Solution2 solution2 = new Solution2();
        System.out.println("=========================");
        int i2 = solution2.removeElement(nums, val);
        System.out.println("给定数组为[2,2,3,3],应得到的答案：");
        for (int j = 0; j < i2; j++) {
            System.out.print(" " + nums[j]);
        }
    }
}
