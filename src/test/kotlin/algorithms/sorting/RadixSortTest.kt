package algorithms.sorting

import algorithms.sorting.radix_sort.RadixSort
import com.google.common.truth.Truth
import org.junit.Test
import java.util.*

class RadixSortTest {
    @Test
    fun testGetMax() {
        val array = intArrayOf(5, 7, 1, 13, 1013, 287, 912)
        Truth.assertThat(RadixSort().getMax(array)).isEqualTo(1013)
    }

    @Test
    fun testCalculateNumberOfDigits() {
        Truth.assertThat(RadixSort().calculateNumberOfDigits(1089)).isEqualTo(4)
        Truth.assertThat(RadixSort().calculateNumberOfDigits(19)).isEqualTo(2)
    }

    @Test
    fun randomRadixSort_smallNumbers() {
        for (size in 0..999) {
            val values = IntArray(size)
            for (i in 0 until size) {
                values[i] = randInt(1, 50)
            }
            val copy = values.clone()
            Arrays.sort(values)
            RadixSort().radixSort(copy)
            Truth.assertThat(values).isEqualTo(copy)
        }
    }

    @Test
    fun randomRadixSort_largeNumbers() {
        for (size in 0..999) {
            val values = IntArray(size)
            for (i in 0 until size) {
                values[i] = randInt(1, Int.MAX_VALUE)
            }
            val copy = values.clone()
            Arrays.sort(values)
            RadixSort().radixSort(copy)
            Truth.assertThat(values).isEqualTo(copy)
        }
    }

    companion object {
        var random = Random()

        // return a random number between [min, max]
        fun randInt(min: Int, max: Int): Int {
            return random.nextInt(max - min + 1) + min
        }
    }
}