import java.util.Scanner;

public class QueueUsingLL {

    static Scanner sc = new Scanner(System.in);
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node F = null;
    static Node R = null;
    static int count = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n------ QUEUE MENU ------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter value to enqueue:");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    size();
                    break;

                case 5:
                    System.out.println("isEmpty: " + isEmpty());
                    break;

                case 6:
                    System.out.println("isFull: " + isFull());
                    break;

                case 7:
                    System.out.println("---- Exiting ----");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void enqueue(int value) {

        Node newNode = new Node(value);

        // If Queue is empty
        if (isEmpty()) {

            F = newNode;
            R = newNode;

        } else {

            R.next = newNode;
            R = newNode;
        }

        count++;

        System.out.println(value + " added to the queue");
    }

    static void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Removed Value : " + F.data);

        F = F.next;
        count--;

        // If Queue becomes empty
        if (F == null) {
            R = null;
        }
    }

    static void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue values from front to rear:");

        Node current = F;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    static void size() {

        System.out.println("Queue size : " + count);
    }


    static boolean isEmpty() {

        return F == null;
    }


    
    static boolean isFull() {
    System.out.println("Linked list has no fixed size");
        return false;
    }
}
