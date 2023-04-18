package com.github.yashwanth.datastructure.linkedlist.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest
{

    private Tree tree;

    @BeforeEach
    public void setup(){
        tree = new Tree();
    }

    @Test
    public void shouldReturnTrueIfWordExist(){
        tree.add("abc");
        tree.add("mn");
        assertTrue(tree.isWordExist("abc"));
        tree.add("xyz");
        assertTrue(tree.isWordExist("xyz"));
        assertTrue(tree.isWordExist("abc"));
        assertTrue(tree.isWordExist("mn"));
    }

    @Test
    public void shouldReturnFalseIfWordDoesNotExist(){
        tree.add("abc");
        tree.add("mn");
        tree.add("xyz");
        assertFalse(tree.isWordExist("x"));
        assertFalse(tree.isWordExist("a"));
        assertFalse(tree.isWordExist("ab"));
        assertFalse(tree.isWordExist("abcd"));
    }

    @Test
    public void shouldReturnTrueIfPrefixExist(){
        tree.add("abc");
        tree.add("mn");
        assertTrue(tree.isPrefixExist("a"));
        assertTrue(tree.isPrefixExist("ab"));
        assertTrue(tree.isPrefixExist("abc"));
        tree.add("xyz");
        assertTrue(tree.isPrefixExist("x"));
        assertTrue(tree.isPrefixExist("xy"));
        assertTrue(tree.isPrefixExist("xyz"));
        assertTrue(tree.isPrefixExist("m"));
        assertTrue(tree.isPrefixExist("mn"));
    }

    @Test
    public void shouldReturnFalseIfPrefixDoesNotExist(){
        tree.add("abc");
        tree.add("mn");
        tree.add("xyz");
        assertFalse(tree.isPrefixExist("bc"));
        assertFalse(tree.isPrefixExist("nm"));
        assertFalse(tree.isPrefixExist("z"));
        assertFalse(tree.isPrefixExist("amx"));
    }

    @Test
    public void shouldDeleteNodeIfWordExist(){
        tree.add("abc");
        tree.add("mn");
        tree.add("xyz");
        assertTrue(tree.delete("abc"));
        assertFalse(tree.delete("nm"));
        assertFalse(tree.delete("z"));
        assertFalse(tree.delete("amx"));

        assertFalse(tree.isWordExist("abc"));
        assertTrue(tree.isWordExist("mn"));
        assertTrue(tree.isWordExist("xyz"));
    }
}
