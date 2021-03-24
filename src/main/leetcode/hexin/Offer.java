package main.leetcode.hexin;

import main.leetcode.model.ListNode;
import main.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ezrealhexin
 * @date 2021-03-10 00:11
 **/
public class Offer {

    public static void main(String[] args) {
//        ListNode node = createLinkedList();
////        ListNode listNode = copyNode(node);
////        while (listNode!=null){
////            System.out.println(listNode.val);
////            listNode =listNode.next;
//        }

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
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * 示例 1：
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     */
    public String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return "";
        }
        String s1 = s.substring(0, n);
        s = s.substring(n, s.length());
        return s + s1;
    }


    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 示例 1：
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");

    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 题目:剑指 Offer 52. 两个链表的第一个公共节点
     * 注意：
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * <p>
     * 让两个指针都循环一圈
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


    public static ListNode copyNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode next = node;
        while (head != null) {
            next.next = new ListNode(head.val);
            next = next.next;
            head = head.next;
        }
        return node.next;
    }

    /**
     * 剑指 Offer 35. 复杂链表的复制
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
     * 还有一个 random 指针指向链表中的任意节点或者 null。
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        Node node1 = new Node(0);
        Node node2 = node1;
        while (head != null) {
            Node tempNode = map.get(head);
            node2.next = tempNode;
            tempNode.random = map.get(head.random);
            head = head.next;
            node2 = node2.next;
        }
        return node1.next;
    }

}
