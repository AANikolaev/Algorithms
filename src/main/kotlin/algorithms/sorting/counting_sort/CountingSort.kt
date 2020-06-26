package algorithms.sorting.counting_sort

import algorithms.sorting.InplaceSort


class CountingSort : InplaceSort {

    override fun sort(values: IntArray) {
        var minValue = Int.MAX_VALUE
        var maxValue = Int.MIN_VALUE
        for (i in values.indices) {
            if (values[i] < minValue) minValue = values[i]
            if (values[i] > maxValue) maxValue = values[i]
        }
        countingSort(values, minValue, maxValue)
    }

    // Sorts values in the range of [minVal, maxVal] in O(n+maxVal-maxVal)
    private fun countingSort(ar: IntArray, minVal: Int, maxVal: Int) {
        val sz = maxVal - minVal + 1
        val b = IntArray(sz)
        for (i in ar.indices) b[ar[i] - minVal]++
        var i = 0
        var k = 0
        while (i < sz) {
            while (b[i]-- > 0) ar[k++] = i + minVal
            i++
        }
    }

}