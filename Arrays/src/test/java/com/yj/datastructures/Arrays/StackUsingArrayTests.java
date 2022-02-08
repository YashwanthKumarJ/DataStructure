package com.yj.datastructures.Arrays;

import com.yj.datastructures.arrays.StackUsingArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class StackUsingArrayTests {

    private StackUsingArray<Integer> stackUsingArray;

    @Before
    public void init() {
        stackUsingArray = new StackUsingArray<>(Integer.class, 3);
    }

    @Test
    public void shouldResultInIllegalArgumentExceptionForInvalidStackSize() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for stack";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new StackUsingArray<>(Integer.class, -1));

        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldResultInIllegalArgumentExceptionForInvalidType() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for stack";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new StackUsingArray<>(null, 5));

        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldTestGeneralStackOperation() throws Exception {
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
    public void shouldResultInExceptionWhenPoppedFromEmptyStack() {
        assertTrue(stackUsingArray.isEmpty());
        assertThrows(EmptyStackException.class, () -> stackUsingArray.pop());
    }

    @Test
    public void shouldResultInExceptionWhenPeekedCalledOnEmptyStack() {
        assertTrue(stackUsingArray.isEmpty());
        assertThrows(EmptyStackException.class, () -> stackUsingArray.peek());
    }

    @Test
    public void shouldResultInExceptionWhenStackIsFull() throws Exception {
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        assertFalse(stackUsingArray.isEmpty());
        assertThrows(Exception.class, () -> stackUsingArray.push(4));
    }

    @Test
    public void shouldReturnElementsInRightOrderAsPushedToStack() throws Exception {
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        assertEquals((Integer) 3, stackUsingArray.pop());
        assertEquals((Integer) 2, stackUsingArray.pop());
        assertEquals((Integer) 1, stackUsingArray.pop());
    }
}
