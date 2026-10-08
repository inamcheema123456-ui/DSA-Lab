import java.util.Scanner;

public class CircularQueue {

    static Scanner sc = new Scanner(System.in);

    static int F = -1;
    static int R = -1;

    static int a = 5;
    static int[] queue = new int[a];

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n------ CIRCULAR QUEUE MENU ------");
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

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (F == -1) {
            F = 0;
        }

        R = (R + 1) % a;

        queue[R] = value;

        System.out.println(value + " added to the queue");
    }

    static void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Removed Value: " + queue[F]);

        if (F == R) {
            F = -1;
            R = -1;
        }
        else {
            // Move Front circularly
            F = (F + 1) % a;
        }
    }

    static void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue values from front to rear:");

        int i = F;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == R) {
                break;
            }

            i = (i + 1) % a;
        }

        System.out.println();
    }


    static void size() {

        if (isEmpty()) {
            System.out.println("Queue size: 0");
        }
        else if (R >= F) {
            int count = R - F + 1;
            System.out.println("Queue size: " + count);
        }
        else {
            int count = (a - F) + (R + 1);
            System.out.println("Queue size: " + count);
        }
    }

    static boolean isEmpty() {
        return F == -1;
    }

    static boolean isFull() {
        return (R + 1) % a == F;
    }
}
