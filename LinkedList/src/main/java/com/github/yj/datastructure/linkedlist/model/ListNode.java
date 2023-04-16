/**
 * This model class can be used as a node in linked list.
 * This node can be used for singly linked list where list flows in one direction
 *
 * @author Yashwanth
 */
package com.github.yj.datastructure.linkedlist.model;

import lombok.Data;

@Data
public class ListNode {

    private int value;

    private ListNode nextNode;

    public ListNode(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public ListNode(int value, ListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
}
