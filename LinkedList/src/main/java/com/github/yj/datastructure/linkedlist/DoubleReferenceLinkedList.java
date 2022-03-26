package com.github.yj.datastructure.linkedlist;

import com.github.yj.datastructure.linkedlist.model.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleReferenceLinkedList<T> implements Iterable<T> {

    private Node<T> headNode;

    private Node<T> tailNode;

    private int size = 0;

    public void add(T data) {
        Node<T> childNode = Node.<T>builder().data(data).build();
        if (headNode == null) {
            headNode = childNode;
        } else {
            tailNode.setNextNode(childNode);
            childNode.setPrevNode(tailNode);
        }
        tailNode = childNode;

        size++;
    }

    public void delete(T data) {
        Node<T> prevNode = null;
        Node<T> tempNode = headNode;

        while (tempNode != null) {
            if (tempNode.getData() == data) {
                if (prevNode != null) {
                    prevNode.setNextNode(tempNode.getNextNode());

                    if (tempNode.getNextNode() != null) {
                        tempNode.getNextNode().setPrevNode(prevNode);
                    }

                    if (isEmpty()) {
                        headNode = null;
                    }
                } else {
                    headNode = tempNode.getNextNode();
                }
                size--;

                return;
            }

            prevNode = tempNode;
            tempNode = tempNode.getNextNode();
        }

    }

    public boolean contains(T data) {
        Node<T> tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getData() == data) {
                return true;
            }

            tempNode = tempNode.getNextNode();
        }

        return false;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator(headNode);
    }

    private class NodeIterator implements Iterator<T> {
        Node<T> currentNode;

        public NodeIterator(Node<T> rootNode) {
            currentNode = rootNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException("List is empty or end of the list reached");
            }

            T data = currentNode.getData();
            currentNode = currentNode.getNextNode();

            return data;
        }

    }
}