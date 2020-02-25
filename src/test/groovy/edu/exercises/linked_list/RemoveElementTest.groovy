package edu.exercises.linked_list

import spock.lang.Specification
import spock.lang.Unroll

class RemoveElementTest extends Specification {
    @Unroll
    def 'remove element'() {
        given:
        def underTest = new RemoveElement()

        expect:
        expected == underTest.remove(input, val)

        where:
        input                     | val || expected
        createList(1, 2)          | 1   || createList(2)
        createList(1, 2, 3, 4, 5) | 5   || createList(1, 2, 3, 4)
        createList(1, 2, 3, 4, 5) | 3   || createList(1, 2, 4, 5)
        createList(1, 2, 3, 2, 5) | 2   || createList(1, 3, 5)
    }

    private static def createList(int ... data) {
        assert data != null && data.length > 0
        ListNode head = new ListNode(data[0])
        ListNode cur = head
        for (int i = 1; i < data.length; i++) {
            cur.next = new ListNode(data[i])
            cur = cur.next
        }
        return head
    }
}
