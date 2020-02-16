package com.base;

import Sortings.Sortings;

public class Main{

    public static void main(String[] args) throws Exception {
        Sortings QuickSortObj = new Sortings();
        QuickSortObj.QuickSort();

        Sortings MergeSortObj = new Sortings();
        MergeSortObj.MergeSort();

        Sortings CountingSortObj = new Sortings();
        CountingSortObj.CountingSort();

        Sortings RadixSortObj = new Sortings();
        RadixSortObj.RadixSort();

        Sortings HeapSortObj = new Sortings();
        HeapSortObj.HeapSort();
    }
}
