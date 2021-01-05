package org.kodluyoruz;

import java.util.Stack;

public class SafeStack<T> {
    static Stack stack;

    public SafeStack() {
        stack = new Stack<T>();
    }
    synchronized T pollStack(){
        System.out.println("Bakılan değer: "+stack.peek().toString());
        return (T) stack.pop();

    }
    synchronized void setStack(T value)
    {
        System.out.println("Eklenen değer: "+value.toString());
        stack.push(value);
    }
}
