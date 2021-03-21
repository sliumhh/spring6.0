package main.leetcode.hexin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ezrealhexin
 * @date 2021-03-10 00:10
 **/
public class Hot {


    public static void main(String[] args) {

        int[] arrays = new int[]{4, 1, 2, 1, 2};


        swap(1,3);

    }

    public static void swap(int a, int b) {
        int a1 = 0;
        int b1 = 0;
        if (a != b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }


    /**
     * 题目: 有效的括号
     *
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 1 左括号必须用相同类型的右括号闭合。
     * 2 左括号必须以正确的顺序闭合。
     *
     * 思路: 因为要求有序,所以最里面的扩号可以直接替换成"",然后第二层变成第一层,一直到替换结束
     *
     */
    public boolean isValid(String s) {
        if (s==null||"".equals(s)){
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {

            if (s.contains("()")){
               s= s.replace("()","");
            }
            if (s.contains("[]")){
               s= s.replace("[]","");
            }
            if (s.contains("{}")){
                s=s.replace("{}","");
            }

        }
        return s.length() == 0;
    }


    /**
     * 题目: 两数之和
     * <
     * 给定一个整数数组 nums 和一个整数目标值 target，请你
     * 在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     *
     * 思路: 暴力破解循环2遍性能低没意义,循环一遍即可,定义map,每一次循环判断map的key是否包含target-nums[i],
     * 包含说明map已经包含两个位置加起来等于target的2个数字了,直接返回
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     *
     * 题目:只出现一次的数字
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 思路 运用异或运算的性质
     * 1、交换律 a^b = b^a
     * 2、结合律 (a^b)^c == a^(b^c)
     * 3、对于任何数x，都有 x^x=0，x^0=x
     * 4、自反性: a^b^b=a^0=a;
     *
     * 此处可以运用第3条性质,因为只有一个元素出现一次,那么把数组所有元素进行异或运算,结果返回的就是只出现一次的元素
     */

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 题目: 多数元素
     *
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     * 思路: 1 因为数量大于n/2,所以排序完之后,中间的数一定是大多数的那个
     *      2 用map记数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * 题目: 剑指 Offer 03. 数组中重复的数字
     * <p>
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return  -1;
    }

}
