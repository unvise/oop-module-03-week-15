package com.unvise.oop;

import com.unvise.oop.sort.MergeSort;
import com.unvise.oop.sort.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MergeSortDemoApp {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(IntStream.range(1, 100).boxed().toList());
        Collections.shuffle(integers);
        System.out.println("Не отсортированный список: ");
        System.out.println(integers);
        System.out.println("Отсортированный список: ");
        Sort<Integer> mergeSort = new MergeSort<>();
        System.out.println(mergeSort.sort(integers));
    }
}
