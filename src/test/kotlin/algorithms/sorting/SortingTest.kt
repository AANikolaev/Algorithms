package algorithms.sorting

import algorithms.sorting.bubble_sort.BubbleSort
import algorithms.sorting.counting_sort.CountingSort
import algorithms.sorting.heap_sort.Heapsort
import algorithms.sorting.insertion_sort.InsertionSort
import algorithms.sorting.merge_sort.MergeSort
import algorithms.sorting.quick_sort.QuickSort
import algorithms.sorting.radix_sort.RadixSort
import algorithms.sorting.selection_sort.SelectionSort
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*


// Test all sorting algorithms under various constraints.
//
// Not all sorting algorithms are suitable for every type for test. For instance,
// counting sort cannot sort a range of numbers between [Integer.MIN_VALUE,
// Integer.MAX_VALUE] without running out of memory. Similarly, radix sort
// doesn't play well with negative numbers, etc..
class SortingTest {
    internal enum class SortingAlgorithm(val sortingAlgorithm: InplaceSort) {
        BUBBLE_SORT(BubbleSort()),
        QUICK_SORT(QuickSort()),
        SELECTION_SORT(SelectionSort()),
        INSERTION_SORT(InsertionSort()),
        MERGE_SORT(MergeSort()),
        HEAP_SORT(Heapsort()),
        COUNTING_SORT(CountingSort()),
        RADIX_SORT(RadixSort())
    }

    @Test
    fun verifySortingAlgorithms_smallPositiveIntegersOnly() {
        for (size in 0..999) {
            for (algorithm in sortingAlgorithms) {
                val sorter = algorithm.sortingAlgorithm
                val values: IntArray = randomIntegerArray(size, 0, 51)
                val copy = values.clone()
                Arrays.sort(values)
                sorter.sort(copy)
                assertThat(values).isEqualTo(copy)
            }
        }
    }

    @Test
    fun verifySortingAlgorithms_smallNegativeIntegersOnly() {
        for (size in 0..999) {
            for (algorithm in sortingAlgorithms) {
                if (algorithm == SortingAlgorithm.RADIX_SORT) {
                    continue
                }
                val sorter = algorithm.sortingAlgorithm
                val values: IntArray = randomIntegerArray(size, -50, 51)
                val copy = values.clone()
                Arrays.sort(values)
                sorter.sort(copy)
                assertThat(values).isEqualTo(copy)
            }
        }
    }

    private val sortingAlgorithms = EnumSet.of(
        SortingAlgorithm.BUBBLE_SORT,
        SortingAlgorithm.QUICK_SORT,
        SortingAlgorithm.SELECTION_SORT,
        SortingAlgorithm.INSERTION_SORT,
        SortingAlgorithm.MERGE_SORT,
        SortingAlgorithm.HEAP_SORT,
        SortingAlgorithm.COUNTING_SORT,
        SortingAlgorithm.RADIX_SORT
    )

    // Generates an array of random values where every number is between
    // [min, max) and there are possible repeats.
    private fun randomIntegerArray(sz: Int, min: Int, max: Int): IntArray {
        val ar = IntArray(sz)
        for (i in 0 until sz) ar[i] = randValue(min, max)
        return ar
    }

    // Generates a random number between [min, max)
    private fun randValue(min: Int, max: Int): Int {
        return min + (Math.random() * (max - min)).toInt()
    }
}