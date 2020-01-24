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

    def 'merge sort bottom-up'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.mergeBottomUpSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'merge sort bottom-up 1000000'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.mergeBottomUpSort(a)

        then:
        Util.isSorted(a)
    }

    def 'merge sort bottom-up 1000000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        Sorts.mergeBottomUpSort(a)

        then:
        Util.isSorted(a)
    }

    def 'merge sort bottom-up 1000000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.mergeBottomUpSort(a)

        then:
        Util.isSorted(a)
    }

    //

    def 'insertion sort'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.insertionSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'insertion sort 100000'() {
        def a = readInts('input_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.insertionSort(a)

        then:
        Util.isSorted(a)
    }

    def 'insertion sort 100000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert Util.isSorted(a)

        when:
        Sorts.insertionSort(a)

        then:
        Util.isSorted(a)
    }

    def 'insertion sort 100000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.insertionSort(a)

        then:
        Util.isSorted(a)
    }

    //

    def 'selection sort'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.selectionSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'selection sort 100000'() {
        def a = readInts('input_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.selectionSort(a)

        then:
        Util.isSorted(a)
    }

    def 'selection sort 100000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert Util.isSorted(a)

        when:
        Sorts.selectionSort(a)

        then:
        Util.isSorted(a)
    }

    def 'selection sort 100000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.selectionSort(a)

        then:
        Util.isSorted(a)
    }

    def 'selection sort stable'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.selectionStableSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'selection sort stable 100000'() {
        def a = readInts('input_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.selectionStableSort(a)

        then:
        Util.isSorted(a)
    }

    def 'selection sort stable 100000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert Util.isSorted(a)

        when:
        Sorts.selectionStableSort(a)

        then:
        Util.isSorted(a)
    }

    def 'selection sort stable 100000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt').dropRight(900000)
        assert a.length == 100000
        assert !Util.isSorted(a)

        when:
        Sorts.selectionStableSort(a)

        then:
        Util.isSorted(a)
    }

    //

    def 'shell sort'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.shellSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'shell sort 1000000'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.shellSort(a)

        then:
        Util.isSorted(a)
    }

    def 'shell sort 1000000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        Sorts.shellSort(a)

        then:
        Util.isSorted(a)
    }

    def 'shell sort 1000000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.shellSort(a)

        then:
        Util.isSorted(a)
    }

    //

    def 'quick sort'() {
        def a = [1, 3, 5, 7, 9, 0, 2, 4, 6, 8] as Integer[]

        when:
        Sorts.quickSort(a)

        then:
        a.toList() == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def 'quick sort 1000000'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.quickSort(a)

        then:
        Util.isSorted(a)
    }

    def 'quick sort 1000000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        Sorts.quickSort(a)

        then:
        Util.isSorted(a)
    }

    def 'quick sort 1000000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.quickSort(a)

        then:
        Util.isSorted(a)
    }

    def '3 way quick sort'() {
        def a = ['S', 'A', 'M', 'P', 'L', 'E', 'Q', 'U', 'I', 'C', 'K'] as String[]

        when:
        Sorts.quick3waySort(a)

        then:
        a.toList() == ['A', 'C', 'E', 'I', 'K', 'L', 'M', 'P', 'Q', 'S', 'U']
    }

    def '3 way quick sort 1000000'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.quick3waySort(a)

        then:
        Util.isSorted(a)
    }

    def '3 way quick sort 1000000 already sorted'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        Sorts.quick3waySort(a)

        then:
        Util.isSorted(a)
    }

    def '3 way quick sort 1000000 with duplicates'() {
        def a = readInts('input_dup_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        Sorts.quick3waySort(a)

        then:
        Util.isSorted(a)
    }

    private Integer[] readInts(String filename) {
        this.class.classLoader.getResourceAsStream(filename).withReader { input ->
            input.readLines().collect { it as int }
        }
    }
}
