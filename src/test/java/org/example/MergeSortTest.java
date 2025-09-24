package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    void sortsSmallUnorderedArray() {
        int[] array = {5, 2, 9, 1, 7, 3, 8};
        int[] expected = array.clone();
        Arrays.sort(expected);

        MergeSort.sort(array);

        assertArrayEquals(expected, array, "Should be sorted in ascending order");
    }

    @Test
    void handlesSingleElement() {
        int[] array = {42};
        MergeSort.sort(array);

        assertArrayEquals(new int[]{42}, array, "One el doesnt be changed");
    }

    @Test
    void handlesEmptyArray() {
        int[] array = {};
        MergeSort.sort(array);

        assertArrayEquals(new int[]{}, array, "Should be empty");
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = array.clone();

        MergeSort.sort(array);

        assertArrayEquals(expected, array, "Should be same");
    }

    @Test
    void sortsLargeRandomArray() {
        Random random = new Random(123);
        int[] array = random.ints(10_000, -1000, 1000).toArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        MergeSort.sort(array);

        assertArrayEquals(expected, array, "Should be same as default sort algo");
    }

    @Test
    void handlesArrayWithDuplicates() {
        int[] array = {5, 5, 3, 3, 1, 1};
        int[] expected = array.clone();
        Arrays.sort(expected);

        MergeSort.sort(array);

        assertArrayEquals(expected, array, "Should correctly sorted even with duplicates");
    }
}