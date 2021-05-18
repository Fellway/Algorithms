package org.example


import spock.lang.Specification

import java.text.Collator

import static java.util.Arrays.toString
import static org.junit.Assert.assertEquals

class SortingTest extends Specification {

    private final static Locale LOCALE = new Locale("pl", "PL", "UNIX")
    private final Collator COLLATOR = Collator.getInstance(LOCALE)

    def "Should correctly sort Strings using sortString method"() {
        given:
            final String[] unsortedWordsList = ["róże", "model", "duma", "idiota", "handel", "strumień", "tydzień", "sufit", "uprzedzenie", "szatan", "ankieta", "błoto", "porządek", "algi", "piec", "ukłon", "kochanek", "zespół", "wzmacniacz", "książka", "pub", "traktor", "plaża", "parkometr", "plik", "nowicjusz", "kobieta", "tarta", "fabryka", "zamieszki", "plastik", "bochenek", "zdjęcie", "groźba", "zawias", "komiks", "płacz", "decyzja", "polityka", "nożyczki"]
            final String[] expected = ["algi", "ankieta", "błoto", "bochenek", "decyzja", "duma", "fabryka", "groźba", "handel", "idiota", "kobieta", "kochanek", "komiks", "książka", "model", "nowicjusz", "nożyczki", "parkometr", "piec", "plastik", "plaża", "plik", "płacz", "polityka", "porządek", "pub", "róże", "strumień", "sufit", "szatan", "tarta", "traktor", "tydzień", "ukłon", "uprzedzenie", "wzmacniacz", "zamieszki", "zawias", "zdjęcie", "zespół"]

        when:
            Sorting.sortStrings(COLLATOR, unsortedWordsList)

        then:
            assertEquals(toString(expected), toString(unsortedWordsList))
    }

    def "Should correctly sort Strings given by teacher using sortString method"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final String[] expected = ["Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Świętopełk", "Zyta"]

        when:
            Sorting.sortStrings(COLLATOR, unsortedNames)

        then:
            assertEquals(toString(expected), toString(unsortedNames))
    }

    def "Should correctly sort Strings using fastSortString method"() {
        given:
            final String[] unsortedWordsList = ["róże", "model", "duma", "idiota", "handel", "strumień", "tydzień", "sufit", "uprzedzenie", "szatan", "ankieta", "błoto", "porządek", "algi", "piec", "ukłon", "kochanek", "zespół", "wzmacniacz", "książka", "pub", "traktor", "plaża", "parkometr", "plik", "nowicjusz", "kobieta", "tarta", "fabryka", "zamieszki", "plastik", "bochenek", "zdjęcie", "groźba", "zawias", "komiks", "płacz", "decyzja", "polityka", "nożyczki"]
            final String[] expected = ["algi", "ankieta", "błoto", "bochenek", "decyzja", "duma", "fabryka", "groźba", "handel", "idiota", "kobieta", "kochanek", "komiks", "książka", "model", "nowicjusz", "nożyczki", "parkometr", "piec", "plastik", "plaża", "plik", "płacz", "polityka", "porządek", "pub", "róże", "strumień", "sufit", "szatan", "tarta", "traktor", "tydzień", "ukłon", "uprzedzenie", "wzmacniacz", "zamieszki", "zawias", "zdjęcie", "zespół"]

        when:
            Sorting.fastSortStrings(COLLATOR, unsortedWordsList)

        then:
            assertEquals(toString(expected), toString(unsortedWordsList))
    }

    def "Should correctly sort Strings given by teacher using fastSortString method"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final String[] expected = ["Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Świętopełk", "Zyta"]

        when:
            Sorting.fastSortStrings(COLLATOR, unsortedNames)

        then:
            assertEquals(toString(expected), toString(unsortedNames))
    }

    def "Should correctly sort Strings using fastSortString2 method"() {
        given:
            final String[] unsortedWordsList = ["róże", "model", "duma", "idiota", "handel", "strumień", "tydzień", "sufit", "uprzedzenie", "szatan", "ankieta", "błoto", "porządek", "algi", "piec", "ukłon", "kochanek", "zespół", "wzmacniacz", "książka", "pub", "traktor", "plaża", "parkometr", "plik", "nowicjusz", "kobieta", "tarta", "fabryka", "zamieszki", "plastik", "bochenek", "zdjęcie", "groźba", "zawias", "komiks", "płacz", "decyzja", "polityka", "nożyczki"]
            final String[] expected = ["algi", "ankieta", "błoto", "bochenek", "decyzja", "duma", "fabryka", "groźba", "handel", "idiota", "kobieta", "kochanek", "komiks", "książka", "model", "nowicjusz", "nożyczki", "parkometr", "piec", "plastik", "plaża", "plik", "płacz", "polityka", "porządek", "pub", "róże", "strumień", "sufit", "szatan", "tarta", "traktor", "tydzień", "ukłon", "uprzedzenie", "wzmacniacz", "zamieszki", "zawias", "zdjęcie", "zespół"]

        when:
            Sorting.fastSortStrings2(COLLATOR, unsortedWordsList)

        then:
            assertEquals(toString(expected), toString(unsortedWordsList))
    }

    def "Should correctly sort Strings given by teacher using fastSortString2 method"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final String[] expected = ["Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Świętopełk", "Zyta"]

        when:
            Sorting.fastSortStrings2(COLLATOR, unsortedNames)

        then:
            assertEquals(toString(expected), toString(unsortedNames))
    }

    def "Insertion sort performance test"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final def insertionSortInitTime, insertionSortDuration

        when:
            insertionSortInitTime = System.nanoTime()
            for (i in 0..< 100_000) {
                Sorting.sortStrings(COLLATOR, unsortedNames.clone())
            }
            insertionSortDuration = System.nanoTime() - insertionSortInitTime

        then:
            println String.format("insertionSortDuration: %s", (double) insertionSortDuration / 1_000_000_000)
    }

    def "Fast sort performance test"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final def  fastSortInitTime, fastSortDuration

        when:
            fastSortInitTime = System.nanoTime()
            for (i in 0..< 100_000) {
                Sorting.fastSortStrings(COLLATOR, unsortedNames.clone())
            }
            fastSortDuration = System.nanoTime() - fastSortInitTime

        then:
            println String.format("insertionSortDuration: %s", (double) fastSortDuration / 1_000_000_000)
    }

    def "Fast sort 2 performance test"() {
        given:
            final String[] unsortedNames = ["Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"]
            final def fastSort2InitTime, fastSort2Duration

        when:
            fastSort2InitTime = System.nanoTime()
            for (i in 0..< 100_000) {
                Sorting.fastSortStrings2(COLLATOR, unsortedNames.clone())
            }
            fastSort2Duration = System.nanoTime() - fastSort2InitTime

        then:
            println String.format("insertionSortDuration: %s", (double) fastSort2Duration / 1_000_000_000)
    }
}
