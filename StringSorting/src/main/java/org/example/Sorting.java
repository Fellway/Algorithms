package org.example;

import java.text.Collator;
import java.util.Arrays;

public class Sorting {

    public static void sortStrings(final Collator collator, final String[] words) {
        for (int i = 1; i < words.length; i++) {
            final String suspect = words[i];
            while ((i > 0) && collator.compare(words[i - 1], suspect) > 0) {
                words[i] = words[i - 1];
                i--;
            }
            words[i] = suspect;
        }
    }

    public static void fastSortStrings(final Collator collator, final String[] words) {
        Arrays.sort(words, collator);
    }

    public static void fastSortStrings2(final Collator collator, final String[] words) {
        Arrays.sort(words, (s1, s2) -> collator.compare(s1, s2));
    }
}
