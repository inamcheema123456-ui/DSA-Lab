import java.lang.reflect.Constructor;
import java.util.*;

public class LinkedList {
   static class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class MyLinkedList {
        private Node head;
        private int size;

        // Constructor
        public MyLinkedList() {
            head = null;
            size = 0;
        }

        // Add to end - O(n)
        public void AddLast(int data) {
            Node Newnode = new Node(data);
            if (head == null) {
                head = Newnode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = Newnode;

            }
            size++;
        }

        // Add to front - O(n)
        public void AddFirst(int data) {
            Node Newnode = new Node(data);
            Newnode.next = head;
            head = Newnode;
            size++;
        }

        // Add at a specific index - O(n)
        public void AddAt(int index, int data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("-------- Invalid Index --------");
            }
            if (index == 0) {
                AddFirst(data);
                return;
            }
            Node Newnode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Newnode.next = current.next;
            current.next = Newnode;
            size++;

        }

        // Remove first occurence of a value - O(n)
        public boolean remove(int data) {
            if (head == null)
                return false;
            if (head.data == data) {
                head = head.next;
                size--;
                return true;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    size--;
                    return true;
                }
                current = current.next;
            }
            return false;

        }
        // Remove by index- O(n)

        public void RemoveAt(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("-------- Invalid Index --------");
            }
            if (index == 0) {
                head = head.next;
                size--;
                return;
            }
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;

        }

        // Get value at index- O(n)
        public int get(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("-------- Invalid Index --------");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;

        }

        // Search for a value- O(n)
        public boolean contains(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data)
                    return true;
                current = current.next;

            }
            return false;
        }

        // Reverse the list- O(n)
        public void reverse() {
            Node prev = null;
            Node current = head;
            while (current != null) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;

            }
            head = prev;
        }
              public int size(){
                return size;
              }
              public boolean isEmpty(){
                return size==0;

              }
              //Print the list- O(n)
              public void printList(){
                Node current = head;
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(current!=null){
                    sb.append(current.data);
                    if(current.next!=null)
                        sb.append(",");
                    current = current.next;

                }
                 sb.append("]");
                 System.out.println(sb.toString());
              }

            }
            
        
              public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                MyLinkedList list = new MyLinkedList();
                list.AddLast(10);
                list.AddLast(20);
                 list.AddLast(30);
                  list.AddFirst(5);
                   list.AddAt(2,15);
                   list.printList();         // [5,10,15,20,30]
                   System.out.println("Get index 2: " +list.get(2));  // 15
                    System.out.println("Contains 20: " +list.contains(20));  // true
                     System.out.println("------ Remove First occurence of value -----");
                    list.remove(15);
                    list.printList();      //[5,10,20,30]
                     System.out.println("------ Remove at index -----");
                    list.RemoveAt(0);
                    list.printList();     //[10,20,30]
                  System.out.println("------ Reverse List -----");
                   list.reverse();
                    list.printList();            //[30,20,10]

                      System.out.println("Size: "+list.size());
              }
            }

