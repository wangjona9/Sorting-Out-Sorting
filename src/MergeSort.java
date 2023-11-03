import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Jonathan Wang
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   * 
   * @param <T>
   */
  public static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    // int n = vals.length;

    if (lo < hi) {
      // return;

      int mid = lo + (hi - lo) / 2;

      // Recursion on left and right arrays
      mergeSort(vals, lo, mid, comparator);
      mergeSort(vals, mid + 1, hi, comparator);

      // Merge the sorted arrays
      merge(vals, lo, mid, hi, comparator);
    }
  } // mergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  
  private static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int leftSize = mid - lo + 1; // Initialize left and right sizes
    int rightSize = hi - mid;

    T[] left = Arrays.copyOfRange(vals, lo, mid + 1); // Initialize left and right arrays
    T[] right = Arrays.copyOfRange(vals, mid + 1, hi + 1);

    int i = 0, j = 0, k = lo; // Pointers

    while (i < leftSize && j < rightSize) {
      if (comparator.compare(left[i], right[j]) <= 0) { // Perform merging of the array
        vals[k] = left[i]; // Set left side
        i++;
      } else {
        vals[k] = right[j]; // Set right side
        j++;
      }
      k++;
    }

    while (i < leftSize) { // Store remainder vals in left
      vals[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) { // Store remainder vals in right
      vals[k] = right[j];
      j++;
      k++;
    }
  }

  public static <T> void mergeHelper(T[] vals, Comparator<? super T> comparator) {
    mergeSort(vals, 0, vals.length - 1, comparator);
  } // mergeHelper()

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeHelper(values, order);
  } // sort(T[], Comparator<? super T>
} // class MergeSort
