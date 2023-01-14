package com.unvise.oop.sort;

import java.util.List;

public interface Sort<E extends Comparable<? super E>> {
    List<E> sort(List<E> values);
}
