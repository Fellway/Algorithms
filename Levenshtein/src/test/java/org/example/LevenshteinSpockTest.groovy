package org.example

import spock.lang.Specification

class LevenshteinSpockTest extends Specification {

    def "Given data should return expected results"(final String s1, final String s2, final Double result) {
        expect:
            Levenshtein.calculate(s1, s2) == result
        where:
            s1       | s2       || result
            "kot"    | "kita"   || 1.5
            "drab"   | "dal"    || 2
            "kaj"    | "kajak"  || 2
            "smar"   | "tar"    || 2
            "granat" | "granit" || 1
            "orczyk" | "oracz"  || 3
            "marka"  | "ariada" || 4
            "maroa"  | "ariada" || 3.5
    }
}
