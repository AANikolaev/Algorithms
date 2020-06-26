package algorithms.sorting.insertion_sort

import algorithms.sorting.InplaceSort


class InsertionSort : InplaceSort {
    override fun sort(values: IntArray) {
        insertionSort(values)
    }

    // Sort the given array using insertion sort. The idea behind
    // insertion sort is that at the array is already sorted from
    // [0, i] and you want to add the element at position i+1, so
    // you 'insert' it at the appropriate location.
    private fun insertionSort(ar: IntArray?) {
        if (ar == null) {
            return
        }
        for (i in 1 until ar.size) {
            var j = i
            while (j > 0 && ar[j] < ar[j - 1]) {
                swap(ar, j - 1, j)
                j--
            }
        }
    }

    private fun swap(ar: IntArray, i: Int, j: Int) {
        val tmp = ar[i]
        ar[i] = ar[j]
        ar[j] = tmp
    }
}