package algorithms.sorting.quick_sort

import algorithms.sorting.InplaceSort


class QuickSort : InplaceSort {
    override fun sort(values: IntArray) {
        quickSort(values)
    }

    private fun quickSort(ar: IntArray?) {
        if (ar == null) return
        quickSort(ar, 0, ar.size - 1)
    }

    // Sort interval [lo, hi] inplace recursively
    private fun quickSort(ar: IntArray, lo: Int, hi: Int) {
        if (lo < hi) {
            val splitPoint: Int = partition(ar, lo, hi)
            quickSort(ar, lo, splitPoint)
            quickSort(ar, splitPoint + 1, hi)
        }
    }

    // Performs Hoare partition algorithm for quicksort
    private fun partition(ar: IntArray, lo: Int, hi: Int): Int {
        val pivot = ar[lo]
        var i = lo - 1
        var j = hi + 1
        while (true) {
            do {
                i++
            } while (ar[i] < pivot)
            do {
                j--
            } while (ar[j] > pivot)
            if (i < j) swap(ar, i, j) else return j
        }
    }

    // Swap two elements
    private fun swap(ar: IntArray, i: Int, j: Int) {
        val tmp = ar[i]
        ar[i] = ar[j]
        ar[j] = tmp
    }
}