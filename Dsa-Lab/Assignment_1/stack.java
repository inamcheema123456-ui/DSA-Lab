import java.util.Scanner;

public class stack {
    static int top = -1;
    static int n = 10;
    static int a[] = new int[n];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("------ STACK MENU ------");
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

    static void push() {
        if (top == n - 1) {
            System.out.println("Overflow");
        } else {
            System.out.println("Enter Data:");
            int i = sc.nextInt();
            top = top + 1;
            a[top] = i;
            System.out.println("------ Item is inserted ---------");

        }

    }

    static void pop() {
        if (top == -1) {
            System.out.println("--------Underflow--------");
        } else {
            System.out.println(a[top] + " deleted");
            top = top - 1;
            System.out.println("------- Item Deleted-------");
        }
    }

    static void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Items are:");
        for (int j = top; j >= 0; j--) {
            System.out.println(a[j]);
        }

    }

    static void size() {
            System.out.println("Total items in stack: "+ (top+1));
             System.out.println("Empty space: " +(n-(top+1)));
    }

    static void isEmpty() {
        if(top==-1){
             System.out.println("Yes, Stack is Empty");
        }
        else{
             System.out.println("No, Stack is not empty");
        }

    }

    static void isFull() {
             if(top==n-1){
                 System.out.println("Yes, Stack is full");
             }
             else{
                 System.out.println("No, Stack is not full");
             }
    }

}
