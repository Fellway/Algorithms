package org.example;

public class Ruler {
    public static void main(String[] args) {
        draw(2, 5);
    }

    /**
     * Method responsible for drawing vertical ruler with decorators at the beginning and end
     *
     * @param length of the ruler
     * @param deep   of units on the ruler
     */
    public static void draw(final Integer length, final Integer deep) {
        for (int i = 0; i < length; i++) {
            drawLine(deep, i);
            drawRecursion(deep - 1, deep);
        }
        drawLine(deep, length);
    }

    /**
     * Method responsible for drawing vertical ruler.
     *
     * @param deep        of units on the ruler
     * @param initialDeep needed to draw the right amount of spaces on the console
     */
    private static void drawRecursion(final Integer deep, final Integer initialDeep) {
        if (deep == 0) {
            return;
        }
        drawRecursion(deep - 1, initialDeep);
        drawSpace(initialDeep - deep);
        drawLine(deep);
        drawRecursion(deep - 1, initialDeep);
    }

    /**
     * Method responsible for drawing line of given length with suffix.
     *
     * @param length of line
     * @param suffix to add after line
     */
    private static void drawLine(final Integer length, final Integer suffix) {
        for (int i = 0; i < length; i++) {
            System.out.print("--");
        }
        System.out.print(" " + suffix);
        System.out.println();
    }

    /**
     * Method responsible for drawing line of given length
     *
     * @param length of line
     */
    private static void drawLine(final Integer length) {
        for (int i = 0; i < length; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    /**
     * Method responsible for drawing spaces
     *
     * @param length of spaces
     */
    private static void drawSpace(final Integer length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
    }
}
