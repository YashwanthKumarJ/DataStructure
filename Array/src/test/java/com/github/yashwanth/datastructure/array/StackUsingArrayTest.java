package com.github.yashwanth.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit testing implementation of Stack using array data-structure")
class StackUsingArrayTest {

    StackUsingArray<Integer> stackUsingArray;

    @BeforeEach
    void setup() {
        stackUsingArray = new StackUsingArray<>(Integer.class, 3);
    }

    @Test
    void shouldResultInIllegalArgumentExceptionForInvalidStackSize() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for stack";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new StackUsingArray<>(Integer.class, -1));

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void shouldResultInIllegalArgumentExceptionForInvalidType() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for stack";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new StackUsingArray<>(null, 5));

        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void shouldTestGeneralStackOperation() throws Exception {
        assertTrue(stackUsingArray.isEmpty());
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        assertEquals((Integer) 2, stackUsingArray.peek());
        assertEquals((Integer) 2, stackUsingArray.pop());
        assertEquals((Integer) 1, stackUsingArray.peek());
        assertEquals((Integer) 1, stackUsingArray.pop());
        assertTrue(stackUsingArray.isEmpty());
        stackUsingArray.push(3);
        assertEquals((Integer) 3, stackUsingArray.peek());
        assertEquals((Integer) 3, stackUsingArray.pop());
        assertTrue(stackUsingArray.isEmpty());
    }

    @Test
    void shouldResultInExceptionWhenPoppedFromEmptyStack() {
        assertTrue(stackUsingArray.isEmpty());
        assertThrows(EmptyStackException.class, () -> stackUsingArray.pop());
    }

    @Test
    void shouldResultInExceptionWhenPeekedCalledOnEmptyStack() {
        assertTrue(stackUsingArray.isEmpty());
        assertThrows(EmptyStackException.class, () -> stackUsingArray.peek());
    }

    @Test
    void shouldResultInExceptionWhenStackIsFull() throws Exception {
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        assertFalse(stackUsingArray.isEmpty());
        assertThrows(Exception.class, () -> stackUsingArray.push(4));
    }

    @Test
    void shouldReturnElementsInRightOrderAsPushedToStack() throws Exception {
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        assertEquals((Integer) 3, stackUsingArray.pop());
        assertEquals((Integer) 2, stackUsingArray.pop());
        assertEquals((Integer) 1, stackUsingArray.pop());
    }
}
