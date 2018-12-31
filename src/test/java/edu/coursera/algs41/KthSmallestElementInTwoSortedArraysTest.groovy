package edu.coursera.algs41

import spock.lang.Specification
import spock.lang.Unroll

class KthSmallestElementInTwoSortedArraysTest extends Specification {

    @Unroll
    def 'find k-th smallest element in two sorted arrays, slow with merge two arrays'() {
        expect:
        new KthSmallestElementInTwoSortedArrays().kthSmallestSlow1(a, b, k) == kth

        where:
        a                                            | b                                            | k  || kth
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | [] as Integer[]                              | 1  || 1
        [] as Integer[]                              | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 1  || 1
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 7  || 7
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 10 || 10
    }

    @Unroll
    def 'find k-th smallest element in two sorted arrays, slow without merge two arrays'() {
        expect:
        new KthSmallestElementInTwoSortedArrays().kthSmallestSlow2(a, b, k) == kth

        where:
        a                                            | b                                            | k  || kth
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | [] as Integer[]                              | 1  || 1
        [] as Integer[]                              | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 1  || 1
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 7  || 7
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 10 || 10
    }

    @Unroll
    def 'find k-th smallest element in two sorted arrays, fast'() {
        expect:
        new KthSmallestElementInTwoSortedArrays().kthSmallestFast(a, b, k) == kth

        where:
        a                                            | b                                            | k  || kth
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | [] as Integer[]                              | 1  || 1
        [] as Integer[]                              | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as Integer[] | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 1  || 1
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 5  || 5
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 7  || 7
        [1, 2, 3, 4, 5] as Integer[]                 | [6, 7, 8, 9, 10] as Integer[]                | 10 || 10
    }
}
