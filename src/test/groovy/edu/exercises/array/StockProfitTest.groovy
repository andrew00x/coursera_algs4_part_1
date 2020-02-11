package edu.exercises.array

import spock.lang.Specification
import spock.lang.Unroll

class StockProfitTest extends Specification {
    @Unroll
    def 'find best stock profit'() {
        given:
        def stockProfit = new StockProfit()

        expect:
        stockProfit.bestProfit(prices) == expected

        where:
        prices                         || expected
        [7, 3, 1, 4, 5, 6, 2] as int[] || 5
        [7, 5, 3, 2, 1] as int[]       || 0
    }

    @Unroll
    def 'find best stock profit with many transactions'() {
        given:
        def underTest = new StockProfit()

        expect:
        underTest.bestProfitManyTransactions(prices) == expected

        where:
        prices                         || expected
        [1, 7, 1, 4, 5, 6, 2] as int[] || 11
        [7, 5, 3, 2, 1] as int[]       || 0
    }
}
