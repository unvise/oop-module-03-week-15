package com.unvise.oop.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort<E extends Comparable<? super E>> implements Sort<E> {
    @Override
    public List<E> sort(List<E> values) {
        if (values.size() <= 1) {
            return values;
        }
        checkCorrectType(values);
        int middle = values.size() / 2;
        List<E> left = values.subList(0, middle);
        List<E> right = values.subList(middle, values.size());
        right = sort(right);
        left = sort(left);
        return merge(left, right);
    }

    private List<E> merge(List<E> left, List<E> right) {
        List<E> result = new ArrayList<>();
        Iterator<E> iter1 = left.iterator();
        Iterator<E> iter2 = right.iterator();
        E x = iter1.next();
        E y = iter2.next();
        while (true) {
            if (x.compareTo(y) <= 0) {
                result.add(x);
                if (iter1.hasNext()) {
                    x = iter1.next();
                    continue;
                }
                result.add(y);
                whileIterHasAdd(iter2, result);
                break;
            }
            result.add(y);
            if (iter2.hasNext()) {
                y = iter2.next();
                continue;
            }
            result.add(x);
            whileIterHasAdd(iter1, result);
            break;
        }
        return result;
    }

    private void whileIterHasAdd(Iterator<E> iterator, List<E> list) {
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    private void checkCorrectType(List<E> values)
            throws IllegalArgumentException {
        if (values.get(0) instanceof Integer
                || values.get(0) instanceof Double
                || values.get(0) instanceof String) {
            return;
        }
        throw new IllegalArgumentException("Должен быть тип Integer, Double или String");
    }
}