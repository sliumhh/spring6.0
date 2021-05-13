package leetcode.hexin.linkedlist;

import main.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ezrealhexin
 * @date 2021-03-17 23:44
 **/
public class LinkedList {

    public static void main(String[] args) {

        ListNode node = createLinkedList();
        removeElements(node, 2);

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
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
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
     * 题目: 203. 移除链表元素
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }


    /**
     * 题目 :剑指 Offer 25. 合并两个排序的链表
     * <p>
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <
     * 限制：
     * 0 <= 链表长度 <= 1000
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return node.next;
    }


    /**
     * 题目: 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        int num = 1;
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            if (num > k) {
                l2 = l2.next;
            }
            num++;
        }
        return l2;
    }


    /**
     * 题目: 编写一个程序，找到两个单链表相交的起始节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = headB;
            }
            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = headA;
            }
        }
        return l2;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head != null) {
            if (!set.add(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
