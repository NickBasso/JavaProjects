package com.base;

import Sortings.Sortings;

public class Main{

    public static void main(String[] args) throws Exception {
        Sortings QuickSortObj = new Sortings();
        QuickSortObj.QuickSort();

        Sortings MergeSortObj = new Sortings();
        MergeSortObj.MergeSort();
    }
}
