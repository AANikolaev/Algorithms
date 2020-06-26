package algorithms.sorting.merge_sort

import algorithms.sorting.InplaceSort


class MergeSort : InplaceSort {

    override fun sort(values: IntArray) {
        val sortedValues = mergeSort(values)
        for (i in values.indices) {
            values[i] = sortedValues[i]
        }
    }

    private fun mergeSort(ar: IntArray): IntArray {
        // Base case is when a single element (which is already sorted)
        val n = ar.size
        if (n <= 1) return ar

        // Split array into two parts and recursively sort them
        val left = mergeSort(ar.copyOfRange(0, n / 2))
        val right = mergeSort(ar.copyOfRange(n / 2, n))

        // Combine the two arrays into one larger array
        return merge(left, right)
    }

    // Merge two sorted arrays into a larger sorted array
    private fun merge(ar1: IntArray, ar2: IntArray): IntArray {
        val n1 = ar1.size
        val n2 = ar2.size
        val n = n1 + n2
        var i1 = 0
        var i2 = 0
        val ar = IntArray(n)
        for (i in 0 until n) {
            if (i1 == n1) {
                ar[i] = ar2[i2++]
            } else if (i2 == n2) {
                ar[i] = ar1[i1++]
            } else {
                if (ar1[i1] < ar2[i2]) {
                    ar[i] = ar1[i1++]
                } else {
                    ar[i] = ar2[i2++]
                }
            }
        }
        return ar
    }
}