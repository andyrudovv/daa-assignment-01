package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void simpleTriangle() {
        List<ClosestPair.Point> points = List.of(
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 0),
                new ClosestPair.Point(0, 1)
        );

        Metrics metrics = new Metrics();

        ClosestPair.Pair result = ClosestPair.findClosestPair(points, metrics);

        assertEquals(1.0, result.distance(), 1e-9);
        assertTrue(metrics.comparisons > 0, "idk");
    }

    @Test
    void bruteForceValidationSmallSet() {
        Random random = new Random(42);
        List<ClosestPair.Point> points = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            points.add(new ClosestPair.Point(random.nextDouble(), random.nextDouble()));
        }

        Metrics metrics = new Metrics();

        ClosestPair.Pair fast = ClosestPair.findClosestPair(points, metrics);

        double bruteForce = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double dx = points.get(i).x() - points.get(j).x();
                double dy = points.get(i).y() - points.get(j).y();
                bruteForce = Math.min(bruteForce, Math.hypot(dx, dy));
            }
        }

        assertEquals(bruteForce, fast.distance(), 1e-9);
        assertTrue(metrics.comparisons > 0, "idk");
    }

    @Test
    void handlesTwoPoints() {
        List<ClosestPair.Point> points = List.of(
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(6, 8)
        );

        Metrics metrics = new Metrics();

        ClosestPair.Pair result = ClosestPair.findClosestPair(points, metrics);

        assertEquals(5.0, result.distance(), 1e-9);
        assertTrue(metrics.comparisons > 0);
    }

    @Test
    void throwsOnInvalidInput() {
        Metrics metrics = new Metrics();
        assertThrows(IllegalArgumentException.class, () ->
                ClosestPair.findClosestPair(Collections.emptyList(), metrics));
        assertThrows(IllegalArgumentException.class, () ->
                ClosestPair.findClosestPair(List.of(new ClosestPair.Point(0, 0)), metrics));
    }

    @Test
    void bruteForceComparisonAt2000Points() {
        Random rnd = new Random(123);
        List<ClosestPair.Point> points = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            points.add(new ClosestPair.Point(rnd.nextDouble(), rnd.nextDouble()));
        }

        Metrics metrics = new Metrics();

        ClosestPair.Pair fast = ClosestPair.findClosestPair(points, metrics);

        double bruteForce = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double dx = points.get(i).x() - points.get(j).x();
                double dy = points.get(i).y() - points.get(j).y();
                bruteForce = Math.min(bruteForce, Math.hypot(dx, dy));
            }
        }

        assertEquals(bruteForce, fast.distance(), 1e-9);
        assertTrue(metrics.comparisons > 0);
    }

    @Test
    void handlesLargeInputWithoutBruteForce() {
        Random rnd = new Random(42);
        List<ClosestPair.Point> points = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            points.add(new ClosestPair.Point(rnd.nextDouble(), rnd.nextDouble()));
        }

        Metrics metrics = new Metrics();

        ClosestPair.Pair fast = ClosestPair.findClosestPair(points, metrics);

        assertNotNull(fast, "...");
        assertTrue(fast.distance() >= 0, "ufdasjlk");
        assertTrue(metrics.comparisons > 0, ";)..");
    }
}