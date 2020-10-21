package com.home.test;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String a[]) {
        Arrays.stream(AsteroidCollision.asteroidCollision(new int[]{ -2,-2,1,-2})).forEach(x -> System.out.print(x + " "));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty()
                    || (stack.peek() > 0 && i > 0)
                    || stack.peek() < 0) {
                stack.push(i);
            } else {
                // inside i must be less than 0
                // then check in which condition we need to pop based on i must less than 0
                while (!stack.isEmpty()  && stack.peek() > 0 && stack.peek() < -i) {
                    int temp = stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > -i) {
                    continue;
                }
                if (!stack.isEmpty() && stack.peek() == -i) {
                    stack.pop();
                    continue;
                }
                stack.push(i);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
