package org.example;

public class Metrics {
    public double comparisons = 0;
    public double allocations = 0;
    public double runtimeNanos = 0;

    public void reset() {
        comparisons = 0;
        allocations = 0;
        runtimeNanos = 0;
    }
}