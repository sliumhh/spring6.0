package main.leetcode.hexin.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ezrealhexin
 * @date 2021-03-17 23:44
 **/
public class LinkedList {

    public static void main(String[] args) {

        ListNode node = createLinkedList();

    }

    /**
     * 创建链表并返回头节点
     */
    public static ListNode createLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    /**
     * 题目: 剑指 Offer 24. 反转链表
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 题目: 92. 反转链表 II
     * <p>
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * <p>
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * <p>
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] arrs = list.toArray(new Integer[0]);
        while (left < right) {
            int temp = arrs[left - 1];
            arrs[left - 1] = arrs[right - 1];
            arrs[right - 1] = temp;
            left++;
            right--;
        }

        ListNode pre = new ListNode(0);
        ListNode next = pre;
        for (int i = 0; i < arrs.length; i++) {
            ListNode tempNode = new ListNode(arrs[i]);
            pre.next = tempNode;
            pre = tempNode;
        }
        return next.next;
    }

    /**
     * 题目: 剑指 Offer 06. 从尾到头打印链表
     * <p>
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        int size = 0;
        if (head == null) {
            return new int[size];
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            size++;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        int[] arrs = new int[size];
        int num = 0;
        while (pre != null) {
            arrs[num] = pre.val;
            num++;
            pre = pre.next;
        }
        return arrs;
    }


    /**
     * 题目: 剑指 Offer 18. 删除链表的节点
     * <p>
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * 题目保证链表中节点的值互不相同
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode listNode = null;
        if (head.val == val) {
            listNode = head.next;
            head.next = null;
            return listNode;
        }
        ListNode pre = head;
        ListNode next = head.next;

        while (next != null && next.val != val) {
            pre = next;
            next = next.next;
        }

        if (next != null) {
            pre.next = next.next;
        }
        return head;
    }


    /**
     * 题目 :剑指 Offer 25. 合并两个排序的链表
     *
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <
     * 限制：
     * 0 <= 链表长度 <= 1000
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int num = 0;
        ListNode l11 = l1;
        ListNode l22 = l2;
        while (l11 != null) {
            num++;
            l11 = l11.next;
        }
        while (l22 != null) {
            num++;
            l22 = l22.next;
        }
        int[] a = new int[num];
        int size = 0;
        while (l1 != null) {
            a[size] = l1.val;
            size++;
            l1 = l1.next;
        }
        while (l2 != null) {
            a[size] = l2.val;
            size++;
            l2 = l2.next;
        }
        Arrays.sort(a);
        ListNode pre = new ListNode(0);
        ListNode next = pre;
        for (int i = 0; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            pre.next = temp;
            pre = temp;
        }
        return next.next;
    }

}
