package gregory;

import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // Проверить tail / head
    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null) {
            return false;
        }
        if (this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }
        Node nodeFirst = this.head;
        Node nodeSecond = this.head.next;
        while (nodeSecond != null) {
            if (nodeSecond.value == _value) {
                nodeFirst.next = nodeSecond.next;
                if (nodeFirst.next == null) {
                    this.tail = nodeFirst;
                }
                return true;
            }
            nodeFirst = nodeSecond;
            nodeSecond = nodeSecond.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        if (this.head == null) {
            return;
        }

        while (this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
                return;
            }
        }
        Node nodeFirst = this.head;
        Node nodeSecond = this.head.next;

        while (nodeSecond != null) {
            if (nodeSecond.value == _value) {
                nodeFirst.next = nodeSecond.next;
            } else {
                nodeFirst = nodeSecond;
            }
            nodeSecond = nodeSecond.next;
        }
        this.tail = nodeFirst;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int i = 0;
        Node node = this.head;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.head == null && _nodeAfter == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }

        if (this.head == null && _nodeAfter != null) {
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }
        Node node = this.head;
        while (node != null) {
            if (_nodeAfter.equals(node)) {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeAfter.next = _nodeToInsert;
                if (_nodeToInsert.next == null) {
                    this.tail = _nodeToInsert;
                }
                return;
            }
            node = node.next;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList that = (LinkedList) o;

        Node nodeThis = this.head;
        Node nodeThat = that.head;

        if (nodeThis == null && nodeThat == null) {
            return true;
        }

        if (nodeThis == null ^ nodeThat == null) {
            return false;
        }

        if (nodeThis.value != nodeThat.value
                || this.tail.value != that.tail.value) {
            return false;
        }

        while (nodeThat != null && nodeThis != null) {
            if (nodeThat.value != nodeThis.value) {
                return false;
            }
            nodeThat = nodeThat.next;
            nodeThis = nodeThis.next;
        }

        if (nodeThat == null ^ nodeThis == null) {
            return false;
        }

        return true;
    }

    public static LinkedList sumLikedListIfLengthsIsEqual(LinkedList list1, LinkedList list2) {
        LinkedList listResult = new LinkedList();

        if (list1.count() != list2.count() || list1.head == null) {
            return listResult;
        }
        Node nodeFirst = list1.head.next;
        Node nodeSecond = list2.head.next;
        Node nodeResult = new Node(list1.head.value + list2.head.value);
        listResult.head = nodeResult;
        while (nodeFirst != null) {
            nodeResult.next = new Node(nodeFirst.value + nodeSecond.value);
            nodeResult = nodeResult.next;
            nodeFirst = nodeFirst.next;
            nodeSecond = nodeSecond.next;
        }
        listResult.tail = nodeResult;
        return listResult;
    }
}
