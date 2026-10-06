import java.util.Scanner;

public class StackUsingLL {

    static Scanner sc = new Scanner(System.in);

    // Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Top of Stack
    static Node top = null;

    // Number of elements
    static int count = 0;


    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n------ STACK MENU ------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    push();
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    size();
                    break;

                case 5:
                    isEmpty();
                    break;

                case 6:
                    isFull();
                    break;

                case 7:
                    System.out.println("------ Exiting -------");
                    break;

                default:
                    System.out.println("------ Invalid Choice ------");
            }

        } while (choice != 7);
    }


    // PUSH
    static void push() {

        System.out.println("Enter Data:");
        int data = sc.nextInt();

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        count++;

        System.out.println("------ Item is inserted ---------");
    }


    // POP
    static void pop() {

        if (top == null) {
            System.out.println("-------- Underflow --------");
            return;
        }

        System.out.println(top.data + " deleted");

        top = top.next;

        count--;

        System.out.println("------- Item Deleted -------");
    }


    // DISPLAY
    static void display() {

        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("Items are:");

        Node current = top;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    // SIZE
    static void size() {

        System.out.println("Total items in stack: " + count);
    }


    // isEmpty
    static void isEmpty() {

        if (top == null) {
            System.out.println("Yes, Stack is Empty");
        } else {
            System.out.println("No, Stack is not empty");
        }
    }


    // isFull
    static void isFull() {

        // Linked List has no fixed size
        System.out.println("No, Stack is not full");
    }
}
