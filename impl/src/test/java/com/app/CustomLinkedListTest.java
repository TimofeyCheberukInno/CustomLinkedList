package com.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> lst;

    @BeforeEach
    void setUp(){
        lst = new CustomLinkedList<>();
        lst.addFirst(30);
        lst.addFirst(20);
    }

    @DisplayName("size() method successful test with initial list")
    @Test
    void testSize(){
        assertEquals(2, lst.size());
    }

    @DisplayName("getFirst() method successful test")
    @Test
    void testGetFirst(){
        lst.addFirst(20);
        lst.addFirst(10);
        assertEquals(10, lst.getFirst());
    }

    @DisplayName("getLast() method successful test")
    @Test
    void testGetLast(){
        lst.addFirst(20);
        lst.addFirst(10);
        assertEquals(20, lst.getLast());
    }

    @DisplayName("get(idx) method successful test")
    @Test
    void testGet(){
        assertEquals(10, lst.get(0));
        assertEquals(20, lst.get(1));
    }

    @DisplayName("addFirst(el) method successful size-checking test")
    @Test
    void testAddFirst(){
        lst.addFirst(10);
        lst.addFirst(0);
        assertEquals(4, lst.size());
    }

    @DisplayName("addLast(el) method successful size-checking test")
    @Test
    void testAddLast(){
        lst.addLast(40);
        lst.addLast(50);
        assertEquals(4, lst.size());
    }

    @DisplayName("addLast(el) method successful size-checking test")
    @Test
    void testAdd(){
        lst.add(0, 10);
        lst.add(3, 40);
        assertEquals(4, lst.size());
    }

    @DisplayName("addFirst(el) method successful order-checking test")
    @Test
    void testAddFirstAndGet(){
        lst.addFirst(10);
        lst.addFirst(0);
        assertEquals(0, lst.get(0));
        assertEquals(10, lst.get(1));
        assertEquals(20, lst.get(2));
        assertEquals(30, lst.get(3));
    }

    @DisplayName("addLast(el) method successful order-checking test")
    @Test
    void testAddLastAndGet(){
        lst.addLast(40);
        lst.addLast(50);
        assertEquals(20, lst.get(0));
        assertEquals(30, lst.get(1));
        assertEquals(40, lst.get(2));
        assertEquals(50, lst.get(3));
    }

    @DisplayName("addLast(el) method successful order-checking test")
    @Test
    void testAddAndGet(){
        lst.add(1, 21);
        lst.add(2, 29);
        assertEquals(20, lst.get(0));
        assertEquals(21, lst.get(1));
        assertEquals(29, lst.get(2));
        assertEquals(30, lst.get(3));
    }

    @DisplayName("removeFirst() method successful size-checking test")
    @Test
    void testRemoveFirst(){
        lst.removeFirst();
        assertEquals(1, lst.size());
        lst.removeFirst();
        assertEquals(0, lst.size());
    }

    @DisplayName("removeLast() method successful size-checking test")
    @Test
    void testRemoveLast(){
        lst.removeLast();
        assertEquals(1, lst.size());
        lst.removeLast();
        assertEquals(0, lst.size());
    }

    @DisplayName("remove(idx) method successful size-checking test")
    @Test
    void testRemove(){
        lst.remove(1);
        assertEquals(1, lst.size());
        lst.remove(1);
        assertEquals(0, lst.size());
    }

    @DisplayName("removeFirst() method successful order-checking test")
    @Test
    void testRemoveFirstAndGet(){
        lst.removeFirst();
        assertEquals(30, lst.get(0));
    }

    @DisplayName("removeLast() method successful order-checking test")
    @Test
    void testRemoveLastAndGet(){
        lst.removeLast();
        assertEquals(20, lst.get(0));
    }

    @DisplayName("remove(idx) method successful order-checking test")
    @Test
    void testRemoveAndGet1(){
        lst.remove(1);
        assertEquals(20, lst.get(0));
    }

    @DisplayName("remove(idx) method successful order-checking test")
    @Test
    void testRemoveAndGet2(){
        lst.remove(0);
        assertEquals(30, lst.get(0));
    }
}
