package datastructurescomparison;

import java.util.*;

public class DataStructuresSearchComparison {

    public static boolean linearSearch(int[] array, int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    public static double[] comparison(int size) {
        double[] output = new double[3];

        int key = size - 1;
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }


        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, key);
        long endTime = System.nanoTime();
        long arrayTime = endTime - startTime;


        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(key);
        endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;


        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(key);
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;

        output[0] = arrayTime / 1000000.0;
        output[1] = hashSetTime / 1000000.0;
        output[2] = treeSetTime / 1000000.0;

        System.out.println("Array Search Time: " + output[0] + " ms");
        System.out.println("HashSet Search Time: " + output[1] + " ms");
        System.out.println("TreeSet Search Time: " + output[2] + " ms");

        return output;
    }
}

