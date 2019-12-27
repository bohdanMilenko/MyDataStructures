package com.myDataStructures;

import java.awt.font.TextHitInfo;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArrayListImp  implements Cloneable, Serializable, RandomAccess {

    public static final int INITIAL_SIZE = 10;
    private Object[] dataHolder;
    private int size;
    private int countModified;

    public MyArrayListImp(){
        this(INITIAL_SIZE);
    }

    public MyArrayListImp(int arraySize){
        super();
        if(arraySize<0){
            throw new IllegalArgumentException("Negative capacity of the array " + arraySize);
        }
        this.size = arraySize;
        this.dataHolder = new Object[arraySize];
    }

    private void validateSize(int minCapacity){
        ++countModified;
        if(dataHolder.length < minCapacity && minCapacity > INITIAL_SIZE){
            increaseCapacity(minCapacity);
        }
    }

    private void increaseCapacity(int newCapacity){
        this.dataHolder = Arrays.copyOf(this.dataHolder, newCapacity);
    }


    public boolean add(Object newObject){
        ++countModified;
        validateSize(size + 1);
        dataHolder[size + 1] = newObject;
        this.size++;
        return true;
    }

    public Object remove(int indexToRemove){
        ++countModified;
        if(indexToRemove>= size){
            throw new IndexOutOfBoundsException("Array does not contain enough elements to remove: " + indexToRemove );
        }
        dataHolder[indexToRemove] = null;
        return true;
    }



}
