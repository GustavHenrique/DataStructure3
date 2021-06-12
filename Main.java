package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static Object[] pile;
    private static int top;

    public static void Pile() {

        pile = new Object[5];
        top = -1;

    }

    public void emptyPile() {

        top = -1;

    }

    public int lengthPile() {

        return (top+1);

    }

    public static boolean push(Object x) {

        top++;

        if( top == pile.length) {

            System.out.println("The pile is full, empty it first.");
            return false;

        }

        pile[top] = x;

        return true;

    }

    public Object top() {

        if(top >= 0){

            return(pile[top]);

        }
        else {

            return null;

        }

    }

    public static Object pop() {

        if( top >= 0) {

            System.out.println("Removing top pile element: " + pile[top]);

            pile[top] = null;
            top--;

            if(top == -1) {

                System.out.println("The pile has been empty.");
                return null;

            }

            return pile[top];

        }
        else {

            System.out.println("The pile is empty.");
            return null;

        }

    }

    private static Object[] queue;
    private static int lengthQueue;
    private static int idxOut;
    private static int idxIn;

    public static void Queue() {

        queue = new Object[10];
        empty();

    }

    public int lengthQueue() {

        return lengthQueue;

    }

    public static void empty() {

        lengthQueue = 0;
        idxOut = 0;
        idxIn = queue.length-1;

    }

    private static int increment(int idx) {

        idx++;
        if(idx == queue.length) {

            idx = 0;

        }

        return idx;

    }

    public static boolean enqueue(Object x) {

        if(lengthQueue == queue.length) {

            System.out.println("The queue is full, empty it first.");
            return false;

        }

        idxIn = increment(idxIn);
        queue[idxIn] = x;
        lengthQueue++;

        return true;

    }

    public Object dequeue() {

        if(lengthQueue == 0) {

            return null;

        }

        lengthQueue--;
        Object x = queue[idxOut];
        idxOut = increment(idxOut);
        return x;

    }

    public static void main(String[] args) {

        System.out.println("Step 1:");
        ArrayList<Integer> list = new ArrayList<Integer>(5);

        for(int i = 0; i < 5; i++) {

            list.add(0, i+1);

        }

        System.out.println(list);

        System.out.println("Step 2:");

        Pile();

        for (int j : list) {

            push(j);
            System.out.println(Arrays.toString(pile));

        }

        list.clear();

        System.out.println("Step 3:");
        Queue();

        int k = 0;
        while(top >= 0 && k < 10) {

            enqueue(pile[top]);
            pop();

            System.out.println("Queue [" + k + "]: " + queue[k]);

            k++;
        }

        System.out.println(Arrays.toString(pile));
        System.out.println(Arrays.toString(queue));

        System.out.println("Step 4:");
        for(int i = 0; i < 5; i++) {

            list.add(0, i+6);

        }

        System.out.println(list);

        System.out.println("Step 5:");

        for (int j : list) {

            push(j);
            System.out.println(Arrays.toString(pile));

        }

        list.clear();

        while(top >= 0 && k < 10) {

            enqueue(pile[top]);
            pop();

            System.out.println("Queue [" + k + "]: " + queue[k]);

            k++;
        }

        System.out.println("Step 6:");
        System.out.println(Arrays.toString(queue));


    }

}
