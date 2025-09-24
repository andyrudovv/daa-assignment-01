# Report: Divide & Conquer Algorithms

## 1. MergeSort

* Recurrence: splits into two halves and merges in linear time.
* Method: Master Theorem, Case 2.
* Result: running time grows as n log n.
* Notes: recursion depth is logarithmic.

---

## 2. QuickSort (randomized, recurse on smaller partition)

* Recurrence: splits into two subproblems plus linear partitioning.
* Method: Master Theorem intuition, assuming balanced splits.
* Result: expected running time is n log n, worst case is quadratic.
* Notes: random pivot prevents adversarial worst cases, recursion depth is usually logarithmic.

---

## 3. Deterministic Select (Median-of-Medians)

* Recurrence: always splits off a small part and a larger but bounded part.
* Method: Akra–Bazzi intuition for unbalanced divide-and-conquer.
* Result: guaranteed linear running time.
* Notes: avoids bad pivot choices of randomized selection.

---

## 4. Closest Pair of Points (2D)

* Recurrence: divides into two halves, then checks a linear strip.
* Method: Master Theorem, Case 2.
* Result: running time grows as n log n.
* Notes: strip step only needs a small constant number of comparisons per point.

---

## Experimental Plots (Initial)

* Time vs n: MergeSort and QuickSort both scale like n log n, QuickSort is often faster due to cache effects. Select grows linearly. Closest Pair matches n log n.
* Recursion depth vs n: MergeSort is logarithmic, QuickSort is usually logarithmic with some variation, Select and Closest Pair are shallow and predictable.

---

## Summary

* MergeSort, Select, and Closest Pair match their theoretical predictions.
* QuickSort shows more variation: average n log n, but real performance depends on pivot randomness and hardware effects.