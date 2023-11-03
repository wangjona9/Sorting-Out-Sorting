import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Jonathan Wang
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  private static <T> void insertionSort(T[] values, Comparator<? super T> comparator) {
    for (int i = 1; i < values.length; i++) { 
      T temp = values[i];
      int j = i - 1; // Initialize pointer

      while (j >= 0 && comparator.compare(values[j], temp) > 0) { // Create temp
        values[j + 1] = values[j]; // Implement sorting by insertion
        j--;
      }
      values[j + 1] = temp; // Store as temp
    }
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    insertionSort(values, order);
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
