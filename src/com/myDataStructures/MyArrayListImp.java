package com.myDataStructures;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArrayListImp<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {

    public static final Object[] INITIAL_OBJECT = new Object[0];
    private Object[] dataHolder;
    private int size;
    private int countModified;

    public MyArrayListImp() {
        dataHolder = INITIAL_OBJECT;
    }

    public MyArrayListImp(int arraySize) {
        super();
        if (arraySize < 0) {
            throw new IllegalArgumentException("Negative capacity of the array " + arraySize);
        }
        this.size = arraySize;
        this.dataHolder = new Object[arraySize];
    }

    private void validateSize(int requiredCapacity) {
        ++countModified;
        if (this.dataHolder.length < requiredCapacity) {
            increaseCapacity(requiredCapacity);
        }
    }

    private void increaseCapacity(int newCapacity) {
        this.dataHolder = Arrays.copyOf(this.dataHolder, newCapacity);
    }


    public boolean add(Object newObject) {
        ++countModified;
        validateSize(this.size + 1);
        dataHolder[this.size] = newObject;
        this.size++;
        return true;
    }

    public E remove(int indexToRemove) {
        ++countModified;
        if (indexToRemove >= size) {
            throw new IndexOutOfBoundsException("Array does not contain enough elements to remove: " + indexToRemove);
        }
        E deletedObject;
        deletedObject = (E) this.dataHolder[indexToRemove];
        quickRemove(indexToRemove);
        return deletedObject;
    }

    private void quickRemove(int indexToRemove) {
        int newSize;
        if((newSize = this.size - 1) > indexToRemove){
            System.arraycopy(this.dataHolder, indexToRemove + 1, this.dataHolder, indexToRemove, newSize - indexToRemove);
        }
        this.dataHolder[this.size = newSize] = null;
    }


    public E get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("Not a valid index to retrieve " + index);
        }
        return (E) dataHolder[index];
    }

    @Override
    public int size() {
        return this.size;
    }
}
