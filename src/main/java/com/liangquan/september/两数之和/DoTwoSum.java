package com.liangquan.september.两数之和;


import java.util.Arrays;
import java.util.HashMap;

/* *
 * @Title: 两数之和
 * @Author: liangquan
 * @Date: 2024-09-21 22:43:00
 * @Params:  
 * @Return: null
 * @Description: null
 */
public class DoTwoSum {
    public static void main(String[] args) {

        // 数据
        int[] nums = {3, 3};
        int target = 6;

        // 暴力破解
        int[] res_1 = twoSum_1(nums, target);
        int[] res_2 = twoSum_2(nums, target);

        // 结果
        System.out.println("res = " + Arrays.toString(res_1));
        System.out.println("res = " + Arrays.toString(res_2));
    }

    /***
     * 方法一：暴力破解法
     * @param nums
     * @param target
     * @return
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * 遇到这种时间复杂度和空间复杂度的，可以使用空间换时间来做
     */
    public static int[] twoSum_1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int ch = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == ch) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }


    /**
     * 方法二：哈希映射
     *
     * @param nums
     * @param target
     * @return
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * <p>
     * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     * 如果最终都没有结果则抛出异常
     */
    private static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
