import java.util.*;

// Asset class
class Asset {
    String name;
    double returnRate;
    double volatility;

    public Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    @Override
    public String toString() {
        return name + ":" + returnRate + "% (vol=" + volatility + ")";
    }
}

public class Problem4 {

    // ---------------- MERGE SORT (STABLE, ASC) ----------------
    public static void mergeSort(List<Asset> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private static void merge(List<Asset> list, int left, int mid, int right) {
        List<Asset> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            // stable: <= keeps original order for ties
            if (list.get(i).returnRate <= list.get(j).returnRate) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    // ---------------- QUICK SORT (DESC + VOL ASC) ----------------
    public static void quickSort(List<Asset> list, int low, int high) {
        if (low < high) {

            // Hybrid: use insertion sort for small partitions
            if (high - low < 10) {
                insertionSort(list, low, high);
                return;
            }

            int pivotIndex = medianOfThree(list, low, high);
            int pi = partition(list, low, high, pivotIndex);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static int partition(List<Asset> list, int low, int high, int pivotIndex) {
        Asset pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);

        int i = low - 1;

        for (int j = low; j < high; j++) {
            // DESC returnRate, ASC volatility
            if (list.get(j).returnRate > pivot.returnRate ||
                    (list.get(j).returnRate == pivot.returnRate &&
                            list.get(j).volatility < pivot.volatility)) {

                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    // Median-of-3 pivot
    private static int medianOfThree(List<Asset> list, int low, int high) {
        int mid = (low + high) / 2;

        double a = list.get(low).returnRate;
        double b = list.get(mid).returnRate;
        double c = list.get(high).returnRate;

        if ((a > b && a < c) || (a < b && a > c)) return low;
        else if ((b > a && b < c) || (b < a && b > c)) return mid;
        else return high;
    }

    // Insertion sort for hybrid quicksort
    private static void insertionSort(List<Asset> list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = list.get(i);
            int j = i - 1;

            while (j >= low &&
                    (list.get(j).returnRate < key.returnRate ||
                            (list.get(j).returnRate == key.returnRate &&
                                    list.get(j).volatility > key.volatility))) {

                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        List<Asset> assets = new ArrayList<>();
        assets.add(new Asset("AAPL", 12, 5));
        assets.add(new Asset("TSLA", 8, 9));
        assets.add(new Asset("GOOG", 15, 4));

        // Merge Sort (ASC)
        List<Asset> mergeList = new ArrayList<>(assets);
        mergeSort(mergeList, 0, mergeList.size() - 1);

        System.out.println("Merge Sort (ASC):");
        System.out.println(mergeList);

        // Quick Sort (DESC + volatility ASC)
        List<Asset> quickList = new ArrayList<>(assets);
        quickSort(quickList, 0, quickList.size() - 1);

        System.out.println("\nQuick Sort (DESC + Vol ASC):");
        System.out.println(quickList);
    }
}
