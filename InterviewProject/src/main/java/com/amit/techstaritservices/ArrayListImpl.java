package com.amit.techstaritservices;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayListImpl<T> {
    private final int DEFAULT_SIZE = 10;
    private final double DEFAULT_SHARE_RATIO = 0.75;
    private int capacity;
    private double shareRatio;
    private int size;
    private T[] list;

    public ArrayListImpl() {
        list = (T[])new Objects[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
        shareRatio = DEFAULT_SHARE_RATIO;
    }

    public ArrayListImpl(int capacity, double shareRatio) {
        this.capacity = capacity;
        this.shareRatio = shareRatio;
        list = (T[])new Objects[capacity];
    }

    public ArrayListImpl(int capacity) {
        this.capacity = capacity;
        this.shareRatio = DEFAULT_SHARE_RATIO;
        list = (T[])new Object[capacity];
    }

    public void add(T elem) {
        if(size < capacity*shareRatio) {
            list[size++] = elem;
        } else {
            // double list size,copy existing elements and add new element
            resizeAndCopy(list);
            list[size++] = elem;
        }

    }

    private void resizeAndCopy(T[] oldList) {
        capacity = capacity*2;
        list = (T[])new Object[capacity];
        for(int i=0; i<size; i++) {
            list[i] = oldList[i];
        }
    }

    public T get(int index) {
        return list[index];
    }

    public T remove(int index) {
        T value = list[index];
        for(int i=index; i<size; i++) {
            list[i] = list[i+1];
        }
        return value;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(double shareRatio) {
        this.shareRatio = shareRatio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return Arrays.asList(list).stream().filter(e-> e!=null).map(T:: toString).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        ArrayListImpl<Integer> al = new ArrayListImpl<Integer>(4);
        al.add(2);
        al.add(3);
        System.out.println(al.capacity);
        System.out.println(al.size);
        System.out.println(al);
        al.add(4);
        al.add(5);
        System.out.println(al.capacity);
        System.out.println(al.size);
        System.out.println(al);
        al.remove(2);
        System.out.println(al.capacity);
        System.out.println(al.size);
        System.out.println(al);

    }
}
