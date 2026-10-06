class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoubleLL {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLL() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add to front - O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add to end - O(1)
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Add at specific index - O(n)
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node current = getNode(index);
        Node newNode = new Node(data);
        Node prevNode = current.prev;

        newNode.next = current;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        current.prev = newNode;

        size++;
    }

    // Remove from front - O(1)
    public void removeFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Remove from end - O(1)
    public void removeLast() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Remove by index - O(n)
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        Node current = getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    // Remove first occurrence of a value - O(n)
    public boolean remove(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Helper: get node at index - O(n)
    // Optimized to walk from whichever end is closer
    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Get value at index - O(n)
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return getNode(index).data;
    }

    // Search for a value - O(n)
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    // Reverse the list - O(n)
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // move to next (which is now prev)
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Print forward
    public void printForward() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    // Print backward
    public void printBackward() {
        Node current = tail;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) sb.append(", ");
            current = current.prev;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addAt(2, 15);

        list.printForward();   // [5, 10, 15, 20, 30]
        list.printBackward();  // [30, 20, 15, 10, 5]

        System.out.println("Get index 2: " + list.get(2)); // 15
        System.out.println("Contains 20: " + list.contains(20)); // true

        list.remove(15);
        list.printForward();   // [5, 10, 20, 30]

        list.removeAt(0);
        list.printForward();   // [10, 20, 30]

        list.removeLast();
        list.printForward();   // [10, 20]

        list.reverse();
        list.printForward();   // [20, 10]

        System.out.println("Size: " + list.size());
    }
}
