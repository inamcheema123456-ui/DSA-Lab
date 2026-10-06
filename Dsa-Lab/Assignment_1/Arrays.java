import java.util.Scanner;

class Arrays {
    static int[] arr = new int[10];

    static int size = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("------ ARRAY MENU ------");
            System.out.println("1. Add Value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill Array");
            System.out.println("4.Delete Last element");
            System.out.println("5.Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update value at index");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addValue();
                    break;
                case 2:
                    insertAtIndex();
                    break;
                case 3:
                    fillarray();
                    break;
                case 4:
                    deleteLastElement();
                    break;
                case 5:
                    deleteByIndex();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    searchValue();
                    break;
                case 8:
                    getAtSpecificIndex();
                    break;
                case 9:
                    replaceValueAtSpecificIndex();
                    break;
                case 10:
                    showSize();
                    break;
                case 11:
                    System.out.println("---- Exiting ----");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 11);
    }

    static void addValue() {
        if (size == arr.length) {
            System.out.println("Array is Full!");
        } else {
            System.out.println("Enter Value:");
            int val = sc.nextInt();
            arr[size] = val;
            size++;
            System.out.println("------ Value is added -----");
        }
    }

    static void insertAtIndex() {
        if (size == arr.length) {
            System.out.println("Array is full!");
            return;
        }
        System.out.println("Enter index (0 to " + size + ")");
        int index = sc.nextInt();
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        System.out.println("Enter Value:");
        int value = sc.nextInt();

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
        System.out.println("------ Value on index " + index + " is inserted -----  ");

    }

    static void fillarray() {
        if (size == arr.length) {
            System.out.println("Array is full!");
            return;
        }
        System.out.println("Enter remaining " + (arr.length - size) + " values:");
        for (int i = size; i < arr.length; i++) {
            System.out.println("Enter value for index " + i + ":");
            arr[i] = sc.nextInt();
        }
        size = arr.length;
        System.out.println("----- Array filled successfully ------ ");
    }

    static void deleteLastElement() {
        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        size--;
        System.out.println("----- Last element is deleted -----");
    }

    static void deleteByIndex() {
        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        System.out.println("Enter the index you want to delete (0 to " + (size - 1) + ")");
        int index = sc.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("----- Invalid index ----");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("---- value of index " + index + " is deleted -----");
    }

    static void display() {
        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        System.out.print("Array = [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    static void searchValue() {
        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        System.out.println("Enter the value you want to search:");
        int value = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.out.println("----- Value " + value + "is found on index " + i);
                return;
            }

        }
        System.out.println("------ value is not found ------");

    }

    static void getAtSpecificIndex() {
        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        System.out.println("Enter the index  (0 to " + (size - 1) + ")");

        int index = sc.nextInt();
        if (index < 0 || index >= size) {
            System.out.println("----- Invalid index ----");
            return;
        }
        System.out.println("---- Value " + arr[index] + " on index " + index);
    }

    static void replaceValueAtSpecificIndex() {

        if (size == 0) {
            System.out.println("---- Array is empty ------");
            return;
        }
        System.out.println("Enter the index you want to change from (0 to " + (size - 1) + ")");

        int index = sc.nextInt();
        if (index < 0 || index >= size) {
            System.out.println("----- Invalid index ----");
            return;
        }
        System.out.println("Enter new value:");
        int newval = sc.nextInt();
        arr[index] = newval;
        System.out.println("Value is change on index " + index);

    }

    static void showSize() {
        System.out.println("Filled boxes in array= " + size);
        System.out.println("Empty boxes in array: " + (arr.length - size));

    }
}
