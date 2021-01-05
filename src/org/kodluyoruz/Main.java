package org.kodluyoruz;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {
        SafeStack stack = new SafeStack();

        Runnable insertThread1 = () -> {
            stack.setStack(12);
        }; Runnable insertThread2 = () -> {
            stack.setStack(13);
        };
        Runnable popThread1 = () -> {
            stack.pollStack();
        }; Runnable popThread2 = () -> {
            stack.pollStack();
        };


        try {
            Thread add1 = new Thread(insertThread1);
            add1.setPriority(Thread.MAX_PRIORITY);
            add1.start();
            Thread add2 = new Thread(insertThread2);
            add2.setPriority(Thread.MAX_PRIORITY);
            add2.start();
            new Thread(popThread1).start();
            new Thread(popThread2).start();
        } catch (EmptyStackException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
