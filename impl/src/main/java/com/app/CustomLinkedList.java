package com.app;

public class CustomLinkedList<T> implements CustomLinkedListInterface<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList(){}

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
        return 0;
    }

    /**
     * adds the element in the beginning of the list
     * @param elem element which should be added to the list
     */
    @Override
    public void addFirst(T elem) {

    }

    /**
     * adds the element in the end of the list
     * @param elem element which should be added to the list
     */
    @Override
    public void addLast(T elem) {

    }

    /**
     * adds the element in the list by index
     * @param idx position where element should be added
     * @param elem element which should be added in the list
     */
    @Override
    public void add(int idx, T elem) {

    }

    /**
     * @return first element of the list
     */
    @Override
    public T getFirst() {
        return null;
    }

    /**
     * @return the last element of the list
     */
    @Override
    public T getLast() {
        return null;
    }

    /**
     * returns the element by index
     * @param idx position of the element which should be returned
     * @return element on the corresponded position
     */
    @Override
    public T get(int idx) {
        return null;
    }

    /**
     * retrieve and remove the first element of the list
     * @return first element of the list
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * retrieve and remove the last element of the list
     * @return last element of the list
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     * retrieve and remove the element of the list by index
     * @param idx position of the element which should be returned
     * @return element on corresponded position
     */
    @Override
    public T remove(int idx) {
        return null;
    }
}
