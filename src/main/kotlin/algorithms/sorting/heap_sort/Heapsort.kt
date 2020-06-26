package algorithms.sorting.heap_sort

import algorithms.sorting.InplaceSort
import java.util.*


class Heapsort : InplaceSort {
    override fun sort(values: IntArray) {
        heapsort(values)
    }

    private fun heapsort(ar: IntArray?) {
        if (ar == null) return
        val n = ar.size

        // Heapify, converts array into binary heap O(n), see:
        // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
        for (i in Math.max(0, n / 2 - 1) downTo 0) {
            sink(ar, n, i)
        }

        // Sorting bit
        for (i in n - 1 downTo 0) {
            swap(ar, 0, i)
            sink(ar, i, 0)
        }
    }

    private fun sink(ar: IntArray, n: Int, i: Int) {
        var tmp = i
        while (true) {
            val left = 2 * tmp + 1 // Left  node
            val right = 2 * tmp + 2 // Right node
            var largest = tmp

            // Right child is larger than parent
            if (right < n && ar[right] > ar[largest]) largest = right

            // Left child is larger than parent
            if (left < n && ar[left] > ar[largest]) largest = left

            // Move down the tree following the largest node
            tmp = if (largest != tmp) {
                swap(ar, largest, tmp)
                largest
            } else break
        }
    }

    private fun swap(ar: IntArray, i: Int, j: Int) {
        val tmp = ar[i]
        ar[i] = ar[j]
        ar[j] = tmp
    }
}