package gregory;

public class Node {
    public int value;
    public Node next;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (value != node.value) return false;
        if (this.next == null ^ node.next == null) return false;
        return this.next != null ? this.next.value == node.next.value : node.next == null;
    }

    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
