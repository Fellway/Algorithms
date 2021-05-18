package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LevenshteinJunitTest {

    @Test
    public void shouldReturnExpectedResults() {
        assertEquals(1.5, Levenshtein.calculate("kot", "kita"), 0);
        assertEquals(2, Levenshtein.calculate("drab", "dal"), 0);
        assertEquals(2, Levenshtein.calculate("foka", "kotka"), 0);
        assertEquals(0, Levenshtein.calculate("kot", "kot"), 0);
        assertEquals(2, Levenshtein.calculate("kaj", "kajak"), 0);
        assertEquals(2, Levenshtein.calculate("smar", "tar"), 0);
        assertEquals(1, Levenshtein.calculate("granat", "granit"), 0);
        assertEquals(3, Levenshtein.calculate("orczyk", "oracz"), 0);
        assertEquals(4, Levenshtein.calculate("marka", "ariada"), 0);
        assertEquals(3.5, Levenshtein.calculate("maroa", "ariada"), 0);
    }
}
