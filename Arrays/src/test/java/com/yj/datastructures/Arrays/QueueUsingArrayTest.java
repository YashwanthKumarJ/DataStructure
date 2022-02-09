package com.yj.datastructures.Arrays;

import com.yj.datastructures.arrays.QueueUsingArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit testing Queue implementation using array data-structure")
public class QueueUsingArrayTest {

    QueueUsingArray<Integer> queueUsingArray;

    @BeforeEach
    public void setup() {
        queueUsingArray = new QueueUsingArray<>(Integer.class, 3);
    }

    @Test
    void shouldResultInIllegalArgumentExceptionForInvalidQueueSize() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for Queue";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new QueueUsingArray<>(Integer.class, -1));

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void shouldResultInIllegalArgumentExceptionForInvalidType() {
        String exceptionMessage = "Invalid input passed. Expected Class<?> and size for Queue";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new QueueUsingArray<>(null, 5));

        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void shouldTestGeneralQueueOperation() {
        assertTrue(queueUsingArray.isEmpty());
        queueUsingArray.add(1);
        queueUsingArray.add(2);
        assertEquals((Integer) 1, queueUsingArray.element());
        assertEquals((Integer) 1, queueUsingArray.remove());
        assertEquals((Integer) 2, queueUsingArray.element());
        assertEquals((Integer) 2, queueUsingArray.remove());
        assertTrue(queueUsingArray.isEmpty());
        queueUsingArray.add(3);
        assertEquals((Integer) 3, queueUsingArray.element());
        assertEquals((Integer) 3, queueUsingArray.remove());
        assertTrue(queueUsingArray.isEmpty());
    }

    @Test
    void shouldResultInExceptionWhenRemoveCalledOnEmptyQueue() {
        assertTrue(queueUsingArray.isEmpty());
        assertThrows(NoSuchElementException.class, () -> queueUsingArray.remove());
    }

    @Test
    void shouldResultInExceptionWhenElementCallOnEmptyQueue() {
        assertTrue(queueUsingArray.isEmpty());
        assertThrows(NoSuchElementException.class, () -> queueUsingArray.element());
    }

    @Test
    void shouldResultInExceptionWhenElementCallOnFilledEmptyQueue() {
        assertTrue(queueUsingArray.isEmpty());
        queueUsingArray.add(1);
        queueUsingArray.add(2);
        queueUsingArray.remove();
        queueUsingArray.remove();
        assertThrows(NoSuchElementException.class, () -> queueUsingArray.element());
    }

    @Test
    void shouldResultInExceptionWhenQueueIsFull() {
        queueUsingArray.add(1);
        queueUsingArray.add(2);
        queueUsingArray.add(3);
        assertFalse(queueUsingArray.isEmpty());
        assertThrows(IllegalStateException.class, () -> queueUsingArray.add(4));
    }

    @Test
    void shouldReturnElementsInRightOrderAsAddedToQueue() {
        queueUsingArray.add(1);
        queueUsingArray.add(2);
        queueUsingArray.add(3);
        assertEquals((Integer) 1, queueUsingArray.remove());
        assertEquals((Integer) 2, queueUsingArray.remove());
        assertEquals((Integer) 3, queueUsingArray.remove());
    }
}