import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Jonathan Wang
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void wangJonathanTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
    System.out.println(original.toString());
  } // reverseOrderedStringTest

  public void reverseSortedArrayTest() {
    Integer[] original = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
  public void duplicateValsArrayTest() {
    Integer[] original = {2, 4, 2, 1, 5, 4};
    Integer[] expected = {1, 2, 2, 4, 4, 5};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  public void sortedValsArrayTest() {
    Integer[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
  public void nullArrayTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
    public void descendingArrayTest() {
        Integer[] original = {5, 3, 8, 1, 2, 7, 6, 4};
        Integer[] expected = {8, 7, 6, 5, 4, 3, 2, 1};

        // Define a comparator for sorting in descending order
        Comparator<Integer> descendingOrder = (x, y) -> y.compareTo(x);

        // Sort the array using the Sorter
        sorter.sort(original, descendingOrder);

        // Assert that the array is sorted correctly
        assertArrayEquals(original, expected);
    }


} // class SortTester
