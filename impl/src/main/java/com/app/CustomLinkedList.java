package com.app;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements CustomLinkedListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * class which represents a nodes of list
     * @param <T> type of elements in list
     */
    private static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    /**
     *
     * @return returns the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * adds the element in the beginning of the list
     * @param elem element which should be added to the list
     * @throws IllegalArgumentException if elem is null
     */
    @Override
    public void addFirst(T elem) {
        validateValue(elem);
        Node<T> newNode = new Node<>(elem);
        newNode.next = head;

        if(head == null){
            tail = newNode;
        }
        head = newNode;

        size++;
    }

    /**
     * adds the element in the end of the list
     * @param elem element which should be added to the list
     * @throws IllegalArgumentException if elem is null
     */
    @Override
    public void addLast(T elem) {
        validateValue(elem);
        Node<T> newNode = new Node<>(elem);

        if(tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    /**
     * adds the element in the list by index
     * @param idx position where element should be added
     * @param elem element which should be added in the list
     * @throws IllegalArgumentException if elem is null or idx is null or idx is negative
     */
    @Override
    public void add(int idx, T elem) {
        validateValue(elem);
        validateIndexToAdd(idx);
        Node<T> newNode = new Node<>(elem);
        Node<T> node = head;
        int i = 0;
        while(i + 1 < idx){
            node = node.next;
            i++;
        }

        newNode.next = node.next;
        node.next = newNode;

        size++;
    }

    /**
     * @return first element of the list
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T getFirst() {
        return this.get(0);
    }

    /**
     * @return the last element of the list
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T getLast() {
        return this.get(Math.max(size - 1, 0));
    }

    /**
     * returns the element by index
     * @param idx position of the element which should be returned
     * @return element on the corresponded position
     * @throws IllegalArgumentException if idx is negative
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T get(int idx) {
        validateIndexToGet(idx);

        Node<T> node = head;
        int i = 0;
        while(i < idx){
            node = node.next;
            i++;
        }

        return node.value;
    }

    /**
     * retrieve and remove the first element of the list
     * @return first element of the list
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T removeFirst() {
        return this.remove(0);
    }

    /**
     * retrieve and remove the last element of the list
     * @return last element of the list
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T removeLast() {
        return this.remove(Math.max(size - 1, 0));
    }

    /**
     * retrieve and remove the element of the list by index
     * @param idx position of the element which should be returned
     * @return element on corresponded position
     * @throws IllegalArgumentException if idx is negative
     * @throws NoSuchElementException if there is no element on idx position in the list
     */
    @Override
    public T remove(int idx) {
        validateIndexToGet(idx);

        Node<T> node = head;
        Node<T> prev = null;
        int i = 0;
        while(i < idx){
            prev = node;
            node = node.next;
            i++;
        }

        if(idx == 0){
            head = node.next;
            if(size == 1) tail = null;
        }
        else if(idx == size - 1){
            tail = prev;
            prev.next = null;
        }

        size--;
        return node.value;
    }

    private void validateValue(T value){
        Objects.requireNonNull(value, "Argument should not be null");
    }

    private void validateIndexToAdd(int idx){
        if(idx < 0 || idx >= size){
            throw new IllegalArgumentException("Index of added value should be positive and less than size of the list");
        }
    }

    private void validateIndexToGet(int idx){
        if(idx < 0){
            throw new IllegalArgumentException("Index of added value should be positive and less than size of the list");
        }
        else if(idx >= size){
            throw new NoSuchElementException("No element on corresponded position");
        }
    }
}
