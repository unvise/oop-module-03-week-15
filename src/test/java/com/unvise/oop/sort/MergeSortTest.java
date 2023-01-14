package com.unvise.oop.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MergeSortTest {
    @Test
    void integersSortingTest() {
        // given
        Sort<Integer> mergeSort = new MergeSort<>();
        List<Integer> integers = new ArrayList<>(List.of(5, 1, 1, 12, 3, 5, 1));
        // then
        assertEquals(integers.stream().sorted().toList(), mergeSort.sort(integers));
    }

    @Test
    void doublesSortingTest() {
        // given
        Sort<Double> mergeSort = new MergeSort<>();
        List<Double> doubles = new ArrayList<>(List.of(5d, 1d, 1d, 12d, 3d, 5d, 1d));
        // then
        assertEquals(doubles.stream().sorted().toList(), mergeSort.sort(doubles));
    }

    @Test
    void stringsSortingTest() {
        // given
        Sort<String> mergeSort = new MergeSort<>();
        List<String> strings = new ArrayList<>(List.of("b", "g", "s", "t", "f", "a"));
        // then
        assertEquals(strings.stream().sorted().toList(), mergeSort.sort(strings));
    }


    @Test
    void nonCorrectTypeTest() {
        // given
        Sort<Float> mergeSort = new MergeSort<>();
        List<Float> floats = new ArrayList<>(List.of(5f, 1f, 1f, 12f, 3f, 5f, 1f));
        // then
        assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(floats));
    }

    @Test
    void nonChangeabilityTest() {
        // given
        Sort<Integer> mergeSort = new MergeSort<>();
        List<Integer> originalList = List.of(5, 1, 1, 12, 3, 5, 1);
        List<Integer> integers = new ArrayList<>(originalList);
        // when
        mergeSort.sort(integers);
        // then
        assertEquals(originalList, integers);
    }
}