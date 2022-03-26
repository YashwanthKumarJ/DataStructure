package com.github.yj.datastructure.linkedlist.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie trie;

    @BeforeEach
    public void setup(){
        trie = new Trie();
    }

    @Test
    public void shouldReturnTrueIfWordExist(){
        trie.add("abc");
        trie.add("mn");
        assertTrue(trie.isWordExist("abc"));
        trie.add("xyz");
        assertTrue(trie.isWordExist("xyz"));
        assertTrue(trie.isWordExist("abc"));
        assertTrue(trie.isWordExist("mn"));
    }

    @Test
    public void shouldReturnFalseIfWordDoesNotExist(){
        trie.add("abc");
        trie.add("mn");
        trie.add("xyz");
        assertFalse(trie.isWordExist("x"));
        assertFalse(trie.isWordExist("a"));
        assertFalse(trie.isWordExist("ab"));
        assertFalse(trie.isWordExist("abcd"));
    }

    @Test
    public void shouldReturnTrueIfPrefixExist(){
        trie.add("abc");
        trie.add("mn");
        assertTrue(trie.isPrefixExist("a"));
        assertTrue(trie.isPrefixExist("ab"));
        assertTrue(trie.isPrefixExist("abc"));
        trie.add("xyz");
        assertTrue(trie.isPrefixExist("x"));
        assertTrue(trie.isPrefixExist("xy"));
        assertTrue(trie.isPrefixExist("xyz"));
        assertTrue(trie.isPrefixExist("m"));
        assertTrue(trie.isPrefixExist("mn"));
    }

    @Test
    public void shouldReturnFalseIfPrefixDoesNotExist(){
        trie.add("abc");
        trie.add("mn");
        trie.add("xyz");
        assertFalse(trie.isPrefixExist("bc"));
        assertFalse(trie.isPrefixExist("nm"));
        assertFalse(trie.isPrefixExist("z"));
        assertFalse(trie.isPrefixExist("amx"));
    }

    @Test
    public void shouldDeleteNodeIfWordExist(){
        trie.add("abc");
        trie.add("mn");
        trie.add("xyz");
        assertTrue(trie.delete("abc"));
        assertFalse(trie.delete("nm"));
        assertFalse(trie.delete("z"));
        assertFalse(trie.delete("amx"));

        assertFalse(trie.isWordExist("abc"));
        assertTrue(trie.isWordExist("mn"));
        assertTrue(trie.isWordExist("xyz"));
    }
}