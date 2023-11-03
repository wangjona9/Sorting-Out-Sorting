import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Jonathan Wang
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   * 
   * @param <T>
   */
  private static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid - 1); // Recursive calls onto halves of the array
      quicksort(values, order, mid + 1, ub);
    }
  } // quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  private static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    T pivotVal = arr[lb]; // Pivot value
    int left = lb + 1;
    int right = ub;

    while (true) {
      while (left <= right && order.compare(arr[left], pivotVal) <= 0) {
        left++; // Increment left pointer
      }

      while (order.compare(arr[right], pivotVal) > 0) {
        right--; // Decrement right pointer
      }

      if (left >= right) {
        break; // Break out of inner loop
      }

      T temp = arr[left]; // Swap values
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    arr[lb] = arr[right];
    arr[right] = pivotVal;

    return right;
  } // partition()

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>
} // class Quicksort
