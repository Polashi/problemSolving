package com.epam.samsung;

public class ListNode {
    int value;
    ListNode next;

    public ListNode getNext() {
        return next;
    }

    public void setNode(ListNode node) {
        this.next = node;
    }

    public ListNode(int val, ListNode node) {
        this.value = val;
        this.next = node;
    }
}
