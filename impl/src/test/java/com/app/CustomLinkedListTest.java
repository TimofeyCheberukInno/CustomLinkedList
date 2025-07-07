package com.app;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> lst;

    @BeforeEach
    void setUp(TestInfo testInfo){
        if(testInfo.getTestMethod().orElseThrow().getName().equals("testGetFirstWithInvalidIndexException")
            || testInfo.getTestMethod().orElseThrow().getName().equals("testGetLastWithInvalidIndexException")
            || testInfo.getTestMethod().orElseThrow().getName().equals("testRemoveFirstWithInvalidIndexException")
            || testInfo.getTestMethod().orElseThrow().getName().equals("testRemoveLastWithInvalidIndexException")
        ){
            lst = new CustomLinkedList<>();
        }
        else {
            lst = new CustomLinkedList<>();
            lst.addFirst(30);
            lst.addFirst(20);
        }
    }

    @DisplayName("size() method successful test with initial list")
    @Test
    void testSize(){
        assertEquals(2, lst.size());
    }

    @DisplayName("getFirst() method successful test")
    @Test
    void testGetFirst(){
        assertEquals(20, lst.getFirst());
    }

    @DisplayName("getFirst() method throws Exception due to invalid index argument")
    @Test
    void testGetFirstWithInvalidIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.getFirst()
        );

        assertEquals("No element on corresponded position", ex.getMessage());
    }

    @DisplayName("getLast() method successful test")
    @Test
    void testGetLast(){
        assertEquals(30, lst.getLast());
    }

    @DisplayName("getLast() method throws Exception due to invalid index argument")
    @Test
    void testGetLastWithInvalidIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.getLast()
        );

        assertEquals("No element on corresponded position", ex.getMessage());
    }

    @DisplayName("get(idx) method successful test")
    @Test
    void testGet(){
        assertEquals(20, lst.get(0));
        assertEquals(30, lst.get(1));
    }

    @DisplayName("get(idx) method throws Exception due to negative argument")
    @Test
    void testGetWithInvalidIndexException(){
        IllegalArgumentException ex = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> lst.get(-1)
        );

        assertEquals("Index of added value should be positive and less than size of the list", ex.getMessage());
    }

    @DisplayName("get(idx) method throws Exception due to invalid index argument")
    @Test
    void testGetWithOutOfBoundIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.get(5)
        );

        assertEquals("No element on corresponded position", ex.getMessage());
    }

    @DisplayName("addFirst(el) method successful size-checking test")
    @Test
    void testAddFirst(){
        lst.addFirst(10);
        lst.addFirst(0);
        assertEquals(4, lst.size());
    }

    @DisplayName("addFirst(el) method throws Exception due to null argument")
    @Test
    void testAddFirstWithException(){
        NullPointerException ex = assertThrowsExactly(
                NullPointerException.class,
                () -> lst.addFirst(null)
        );

        assertEquals("Argument should not be null", ex.getMessage());
    }

    @DisplayName("addLast(el) method successful size-checking test")
    @Test
    void testAddLast(){
        lst.addLast(40);
        lst.addLast(50);
        assertEquals(4, lst.size());
    }

    @DisplayName("addLast(el) method throws Exception due to null argument")
    @Test
    void testAddLastWithException(){
        NullPointerException ex = assertThrowsExactly(
                NullPointerException.class,
                () -> lst.addLast(null)
        );

        assertEquals("Argument should not be null", ex.getMessage());
    }

    @DisplayName("add(el) method successful size-checking test")
    @Test
    void testAdd(){
        lst.add(0, 10);
        lst.add(2, 40);
        assertEquals(4, lst.size());
    }

    @DisplayName("add(el) method throws Exception due to null elem argument")
    @Test
    void testAddWithElementException(){
        NullPointerException ex = assertThrowsExactly(
                NullPointerException.class,
                () -> lst.add(0, null)
        );

        assertEquals("Argument should not be null", ex.getMessage());
    }

    @DisplayName("add(el) method throws Exception due to invalid index argument")
    @Test
    void testAddWithIndexException(){
        IllegalArgumentException ex = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> lst.add(-1, 50)
        );

        assertEquals("Index of added value should be positive and less than size of the list", ex.getMessage());
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

    @DisplayName("add(el) method successful order-checking test")
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

    @DisplayName("removeFirst() method throws Exception due to invalid index argument")
    @Test
    void testRemoveFirstWithInvalidIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.removeFirst()
        );

        assertEquals("No element on corresponded position", ex.getMessage());
    }


    @DisplayName("removeLast() method successful size-checking test")
    @Test
    void testRemoveLast(){
        lst.removeLast();
        assertEquals(1, lst.size());
        lst.removeLast();
        assertEquals(0, lst.size());
    }

    @DisplayName("removeLast() method throws Exception due to invalid index argument")
    @Test
    void testRemoveLastWithInvalidIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.removeLast()
        );

        assertEquals("No element on corresponded position", ex.getMessage());
    }

    @DisplayName("remove(idx) method successful size-checking test")
    @Test
    void testRemove(){
        lst.remove(1);
        assertEquals(1, lst.size());
        lst.remove(0);
        assertEquals(0, lst.size());
    }

    @DisplayName("remove(idx) method throws Exception due to negative index argument")
    @Test
    void testRemoveWithNegativeIndexException(){
        IllegalArgumentException ex = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> lst.remove(-1)
        );

        assertEquals("Index of added value should be positive and less than size of the list", ex.getMessage());
    }

    @DisplayName("remove(idx) method throws Exception due to invalid index argument")
    @Test
    void testRemoveWithInvalidIndexException(){
        NoSuchElementException ex = assertThrowsExactly(
                NoSuchElementException.class,
                () -> lst.remove(10)
        );

        assertEquals("No element on corresponded position", ex.getMessage());
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
