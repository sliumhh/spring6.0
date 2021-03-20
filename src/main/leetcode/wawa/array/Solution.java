package main.leetcode.wawa.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *
 * @author sliu
 * @date 2021/3/18 4:15 下午
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 9, 5, 2, 7};
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) return;
        int p = part(nums, low, high);
        part(nums, low, p - 1);
        part(nums, p + 1, high);
        printArray(nums);
    }

    public static int part(int[] nums, int low, int high) {
        int h = high;
        int last = nums[high];
        while (low < high) {
            while (low < high && nums[low] <= last) {
                low++;
            }
            if (low < high) {
                swap(nums, --high, low);
            }
        }
        swap(nums, h, low);
        return low;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print("\t" + nums[i]);
        }
        System.out.println();
    }


    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        int index = 0;
        int[] ans = new int[rows * columns];

        while ((left <= right && top <= bottom)) {
            for (int column = left; column <= right; column++) {
                ans[index++] = matrix[top][column];
            }
            System.out.println(Arrays.toString(ans));
            for (int row = top + 1; row <= bottom; row++) {
                ans[index++] = matrix[row][right];
            }

            for (int column = right - 1; column >= left; column--) {
                ans[index++] = matrix[bottom][column];
            }
            for (int row = bottom - 1; row > top; row--) {
                ans[index++] = matrix[row][left];
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }


    /**
     * 12345666678
     * 统计一个数字在排序数组中出现的次数。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) break;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(mid);
        int counter = 0;
        left = mid;
        right = mid + 1;
        while (nums[left--] == target && left >= 0) {
            counter++;
        }
        while (nums[right++] == target && right < nums.length) {
            counter++;
        }
        return counter;
    }


    /**
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != i) {
//                return nums[i];
//            }
//            int temp = nums[i];
//            nums[i] = nums[temp];
//            nums[temp] = temp;
//        }
//        return -1;

    }
}
