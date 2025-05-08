package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(50);
        stack.push(500);
        stack.push(10);

        while (stack.isEmpty() == false) {
            System.out.println("꺼내온 동전 : " + stack.pop() + "원");
        }
    }
}
