package com.binary.tree.models.enums;

import java.util.Random;

public enum Color {
    RED,
    YELLOW,
    BLACK,
    WHITE,
    ORANGE;

    public static Color getRandomColor() {
        int pick = new Random().nextInt(Color.values().length);
        return Color.values()[pick];
    }
}
