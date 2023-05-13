package com.github.yashwanth.datastructure.linkedlist.program;

import com.github.yashwanth.datastructure.linkedlist.model.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListTest {

    ReverseLinkedList list;

    @BeforeEach
    void init() {
        list = new ReverseLinkedList();
    }

    @Test
    void shouldNotFailForNullInput() {
        assertNull(list.reverse(null));
    }

    @Test
    void shouldNotFailForSingleNode() {
        ListNode node1 = new ListNode(1);
        ListNode node = list.reverse(node1);

        assertEquals(node1.getValue(), node.getValue());
        assertNull(node.getNextNode());
    }

    @Test
    void shouldReverseListWithEvenElements() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 2;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }

    @Test
    void shouldReverseListWithOddElements() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node2.setNextNode(node3);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 3;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }

    @Test
    void shouldReverseListWithMoreElements() {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node6.setNextNode(node7);
        node5.setNextNode(node6);
        node4.setNextNode(node5);
        node3.setNextNode(node4);
        node2.setNextNode(node3);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 7;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }

    @Test
    void shouldNotFailForNullInputV2() {
        assertNull(list.reverse(null));
    }

    @Test
    void shouldNotFailForSingleNodeV2() {
        ListNode node1 = new ListNode(1);
        ListNode node = list.reverse(node1);

        assertEquals(node1.getValue(), node.getValue());
        assertNull(node.getNextNode());
    }

    @Test
    void shouldReverseListWithEvenElementsV2() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 2;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }

    @Test
    void shouldReverseListWithOddElementsV2() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node2.setNextNode(node3);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 3;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }

    @Test
    void shouldReverseListWithMoreElementsV2() {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node6.setNextNode(node7);
        node5.setNextNode(node6);
        node4.setNextNode(node5);
        node3.setNextNode(node4);
        node2.setNextNode(node3);
        node1.setNextNode(node2);


        ListNode node = list.reverse(node1);

        int i = 7;
        while (node != null) {
            assertEquals(node.getValue(), i--);
            node = node.getNextNode();
        }
    }
}