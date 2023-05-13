/**
 * This program will reverse a given singly linked list.
 * <p>
 * There are two implementations for reversing the list.
 * 1. Recursion
 * 2. While Loop
 * <p>
 * Both of then have O(n) runtime complexity.
 * If the number of elements is quite large, the recursion approach can saturate/run out of stack space
 *
 * @author Yashwanth
 */
package com.github.yashwanth.datastructure.linkedlist.program;

import com.github.yashwanth.datastructure.linkedlist.model.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode node) {
        if (node == null || node.getNextNode() == null) {
            return node;
        }

        ListNode rNode = reverse(node.getNextNode());
        node.getNextNode().setNextNode(node);
        node.setNextNode(null);

        return rNode;
    }

    public ListNode reverseUsingLoop(ListNode node) {
        if (node == null || node.getNextNode() == null) {
            return node;
        }

        ListNode front = null;
        while (node != null) {
            if (front == null) {
                front = node;
                node = node.getNextNode();
                front.setNextNode(null);
            } else {
                ListNode temp = node;
                node = node.getNextNode();
                temp.setNextNode(front);
                front = temp;
            }
        }

        return front;
    }

    private void displayList(ListNode node) {
        while (node != null) {
            System.out.print(node.getValue());
            node = node.getNextNode();
        }
        System.out.println();
    }
}
