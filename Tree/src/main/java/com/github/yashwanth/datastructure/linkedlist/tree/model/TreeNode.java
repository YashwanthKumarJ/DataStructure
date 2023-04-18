package com.github.yashwanth.datastructure.linkedlist.tree.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class TreeNode
{

    private final Map<Character, TreeNode> chRefMap = new HashMap<>();

    @Getter
    @Setter
    private boolean isEndNode = true;

    public TreeNode getNode(Character ch) {
        return chRefMap.get(ch);
    }

    public void addNode (Character ch) {
        if (chRefMap.containsKey(ch)) {
            throw new IllegalArgumentException("The value is already exist.");
        }

        chRefMap.put(ch, new TreeNode());
    }

    public void remove(Character ch) {
        chRefMap.remove(ch);
        isEndNode = chRefMap.isEmpty();
    }
}
