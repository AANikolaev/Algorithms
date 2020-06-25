package algorithms.sorting

class BubbleSort : InplaceSort {

    override fun sort(values: IntArray) {
        bubbleSort(values)
    }

    companion object {
        // Sort the array using bubble sort. The idea behind
        // bubble sort is to look for adjacent indexes which
        // are out of place and interchange their elements
        // until the entire array is sorted.
        private fun bubbleSort(ar: IntArray?) {
            if (ar == null) {
                return
            }
            var sorted: Boolean
            do {
                sorted = true
                for (i in 1 until ar.size) {
                    if (ar[i] < ar[i - 1]) {
                        swap(ar, i - 1, i)
                        sorted = false
                    }
                }
            } while (!sorted)
        }

        private fun swap(ar: IntArray, i: Int, j: Int) {
            val tmp = ar[i]
            ar[i] = ar[j]
            ar[j] = tmp
        }
    }
}