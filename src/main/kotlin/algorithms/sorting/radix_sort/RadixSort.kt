package algorithms.sorting.radix_sort

import algorithms.sorting.InplaceSort
import kotlin.math.log10


class RadixSort : InplaceSort {
    override fun sort(values: IntArray) {
        radixSort(values)
    }

    fun getMax(array: IntArray): Int {
        var max = array[0]
        for (i in array.indices) {
            if (array[i] > max) {
                max = array[i]
            }
        }
        return max
    }

    fun calculateNumberOfDigits(number: Int): Int {
        return log10(number.toDouble()).toInt() + 1
    }

    // Requires all numbers to be greater than or equal to 1
    fun radixSort(numbers: IntArray?) {
        if (numbers == null || numbers.size <= 1) {
            return
        }
        val maximum = getMax(numbers)
        var numberOfDigits = calculateNumberOfDigits(maximum)
        var placeValue = 1
        while (numberOfDigits-- > 0) {
            countSort(numbers, placeValue)
            placeValue *= 10
        }
    }

    private fun countSort(numbers: IntArray, placeValue: Int) {
        val range = 10
        val frequency = IntArray(range)
        val sortedValues = IntArray(numbers.size)
        for (i in numbers.indices) {
            val digit = numbers[i] / placeValue % range
            frequency[digit]++
        }
        for (i in 1 until range) {
            frequency[i] += frequency[i - 1]
        }
        for (i in numbers.indices.reversed()) {
            val digit = numbers[i] / placeValue % range
            sortedValues[frequency[digit] - 1] = numbers[i]
            frequency[digit]--
        }
        System.arraycopy(sortedValues, 0, numbers, 0, numbers.size)
    }
}