package main.leetcode.hexin.linkedlist;

/**
 * @author ezrealhexin
 * @date 2021-03-17 23:44
 **/
public class LinkedList {

    public static void main(String[] args) {

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

//
//    /**
//     * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。
//     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//     * <p>
//     * 输入：head = [1,2,3,4,5], left = 2, right = 4
//     * 输出：[1,4,3,2,5]
//     * 示例 2：
//     * 输入：head = [5], left = 1, right = 1
//     * 输出：[5]
//     * 提示：
//     * <p>
//     * 链表中节点数目为 n
//     * 1 <= n <= 500
//     * -500 <= Node.val <= 500
//     * 1 <= left <= right <= n
//     */
//
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//
//        if (head == null) {
//            return null;
//        }
//        if (left == right) {
//            return head;
//        }
//        ListNode pre = null;
//        ListNode next = null;
//
//        while (head != null) {
//
//            if (head.val <= left && head.val <= right) {
//                next = head.next;
//
//            } else {
//                head = head.next;
//            }
//        }
//
//
//    }


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
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     */
//    public ListNode getKthFromEnd(ListNode head, int k) {
//
//        if (head == null) {
//            return null;
//        }
//        if (k == 0) {
//            return head;
//        }
//        int size = 0;
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//    }
}
