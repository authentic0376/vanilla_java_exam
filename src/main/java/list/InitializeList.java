package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InitializeList {
    public static void main(String[] args) {
        // ===========================
        // Literal Initialization
        // ===========================

        // ---- Arrays.asList ----
        /*
         * Creates a fixed-size list and initializes elements.
         * - Cannot change the size (no addition or removal of elements).
         * - Modifying elements is allowed.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // Initialize list
        System.out.println("numbers = " + numbers);

        // Modifying elements is allowed
        numbers.set(0, 2);
        System.out.println("numbers = " + numbers);

        // Adding/removing elements is not allowed
        // numbers.add(3); Runtime error

        /*
         * The array and the list are linked.
         * Modifying the array will also affect the list.
         */
        String[] arr = {"A", "B", "C"};
        List<String> alphabet = Arrays.asList(arr);
        System.out.println("alphabet = " + alphabet);
        arr[1] = "bb";
        System.out.println("alphabet = " + alphabet);

        // ---- List.of ----
        /*
         * Creates an immutable list.
         * - Read-only list: Cannot add, remove, or modify elements.
         */
        List<String> fruits = List.of("Apple", "Banana", "Cherry");
        // fruits.add("Orange"); Compile warning, runtime error
        // fruits.set(0, "Orange"); Compile warning, runtime error

        // ===========================
        // Dynamic Initialization
        // ===========================

        // ---- Collections.addAll ----
        List<String> fruits2 = new ArrayList<>();
        Collections.addAll(fruits2, "Apple", "Banana", "Cherry");

        // ---- for Loop ----
        List<Integer> numbers2 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers2.add(i);
        }

        // ---- Stream ----
        List<Integer> numbers3 = IntStream.rangeClosed(1, 5)
                .boxed()
                .toList();

        // ---- Double Brace Initialization ----
        /*
         * Uses an anonymous class to initialize the list.
         * - Improves readability but rarely used due to extra memory usage and warnings
         *
         * Implements an anonymous class without overriding methods,
         * and implements an initialization block only.
         * The block executes after the superclass's initializer block and constructor.
         */
        List<String> fruits3 = new ArrayList<>() {
            {
                add("Apple");
                add("Banana");
                add("Cherry");
            }
        };
    }
}
