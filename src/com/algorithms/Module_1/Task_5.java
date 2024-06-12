package com.algorithms.Module_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// Two stacks decision. 

// https://stepik.org/lesson/41234/step/5?unit=19818
// http://e-maxx.ru/algo/stacks_for_minima
// https://www.youtube.com/watch?v=2lumODP7BtI

class Task_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Pair<Integer, Integer>> inputStack = new Stack();
        Stack<Pair<Integer, Integer>> outputStack = new Stack();

        // Reading of the input data.
        Integer.parseInt(reader.readLine());
        int[] stackArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int windowSize = Integer.parseInt(reader.readLine());


        Arrays.stream(stackArray).forEach(element -> {

            addNewElement(inputStack, element);

            if (inputStack.size() == windowSize)
                swapStacks(inputStack, outputStack);

            if (inputStack.size() + outputStack.size() == windowSize) {
                System.out.println(getMax(inputStack, outputStack));
                outputStack.pop();
            }

        });
    }

    private static void swapStacks(Stack<Pair<Integer, Integer>> inputStack, Stack<Pair<Integer, Integer>> outputStack) {
        outputStack.push(new Pair(inputStack.peek().getFirst(), inputStack.pop().getFirst()));

        while (!inputStack.isEmpty())
            outputStack.push(new Pair(inputStack.peek().getFirst(), Math.max(inputStack.pop().getFirst(), outputStack.peek().getSecond())));

    }

    private static int getMax(Stack<Pair<Integer, Integer>> inputStack, Stack<Pair<Integer, Integer>> outputStack) {
        if (inputStack.isEmpty())
            return outputStack.peek().getSecond();
        if (outputStack.isEmpty())
            return inputStack.peek().getSecond();
        return Math.max(outputStack.peek().getSecond(), inputStack.peek().getSecond());
    }

    private static void addNewElement(Stack<Pair<Integer, Integer>> inputStack, Integer element) {
        if (inputStack.isEmpty())
            inputStack.push(new Pair(element, element));
        else
            inputStack.push(new Pair(element, Math.max(inputStack.peek().getSecond(), element)));
    }

    private static class Pair<V1, V2> {
        private final V1 first;
        private final V2 second;

        Pair(V1 first, V2 second) {
            this.first = first;
            this.second = second;
        }

        public V1 getFirst() {
            return first;
        }

        public V2 getSecond() {
            return second;
        }
    }
}