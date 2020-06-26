package algorithms.sorting.selection_sort

import algorithms.sorting.InplaceSort


class SelectionSort : InplaceSort {
    override fun sort(values: IntArray) {
        selectionSort(values)
    }

    private fun selectionSort(array: IntArray?) {
        if (array == null) return
        val n = array.size
        for (i in 0 until n) {
            // Find the index beyond i with a lower value than i
            var swapIndex = i
            for (j in i + 1 until n) {
                if (array[j] < array[swapIndex]) {
                    swapIndex = j
                }
            }
            swap(array, i, swapIndex)
        }
    }

    private fun swap(ar: IntArray, i: Int, j: Int) {
        val tmp = ar[i]
        ar[i] = ar[j]
        ar[j] = tmp
    }
}