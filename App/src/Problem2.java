import java.util.Arrays;
import java.util.*;

// Client class
class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + "(" + accountBalance + ")";
    }
}

public class Problem2 {

    // Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // Visualization
                    System.out.println("Swap: " + Arrays.toString(arr));
                }
            }

            if (!swapped) break;
        }

        System.out.println("\nBubble Sorted (Ascending):");
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Swaps: " + swaps);
    }

    // Insertion Sort (Descending by riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j]; // shift
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sorted (Descending):");
        System.out.println(Arrays.toString(arr));
    }

    // Top 10 highest risk clients
    public static void topClients(Client[] arr, int k) {
        System.out.println("\nTop " + k + " Highest Risk Clients:");

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000)
        };

        // Copy arrays
        Client[] bubbleArr = Arrays.copyOf(clients, clients.length);
        Client[] insertionArr = Arrays.copyOf(clients, clients.length);

        // Bubble Sort
        bubbleSort(bubbleArr);

        // Insertion Sort
        insertionSort(insertionArr);

        // Top clients
        topClients(insertionArr, 10);
    }
}