package com.github.yashwanth.datastructure.linkedlist.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Node<T> {

    private Node<T> prevNode;

    private Node<T> nextNode;

    private T data;

}
