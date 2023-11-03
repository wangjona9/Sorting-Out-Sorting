import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Something that fails to sort. Intended primarily to allow us to watch
 * tests fail.
 *
 * @author Samuel A. Rebelsky
 */

public class WangJonathanSort implements Sorter {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new WangJonathanSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     *
     * @param <T>
     */
    public static <T> void wangJonathanSort(T[] vals, Comparator<? super T> comparator) {
        int n = vals.length;

        // Create empty buckets
        List<List<T>> buckets = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Find the minimum and maximum values in vals
        T minVal = Arrays.stream(vals).min(comparator).orElse(null);
        T maxVal = Arrays.stream(vals).max(comparator).orElse(null);

        if (minVal == null || maxVal == null) {
            return; // Return early if either minVal or maxVal is null
        }

        // Place elements into buckets
        for (T val : vals) {
            int index = (int) ((n - 1) * ((double) (comparator.compare(val, minVal) - comparator.compare(val, maxVal))
                    / (comparator.compare(maxVal, minVal))));
            index = Math.max(0, Math.min(index, n - 1)); // Ensure index is within valid range
            buckets.get(index).add(val);
        }

        // Sort each bucket and reconstruct the sorted array
        int index = 0;
        for (List<T> bucket : buckets) {
            Collections.sort(bucket, comparator);
            for (T val : bucket) {
                vals[index++] = val;
            }
        }
    }

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        wangJonathanSort(values, order);
    }
}
