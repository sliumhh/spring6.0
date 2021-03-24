package main.leetcode.model;

/**
 * @author ezrealhexin
 * @date 2021-03-24 00:02
 **/
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
