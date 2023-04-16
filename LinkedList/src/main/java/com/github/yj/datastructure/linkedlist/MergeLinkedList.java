/**
 * This class provides solution to merge two linked list which are ordered.
 * The final list should also be ordered
 *
 * @author Yashwanth
 */
package com.github.yj.datastructure.linkedlist;

import com.github.yj.datastructure.linkedlist.model.ListNode;

public class MergeLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sortedList = null;

        // If any of the list is empty, just return other list
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            // No list is empty, we need to iterate to merge the list
            ListNode temp = null;

            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    if (temp != list2) {
                        temp.setNextNode(list2);
                    }
                    break;
                } else if (list2 == null) {
                    if (temp != list1) {
                        temp.setNextNode(list1);
                    }
                    break;
                } else {
                    if (list1.getValue() < list2.getValue()) {
                        if (temp == null) {
                            temp = list1;
                            sortedList = list1;
                        } else {
                            temp.setNextNode(list1);
                            temp = list1;
                        }

                        list1 = list1.getNextNode();
                    } else {
                        if (temp == null) {
                            temp = list2;
                            sortedList = list2;
                        } else {
                            temp.setNextNode(list2);
                            temp = list2;
                        }

                        list2 = list2.getNextNode();
                    }
                }
            }
        }

        return sortedList;
    }
}
