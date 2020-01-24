package algs41

import edu.coursera.algs41.OrderedArrayST
import spock.lang.Specification

class OrderedArraySTTest extends Specification {
    def 'put'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.put(1, 'test')

        then:
        1 == st.size()
        'test' == st.get(1)
    }

    def 'put replaces existed value'() {
        def st = new OrderedArrayST<Integer, String>()
        st.put(1, 'test')

        when:
        st.put(1, 'tset')

        then:
        1 == st.size()
        'tset' == st.get(1)
    }

    def 'put fails when key is null'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.put(null, 'test')

        then:
        thrown IllegalArgumentException
        0 == st.size()
    }

    def 'put fails when value is null'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.put(1, null)

        then:
        thrown IllegalArgumentException
        0 == st.size()
    }

    def 'get on empty symbol table returns null'() {
        when:
        def st = new OrderedArrayST<Integer, String>()

        then:
        !st.get(1)
    }

    def 'get'() {
        def st = new OrderedArrayST<Integer, String>()
        st.put(1, 'test')

        expect:
        result == st.get(key)

        where:
        key || result
        1   || 'test'
        2   || null
    }

    def 'get fails when key is null'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.get(null)

        then:
        thrown IllegalArgumentException
    }

    def 'contains on empty symbol table returns null'() {
        when:
        def st = new OrderedArrayST<Integer, String>()

        then:
        !st.contains(1)
    }

    def 'contains'() {
        def st = new OrderedArrayST<Integer, String>()
        st.put(1, 'test')

        expect:
        result == st.contains(key)

        where:
        key || result
        1   || true
        2   || false
    }

    def 'contains returns false when key is null'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        def key = null

        then:
        !st.contains(key)
    }

    def 'newly created symbol table is empty'() {
        when:
        def st = new OrderedArrayST<Integer, String>()

        then:
        st.isEmpty()
    }

    def 'is empty'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.put(1, 'test')

        then:
        !st.isEmpty()
    }

    def 'size of newly created symbol table is zero'() {
        when:
        def st = new OrderedArrayST<Integer, String>()

        then:
        0 == st.size()
    }

    def 'size'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.put(1, 'test')
        st.put(2, 'test2')

        then:
        2 == st.size()
    }

    def 'delete on empty symbol table'() {
        when:
        def st = new OrderedArrayST<Integer, String>()

        then:
        st.delete(1)
    }

    def 'delete'() {
        def st = new OrderedArrayST<Integer, String>()
        st.put(1, 'test')
        st.put(2, 'test2')
        st.put(3, 'test3')

        when:
        st.delete(1)

        then:
        st.size() == 2
        null == st.get(1)
        'test2' == st.get(2)
        'test3' == st.get(3)
    }

    def 'delete fails when key is null'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        st.delete(null)

        then:
        thrown IllegalArgumentException
    }

    def 'keys'() {
        def st = new OrderedArrayST<Integer, String>()

        when:
        10.times { st.put(it, "test${it}") }
        def keys = []
        st.keys().each { keys << it }

        then:
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] == keys
    }
}
