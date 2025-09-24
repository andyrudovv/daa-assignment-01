package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sortsSmallUnorderedArray() {
        int[] array = {9, 4, 7, 1, 3, 6};
        int[] expected = array.clone();
        Arrays.sort(expected);

        QuickSort.sort(array);

        assertArrayEquals(expected, array, "Ascendary");
    }

    @Test
    void handlesAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = array.clone();

        QuickSort.sort(array);

        assertArrayEquals(expected, array, "no changes");
    }

    @Test
    void handlesArrayWithDuplicates() {
        int[] array = {5, 5, 5, 5};
        int[] expected = array.clone();

        QuickSort.sort(array);

        assertArrayEquals(expected, array, "no changes");
    }

    @Test
    void handlesEmptyArray() {
        int[] array = {};
        QuickSort.sort(array);

        assertArrayEquals(new int[]{}, array, "empty");
    }

    @Test
    void handlesSingleElement() {
        int[] array = {42};
        QuickSort.sort(array);

        assertArrayEquals(new int[]{42}, array, "one el same");
    }

    @Test
    void sortsLargeRandomArray() {
        Random random = new Random(42);
        int[] array = random.ints(10_000, -1000, 1000).toArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        QuickSort.sort(array);

        assertArrayEquals(expected, array, "should be correctly sorted ");
    }
}