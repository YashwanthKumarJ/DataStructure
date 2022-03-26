package com.github.yj.datastructure.linkedlist.tree;

import com.github.yj.datastructure.linkedlist.tree.model.TrieNode;

public class Trie {
    private final TrieNode root = new TrieNode();

    public boolean add(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException("Input value cannot be null");
        }

        int i = 0;
        TrieNode node = root;

        while (i < inputStr.length()) {
            if (node.getNode(inputStr.charAt(i)) == null) {
                node.setEndNode(false);
                node.addNode(inputStr.charAt(i));
            }

            node = node.getNode(inputStr.charAt(i));
            i++;
        }

        return true;
    }

    public boolean delete(String inputStr) {
        return delete(inputStr, root);
    }

    private boolean delete(String inputStr, TrieNode node) {
        if (inputStr.isEmpty()) {
            return node != null && node.isEndNode();
        }

        if (node.getNode(inputStr.charAt(0)) != null) {
            boolean result = delete(inputStr.substring(1), node.getNode(inputStr.charAt(0)));
            if (result) {
                node.remove(inputStr.charAt(0));
                return true;
            }
        }

        return false;
    }

    public boolean isWordExist(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException("Input value cannot be null");
        }

        int i = 0;
        TrieNode node = root;

        while (i < inputStr.length()) {
            node = node.getNode(inputStr.charAt(i));
            if (node == null) {
                return false;
            }

            i++;
        }

        return i == inputStr.length() && node.isEndNode();
    }

    public boolean isPrefixExist(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException("Input value cannot be null");
        }

        int i = 0;
        TrieNode node = root;

        while (i < inputStr.length()) {
            node = node.getNode(inputStr.charAt(i));
            if (node == null) {
                return false;
            }

            i++;
        }

        return true;
    }
}
