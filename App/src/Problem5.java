import java.util.*;

public class Problem5 {

    // -------- LINEAR SEARCH --------
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY SEARCH (FIND ONE) --------
    public static int binarySearch(String[] arr, String target, Counter counter) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // -------- FIND FIRST OCCURRENCE (BINARY) --------
    public static int findFirst(String[] arr, String target, Counter counter) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // move left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // -------- FIND LAST OCCURRENCE (BINARY) --------
    public static int findLast(String[] arr, String target, Counter counter) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // move right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"}; // SORTED

        String target = "accB";

        // Linear Search
        linearSearch(logs, target);

        // Binary Search
        Counter counter = new Counter();

        int first = findFirst(logs, target, counter);
        int last = findLast(logs, target, counter);

        int count = (first == -1) ? 0 : (last - first + 1);

        System.out.println("\nBinary Search:");
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + counter.count);
    }
}

// Helper class for counting comparisons
class Counter {
    int count = 0;
}