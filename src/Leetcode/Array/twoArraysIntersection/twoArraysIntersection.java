package Leetcode.Array.twoArraysIntersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
给定两个数组nums1和nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

https://leetcode.cn/problems/intersection-of-two-arrays/

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的

提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

 */
class Solution { //HashSet方法
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numsSet = new HashSet<>(); //用于添加nums1中的元素
        Set<Integer> returnSet = new HashSet<>(); //用于保存找到的数组交集
        for (int num : nums1) { //遍历nums1，将元素存入numsSet
            numsSet.add(num);
        }
        for (int num : nums2) {
            if (numsSet.contains(num)) //如果nums1中的元素包含nums2，将nums2存入答案集合
                returnSet.add(num); //在这个时候，交集元素已经被保存在returnSet中了
        }
        return returnSet.stream().mapToInt(x -> x).toArray(); //将returnSet中的元素转换成数组
        /*这里也可以创建一个returnSet大小的数组，将returnSet中的元素存储*/
    }
}

public class twoArraysIntersection {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1};
        int[] nums2 = {1, 1, 2, 2, 3, 3};
        int[] intersection = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
