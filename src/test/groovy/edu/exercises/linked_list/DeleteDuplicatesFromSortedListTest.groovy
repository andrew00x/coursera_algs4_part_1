package edu.exercises.linked_list

import spock.lang.Specification
import spock.lang.Unroll

class DeleteDuplicatesFromSortedListTest extends Specification {
    @Unroll
    def 'delete duplicates from sorted linked list'() {
        given:
        def underTest = new DeleteDuplicatesFromSortedList()

        when:
        def result = underTest.deleteDuplicates(input)

        then:
        result == expected

        where:
        input                     || expected
        createList(1, 1)          || createList(1)
        createList(1, 2, 3, 4, 5) || createList(1, 2, 3, 4, 5)
        createList(1, 1, 2)       || createList(1, 2)
        createList(1, 1, 2, 2)    || createList(1, 2)
        createList(1, 1, 2, 2, 3) || createList(1, 2, 3)
        createList(1, 2, 3, 3)    || createList(1, 2, 3)
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
