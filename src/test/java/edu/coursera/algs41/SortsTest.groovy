package edu.coursera.algs41

import spock.lang.Specification

class SortsTest extends Specification {
    def 'merge sort'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.mergeSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'merge sort 1000000'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.mergeSort(a)

        then:
        Util.isSorted(a)
    }

    def 'merge sort 1000000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        Sorts.mergeSort(a)

        then:
        Util.isSorted(a)
    }

    def 'merge sort 1000000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.mergeSort(a)

        then:
        Util.isSorted(a)
    }

    private Integer[] readInts(String filename) {
        this.class.classLoader.getResourceAsStream(filename).withReader { input ->
            input.readLines().collect { it as int }
        }
    }
}
