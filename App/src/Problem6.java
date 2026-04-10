import java.util.*;

// Helper class
class Counter {
    int count = 0;
}

public class Problem6 {

    // -------- LINEAR SEARCH (UNSORTED) --------
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY FLOOR (largest <= target) --------
    public static int floor(int[] arr, int target, Counter counter) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] < target) {
                result = arr[mid]; // possible floor
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // -------- BINARY CEILING (smallest >= target) --------
    public static int ceiling(int[] arr, int target, Counter counter) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target) {
                result = arr[mid]; // possible ceiling
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // -------- INSERTION POINT (lower_bound) --------
    public static int insertionPoint(int[] arr, int target, Counter counter) {
        int low = 0, high = arr.length;

        while (low < high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100}; // SORTED
        int target = 30;

        // Linear Search (unsorted case simulation)
        linearSearch(risks, target);

        Counter counter = new Counter();

        int floorVal = floor(risks, target, counter);
        int ceilVal = ceiling(risks, target, counter);

        System.out.println("\nBinary Search:");
        System.out.println("Floor: " + floorVal);
        System.out.println("Ceiling: " + ceilVal);
        System.out.println("Comparisons: " + counter.count);

        // Insertion Point
        Counter c2 = new Counter();
        int pos = insertionPoint(risks, target, c2);

        System.out.println("\nInsertion Position (lower_bound): " + pos);
        System.out.println("Comparisons: " + c2.count);
    }
}

