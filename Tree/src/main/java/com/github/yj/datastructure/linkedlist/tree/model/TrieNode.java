package com.github.yj.datastructure.linkedlist.tree.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Map<Character, TrieNode> chRefMap = new HashMap<>();

    @Getter
    @Setter
    private boolean isEndNode = true;

    public TrieNode getNode(Character ch) {
        return chRefMap.get(ch);
    }

    public void addNode (Character ch) {
        if (chRefMap.containsKey(ch)) {
            throw new IllegalArgumentException("The value is already exist.");
        }

        chRefMap.put(ch, new TrieNode());
    }

    public void remove(Character ch) {
        chRefMap.remove(ch);
        isEndNode = chRefMap.isEmpty();
    }
}
