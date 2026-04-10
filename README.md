# week3_week4_practice

## Financial & System Applications (Problems 1–6)

---

## 📌 Overview

This project demonstrates the practical application of **sorting and searching algorithms** in real-world financial and system scenarios such as banking transactions, portfolio management, and risk analysis.

Each problem focuses on selecting the **right algorithm based on data size, performance requirements, and constraints**, helping build a strong foundation in **algorithm design and analysis**.

---

## 🧩 Problems Covered

### 🔹 Problem 1: Transaction Fee Sorting for Audit Compliance

* **Goal:** Sort transactions based on fees for auditing.
* **Algorithms Used:**

  * Bubble Sort (≤ 100 elements)
  * Insertion Sort (100–1000 elements)
* **Features:**

  * Stable sorting (handles duplicates)
  * Early termination in Bubble Sort
  * High-fee outlier detection (> 50)
* **Complexity:**

  * Bubble Sort → O(n²), Best: O(n)
  * Insertion Sort → O(n²), Best: O(n)

---

### 🔹 Problem 2: (Contextual / System Design Based)

* Focuses on efficient handling of large-scale operations.
* Emphasizes **performance and real-time constraints**.

---

### 🔹 Problem 3: (Contextual / Data Handling)

* Covers structured data operations and optimization.
* Builds foundation for advanced algorithm selection.

---

### 🔹 Problem 4: Portfolio Return Sorting

* **Goal:** Sort assets for investment decisions.
* **Algorithms Used:**

  * Merge Sort (ascending, stable)
  * Quick Sort (descending + volatility ascending)
* **Features:**

  * Stable sorting using Merge Sort
  * Median-of-3 pivot selection
  * Hybrid Quick + Insertion optimization
* **Complexity:**

  * Merge Sort → O(n log n)
  * Quick Sort → Avg: O(n log n), Worst: O(n²)

---

### 🔹 Problem 5: Account ID Lookup in Transaction Logs

* **Goal:** Efficient search in large transaction datasets.
* **Algorithms Used:**

  * Linear Search (unsorted data)
  * Binary Search (sorted data)
* **Features:**

  * First & last occurrence detection
  * Duplicate handling
  * Comparison counting
* **Complexity:**

  * Linear → O(n)
  * Binary → O(log n)

---

### 🔹 Problem 6: Risk Threshold Binary Lookup

* **Goal:** Assign clients to risk bands efficiently.
* **Algorithms Used:**

  * Linear Search (unsorted)
  * Binary Search (sorted)
* **Features:**

  * Floor (≤ target) and Ceiling (≥ target)
  * Lower bound (insertion point)
  * Comparison tracking
* **Complexity:**

  * Linear → O(n)
  * Binary → O(log n)

---

## ⚙️ Technologies Used

* **Language:** Java
* **Concepts:**

  * Arrays & ArrayLists
  * Sorting Algorithms
  * Searching Algorithms
  * Time Complexity Analysis
  * Stability in Sorting

---

## 🚀 How to Run

1. Compile the program:

```bash
javac FileName.java
```

2. Run the program:

```bash
java FileName
```

---

## 📊 Key Learnings

* Choosing the right algorithm based on **input size**
* Understanding **time complexity trade-offs**
* Importance of **stable sorting in financial systems**
* Efficient searching in **large datasets**
* Real-world application of **binary search variants**

---

## 🔍 Applications

* Banking transaction audits
* Fraud detection systems
* Portfolio optimization
* Risk analysis systems
* Compliance and reporting tools

---


## 📌 Conclusion

This project bridges the gap between **theoretical algorithms and real-world applications**, helping understand not just *how* algorithms work, but *why* they are chosen in different scenarios.

---
