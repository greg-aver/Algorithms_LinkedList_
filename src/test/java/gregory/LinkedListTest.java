package gregory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest {

    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node node5;

    Node node6;
    Node node7;
    Node node8;
    Node node9;
    Node node10;
    Node node11;

    LinkedList linkedListGrowing;
    LinkedList linkedListEmpty;
    LinkedList linkedListRepeat;

    @Before
    public void setUp() {
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        linkedListGrowing = new LinkedList();
        linkedListGrowing.head = node1;
        linkedListGrowing.tail = node5;

        linkedListEmpty = new LinkedList();

        node6 = new Node(6);
        node7 = new Node(7);
        node8 = new Node(8);
        node9 = new Node(6);
        node10 = new Node(6);
        node11 = new Node(8);

        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        linkedListRepeat = new LinkedList();
        linkedListRepeat.head = node6;
        linkedListRepeat.tail = node11;
    }

    @After
    public void tearDown() {
        linkedListEmpty = null;
        linkedListGrowing = null;
        linkedListRepeat = null;
    }

    @Test
    public void addInTailNullElements() {
        LinkedList linkedList = new LinkedList();
        linkedList.head = node1;
        linkedList.tail = node1;

        linkedListEmpty.addInTail(node1);
        assertEquals(linkedList, linkedListEmpty);
    }

    @Test
    public void addInTail1Node() {
        Node node12 = new Node(12);

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node11;
        linkedListTest.tail = node11;
        linkedListTest.addInTail(node12);

        LinkedList linkedListTest2Node = new LinkedList();
        linkedListTest2Node.head = node11;
        linkedListTest2Node.tail = node12;
        node11.next = node12;

        assertEquals(linkedListTest2Node, linkedListTest);
    }

    @Test
    public void findNodeExist() {
        assertEquals(node3, linkedListGrowing.find(3));
        assertEquals(node6, linkedListRepeat.find(6));
    }

    @Test
    public void findNodeNotExist() {
        assertNull(linkedListGrowing.find(100));
    }

    @Test
    public void findAllValue6ShouldNode6Node9Node10() {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node6);
        nodeList.add(node9);
        nodeList.add(node10);

        assertEquals(nodeList, linkedListRepeat.findAll(6));
    }

    @Test
    public void findAllNotExist() {
        assertEquals(new ArrayList<Node>(), linkedListRepeat.findAll(100));
    }

    @Test
    public void removeNodeNotExist() {
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node101.next = node102;
        node102.next = node103;
        node103.next = node104;
        node104.next = node105;

        LinkedList linkedListExpected = new LinkedList();
        linkedListExpected.head = node101;
        linkedListExpected.tail = node105;

        assertFalse(linkedListRepeat.remove(100));
        assertEquals(linkedListExpected, linkedListGrowing);
    }

    @Test
    public void removeNodeHead() {

        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node102.next = node103;
        node103.next = node104;
        node104.next = node105;

        LinkedList linkedListExpected = new LinkedList();
        linkedListExpected.head = node102;
        linkedListExpected.tail = node105;

        assertTrue(linkedListGrowing.remove(1));
        assertEquals(linkedListExpected, linkedListGrowing);
    }

    @Test
    public void removeNodeTail() {
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);

        node101.next = node102;
        node102.next = node103;
        node103.next = node104;

        LinkedList linkedList = new LinkedList();
        linkedList.head = node101;
        linkedList.tail = node104;

        assertTrue(linkedListGrowing.remove(5));
        assertEquals(linkedList, linkedListGrowing);
    }

    @Test
    public void removeNodeMiddle() {
        Node node12 = new Node(1);
        Node node13 = new Node(2);
        Node node14 = new Node(4);
        Node node15 = new Node(5);

        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        LinkedList linkedList = new LinkedList();
        linkedList.head = node12;
        linkedList.tail = node15;

        assertTrue(linkedListGrowing.remove(3));
        assertEquals(linkedList, linkedListGrowing);
    }

    @Test
    public void removeAllElementNotExist() {
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node101.next = node102;
        node102.next = node103;
        node103.next = node104;
        node104.next = node105;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node105;

        linkedListGrowing.removeAll(100);
        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void removeAll_RemoveOnlyHead() {
        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node102.next = node103;
        node103.next = node104;
        node104.next = node105;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node102;
        linkedListTest.tail = node105;

        linkedListGrowing.removeAll(1);

        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void removeAll_RemoveOnlyMiddle1Element() {
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node101.next = node102;
        node102.next = node104;
        node104.next = node105;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node105;

        linkedListGrowing.removeAll(3);

        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void removeAll_RemoveOnlyMiddle13Element() {
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node104 = new Node(4);
        Node node105 = new Node(5);

        node101.next = node102;
        node102.next = node104;
        node104.next = node105;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node105;

        Node node33 = new Node(3);
        Node node333 = new Node(3);

        this.node3.next = node33;
        node33.next = node333;
        node333.next = node4;

        linkedListGrowing.removeAll(3);

        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void removeAll_RemoveOnlyTail() {

        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);
        Node node104 = new Node(4);

        node101.next = node102;
        node102.next = node103;
        node103.next = node104;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node104;

        linkedListGrowing.removeAll(5);

        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void removeAll_1Element_NodeNotExist() {
        Node node = new Node(1);
        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node;
        linkedListTest.tail = node;

        Node node_1 = new Node(1);
        LinkedList linkedList1Node = new LinkedList();
        linkedList1Node.head = node_1;
        linkedList1Node.tail = node_1;

        linkedList1Node.removeAll(100);

        assertEquals(linkedListTest, linkedList1Node);
    }

    //Must find in LinkedList 1 Element

    @Test
    public void removeAll_1Element() {
        Node node = new Node(1);
        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node;
        linkedListTest.tail = node;

        linkedListTest.removeAll(1);

        assertEquals(linkedListTest, linkedListEmpty);
    }

    @Test
    public void removeAll_Empty() {
        Node node = new Node(1);
        LinkedList linkedListActual = new LinkedList();
        linkedListActual.head = node;
        linkedListActual.tail = node;

        linkedListActual.removeAll(1);

        assertEquals(linkedListEmpty, linkedListActual);
    }


    @Test
    public void removeAll_Repeat_removeMiddle3Element() {
        Node node107 = new Node(7);
        Node node108 = new Node(8);
        Node node111 = new Node(8);

        node107.next = node108;
        node108.next = node111;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node107;
        linkedListTest.tail = node111;

        linkedListRepeat.removeAll(6);

        assertEquals(linkedListTest, linkedListRepeat);
    }

    //Repeat
    @Test
    public void removeAll_Repeat_removeMiddleAndTail2Element() {
        Node node106 = new Node(6);
        Node node107 = new Node(7);
        Node node109 = new Node(6);
        Node node100 = new Node(6);

        node106.next = node107;
        node107.next = node109;
        node109.next = node100;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node106;
        linkedListTest.tail = node100;

        linkedListRepeat.removeAll(8);
        assertEquals(linkedListTest, linkedListRepeat);
    }

    @Test
    public void removeAll() {
        Node node101 = new Node(1);
        Node node102 = new Node(1);
        Node node103 = new Node(1);

        node101.next = node102;
        node102.next = node103;

        LinkedList linkedListActual = new LinkedList();
        linkedListActual.head = node101;
        linkedListActual.tail = node103;

        linkedListActual.removeAll(1);
        assertEquals(linkedListEmpty, linkedListActual);

    }

    @Test
    public void clearTailHeadShouldBeNull() {
        linkedListRepeat.clear();
        assertNull(linkedListRepeat.head);
        assertNull(linkedListRepeat.tail);
    }

    @Test
    public void count5Elements() {
        assertEquals(5, linkedListGrowing.count());
        assertEquals(6, linkedListRepeat.count());
    }

    @Test
    public void countNullElements() {
        assertEquals(0, linkedListEmpty.count());
    }

    @Test
    public void insertAfterNull() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);

        node0.next = node101;
        node101.next = node102;
        node102.next = node103;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node0;
        linkedListTest.tail = node103;

        node3.next = null;
        linkedListGrowing.tail = node3;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(null, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void insertAfter1Element() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);

        node101.next = node0;
        node0.next = node102;
        node102.next = node103;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node103;

        node3.next = null;
        linkedListGrowing.tail = node3;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(node1, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }


    @Test
    public void insertAfter1ElemTail() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);

        node101.next = node102;
        node102.next = node103;
        node103.next = node0;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node0;

        node3.next = null;
        linkedListGrowing.tail = node3;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(node3, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }


    @Test
    public void insertAfter1ElementTail() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);

        node101.next = node0;
        node0.next = null;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node0;

        node1.next = null;
        linkedListGrowing.tail = node1;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(node1, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void insertAfterMiddle() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);

        node101.next = node102;
        node102.next = node0;
        node0.next = node103;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node103;

        node3.next = null;
        linkedListGrowing.tail = node3;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(node2, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void insertAfterEmptyList() {
        LinkedList linkedListExpected = new LinkedList();
        node1.next = null;
        linkedListExpected.head = node1;
        linkedListExpected.tail = node1;

        Node node101 = new Node(1);

        linkedListEmpty.insertAfter(null, node101);
        assertEquals(linkedListExpected, linkedListEmpty);
    }

    @Test
    public void insertAfterTail() {
        Node node0 = new Node(100);
        Node node101 = new Node(1);
        Node node102 = new Node(2);
        Node node103 = new Node(3);

        node101.next = node102;
        node102.next = node103;
        node103.next = node0;

        LinkedList linkedListTest = new LinkedList();
        linkedListTest.head = node101;
        linkedListTest.tail = node0;

        node3.next = null;
        linkedListGrowing.tail = node3;
        Node nodeInsert = new Node(100);

        linkedListGrowing.insertAfter(node3, nodeInsert);
        assertEquals(linkedListTest, linkedListGrowing);
    }

    @Test
    public void equalsNode() {
        Node node101 = new Node(1);
        // check next = null
        node101.value = 1;
        node101.next = null;

        node1.next = null;
        assertEquals(node1, node101);

        // check next = Node
        Node node102 = new Node(2);

        node1.next = node2;
        node101.next = node102;

        assertEquals(node1, node101);

        // check Node = null
        node1 = null;
        node101 = null;
        assertEquals(node1, node101);
    }

    @Test
    public void equalsLinkedList() {
        assertFalse(linkedListGrowing.equals(linkedListEmpty));
        assertFalse(linkedListGrowing.equals(linkedListRepeat));
        assertTrue(linkedListEmpty.equals(new LinkedList()));
        assertTrue(linkedListGrowing.equals(linkedListGrowing));
    }

    @Test
    public void equalsLinkedList_SameLength() {
        node6.value = 1;
        node10.next = null;
        linkedListRepeat.tail = node10;
        assertFalse(linkedListGrowing.equals(linkedListRepeat));

    }

    @Test
    public void sumLikedListIfLengthsIsEqual_SumNull() {
        assertEquals(
                linkedListEmpty,
                LinkedList.sumLikedListIfLengthsIsEqual(new LinkedList(), new LinkedList())
        );
    }

    @Test
    public void sumLikedListIfLengthsIsEqual_Sum1Element() {
        node1.next = null;
        node6.next = null;

        linkedListRepeat.tail = node6;
        linkedListGrowing.tail = node1;

        Node node101 = new Node(7);
        LinkedList linkedListExpected = new LinkedList();
        linkedListExpected.head = node101;
        linkedListExpected.tail = node101;

        assertEquals(
                linkedListExpected,
                LinkedList.sumLikedListIfLengthsIsEqual(linkedListGrowing, linkedListRepeat)
        );
    }

    @Test
    public void sumLikedListIfLengthsIsEqual_Sum5Element() {
        node10.next = null;
        linkedListRepeat.tail = node10;

        Node node101 = new Node(7);
        Node node102 = new Node(9);
        Node node103 = new Node(11);
        Node node104 = new Node(10);
        Node node105 = new Node(11);

        node101.next = node102;
        node102.next = node103;
        node103.next = node104;
        node104.next = node105;

        LinkedList linkedListExpected = new LinkedList();
        linkedListExpected.head = node101;
        linkedListExpected.tail = node105;

        LinkedList linkedListActual = LinkedList.sumLikedListIfLengthsIsEqual(linkedListGrowing, linkedListRepeat);

        assertEquals(linkedListExpected, linkedListActual);
        assertEquals(5, linkedListActual.count());
    }

    @Test
    public void sumLikedListIfLengthsIsEqual_DifferentLength() {
        assertEquals(
                linkedListEmpty,
                LinkedList.sumLikedListIfLengthsIsEqual(linkedListGrowing, linkedListRepeat)
        );
    }


}