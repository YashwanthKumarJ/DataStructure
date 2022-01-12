package com.yj.datastructures.linkedlist.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoubleReferenceLinkedListTest {

	DoubleReferenceLinkedList<String> list;

	@Before
	public void init() {
		list = new DoubleReferenceLinkedList<>();
	}

	@Test
	public void testAddElements() {
		list.add("first");
		assertEquals(1, list.size());
		list.add("second");
		assertEquals(2, list.size());
	}

	@Test
	public void testElementRemoval() {
		list.add("first");
		assertEquals(1, list.size());
		list.delete("first");
		assertEquals(0, list.size());
	}

	@Test
	public void testElementRemovalAtStart() {
		String[] data = { "first", "second", "third", "fourth" };
		list.add(data[0]);
		list.add(data[1]);
		list.add(data[2]);
		list.add(data[3]);

		Iterator<String> it = list.iterator();
		List<String> expectedList = new ArrayList<>();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, expectedList.size());
		assertArrayEquals(data, expectedList.toArray());

		list.delete(data[0]);

		data = new String[] { "second", "third", "fourth" };
		expectedList = new ArrayList<>();
		it = list.iterator();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());
	}

	@Test
	public void testElementRemovalAtEnd() {
		String[] data = { "first", "second", "third", "fourth" };
		list.add(data[0]);
		list.add(data[1]);
		list.add(data[2]);
		list.add(data[3]);

		Iterator<String> it = list.iterator();
		List<String> expectedList = new ArrayList<>();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());

		list.delete(data[3]);

		data = new String[] { "first", "second", "third" };
		expectedList = new ArrayList<>();
		it = list.iterator();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());
	}

	@Test
	public void testElementRemovalAtMiddle() {
		String[] data = { "first", "second", "third", "fourth" };
		list.add(data[0]);
		list.add(data[1]);
		list.add(data[2]);
		list.add(data[3]);

		Iterator<String> it = list.iterator();
		List<String> expectedList = new ArrayList<>();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());

		list.delete(data[2]);

		data = new String[] { "first", "second", "fourth" };
		expectedList = new ArrayList<>();
		it = list.iterator();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());
	}

	@Test
	public void testElementRemovalInEmptyList() {
		list.delete(null);

		assertEquals(0, list.size());
	}

	@Test
	public void testContainsElement() {
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("four");
		assertEquals(4, list.size());
		assertTrue(list.contains("third"));
		assertFalse(list.contains("Third"));
	}

	@Test
	public void testIterator() {
		String[] data = { "first", "second", "third", "fourth" };
		list.add(data[0]);
		list.add(data[1]);
		list.add(data[2]);
		list.add(data[3]);

		Iterator<String> it = list.iterator();
		List<String> expectedList = new ArrayList<>();
		while (it.hasNext()) {
			expectedList.add(it.next());
		}

		assertEquals(data.length, list.size());
		assertArrayEquals(data, expectedList.toArray());
	}
}
