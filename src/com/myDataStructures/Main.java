package com.myDataStructures;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MyArrayListImp<String> myArray = new MyArrayListImp<>();
        myArray.add("Hello");
        myArray.add("MyArray");
        myArray.add("Implementation");

        for(int i = 0; i < myArray.size(); i++){
            System.out.println(myArray.get(i));
        }

        myArray.remove(1);

        for(int i = 0; i < myArray.size(); i++){
            System.out.println(myArray.get(i));
        }
    }
}
