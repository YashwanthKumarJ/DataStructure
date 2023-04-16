package com.github.yj.datastructure.linkedlist;

import com.github.yj.datastructure.linkedlist.model.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeLinkedListTest {

    private MergeLinkedList mergeLinkedList;

    @BeforeEach
    public void setUp () {
        mergeLinkedList = new MergeLinkedList();
    }

    @Test
    public void testNullFirstListMerge () {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // List 2
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(null, node1);
        int i=1;
        while(i <= 4) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testNullSecondListMerge () {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // List 2
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(node1, null);
        int i=1;
        while(i <= 4) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testMergeWithFirstListMoreElements () {
        // List 1
        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node5 = new ListNode(5, node7);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);

        // List 2
        ListNode node6 = new ListNode(6);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(node1, node2);
        int i=1;
        while(i <= 9) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testMergeWithSecondListMoreElements () {
        // List 1
        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node5 = new ListNode(5, node7);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);

        // List 2
        ListNode node6 = new ListNode(6);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(node2, node1);
        int i=1;
        while(i <= 9) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testMergeWithSingleElementInList () {
        // List 1
        ListNode node1 = new ListNode(1);

        // List 2
        ListNode node2 = new ListNode(2);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(node1, node2);
        int i=1;
        while(i <= 2) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testTwoProperListsMerge () {
        // List 1
        ListNode node5 = new ListNode(5);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);

        // List 2
        ListNode node6 = new ListNode(6);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);

        ListNode resultNode = mergeLinkedList.mergeTwoLists(node1, node2);
        int i=1;
        while(i <= 2) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @Test
    public void testTwoSequentialElementsListMerge () {
        // List 1
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // List 2
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);


        ListNode resultNode = mergeLinkedList.mergeTwoLists(node1, node5);
        int i=1;
        while(i <= 8) {
            assertEquals(i, resultNode.getValue());
            i++;
            resultNode = resultNode.getNextNode();
        }
    }

    @AfterEach
    public void tearDown () {
        mergeLinkedList = null;
    }
}
