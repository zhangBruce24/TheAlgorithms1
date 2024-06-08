package com.thealgorithms.maths;

public final class AbsoluteMax {
    private AbsoluteMax() {
    }

    /**
     * Finds the absolute maximum value among the given numbers.
     *
     * @param numbers The numbers to compare.
     * @return The absolute maximum value.
     * @throws IllegalArgumentException If the input array is empty or null.
     */
    public static int getMaxValue(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }
        
        int maxPositive = Integer.MIN_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        
        for (int number : numbers) {
            if (number >= 0 && number > maxPositive) {
                maxPositive = number;
            } else if (number < 0 && Math.abs(number) > Math.abs(maxNegative)) {
                maxNegative = number;
            }
        }
        
        return Math.max(maxPositive, maxNegative);
    }
}
