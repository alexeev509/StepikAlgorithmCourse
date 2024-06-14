package com.algorithms.Module_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//https://stepik.org/lesson/41234/step/4?unit=19818
class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int index = 0;
        int[] stack = new int[1_000_000];
        int[] max = new int[1_000_000];
        while (count != 0) {
            String[] current = reader.readLine().split(" ");
            switch (current[0]) {
                case "push" -> {
                    stack[index] = Integer.parseInt(current[1]);
                    if (index == 0)
                        max[index] = stack[index];
                    else
                        max[index] = Math.max(max[index - 1], stack[index]);
                    ++index;
                }
                case "pop" -> {
                    --index;
                }
                case "max" -> {
                    System.out.println(max[index - 1]);
                }
            }
            --count;
        }
    }
}