package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Levenshtein {

    private static final Map<Character, Integer> keyCodes = new HashMap<Character, Integer>() {{
        put('q', 100);
        put('w', 101);
        put('e', 102);
        put('r', 103);
        put('t', 104);
        put('y', 105);
        put('u', 106);
        put('i', 107);
        put('o', 108);
        put('p', 109);
        put('a', 200);
        put('s', 201);
        put('d', 202);
        put('f', 203);
        put('g', 204);
        put('h', 205);
        put('j', 206);
        put('k', 207);
        put('l', 208);
        put('z', 300);
        put('x', 301);
        put('c', 302);
        put('v', 303);
        put('b', 304);
        put('n', 305);
        put('m', 306);
    }};

    public static double calculate(final String s1, final String s2) {
        final int matrixXLength = s1.length();
        final int matrixYLength = s2.length();
        final double[][] matrix = new double[matrixXLength + 1][matrixYLength + 1];

        IntStream.rangeClosed(0, s1.length()).forEach(i -> matrix[i][0] = i);
        IntStream.rangeClosed(0, s2.length()).forEach(i -> matrix[0][i] = i);

        IntStream.rangeClosed(1, s1.length()).forEach(
                i -> IntStream.rangeClosed(1, s2.length()).forEach(
                        j -> matrix[i][j] =
                                findMin(
                                        remove(matrix, i, j),
                                        insert(matrix, i, j),
                                        change(matrix, i, j, s1, s2))
                )
        );

        return matrix[matrixXLength][matrixYLength];
    }

    private static double remove(final double[][] matrix, final int i, final int j) {
        return matrix[i - 1][j] + 1;
    }

    private static double insert(final double[][] matrix, final int i, final int j) {
        return matrix[i][j - 1] + 1;
    }

    private static double change(final double[][] matrix, final int i, final int j, final String s1, final String s2) {
        return matrix[i - 1][j - 1] + calculateCost(s1.charAt(i - 1), s2.charAt(j - 1));
    }

    private static double findMin(final Double n1, final Double n2, final Double n3) {
        return Math.min(n1, Math.min(n2, n3));
    }

    private static double calculateCost(final char c1, final char c2) {
        switch (keyCodes.get(c1) - keyCodes.get(c2)) {
            case 0:
                return 0;
            case -1:
            case 1:
                return 0.5;
            default:
                return 1;
        }
    }

}
