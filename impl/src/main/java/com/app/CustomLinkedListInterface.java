package com.app;

public interface CustomLinkedListInterface<T> {
    int size();
    void addFirst(T elem);
    void addLast(T elem);
    void add(int idx, T elem);
    T getFirst();
    T getLast();
    T get(int idx);
    T removeFirst();
    T removeLast();
    T remove(int idx);
}
