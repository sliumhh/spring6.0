package main.leetcode.wawa.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author sliu
 * @date 2021/3/17 8:33 下午
 */
public class Solution {

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。
     * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * @param head
     *
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        int index = 0;
        while (cur != null && index < k) {
            cur = cur.next;
            index++;
        }
        while (cur != null) {
            cur = cur.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * @param head
     *
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
//        if (head == null) return null;
//        ListNode pre = null, next;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    /**
     * 两个链表的第一个公共节点
     *
     * @param headA
     * @param headB
     *
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return hb;
    }

}
