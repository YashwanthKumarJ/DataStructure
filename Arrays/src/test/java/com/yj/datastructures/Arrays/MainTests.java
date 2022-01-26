package com.yj.datastructures.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yj.datastructures.arrays.Main;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    Main main;

    @Before
    public void init() {
        main = new Main();
    }

    @Test
    public void testFixedArrayCreation() {
        Integer[] resultArr = main.createArray(Integer.class, 5);

        assertNotNull(resultArr);
        assertEquals(resultArr.length, 5);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testNegativeSizeThrowsException() {
        main.createArray(Integer.class, -1);
    }

    @Test(expected = OutOfMemoryError.class)
    public void testOOMForIntegerMax() {
        main.createArray(Integer.class, Integer.MAX_VALUE);
    }

    @Test
    public void testAddElementInIndexRange() {
        Integer[] testArr = { null, null, null, 1234, null };
        Integer[] resultArr = main.createArray(Integer.class, 5);
        main.addElement(resultArr, 3, 1234);

        assertArrayEquals(resultArr, testArr);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddElementInOutOfIndexRange() {
        Integer[] resultArr = main.createArray(Integer.class, 5);
        main.addElement(resultArr, 30, 1234);
    }
}
