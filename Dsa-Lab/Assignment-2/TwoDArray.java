import java.util.Scanner;

class Arrays2D {

    static int[][] arr = new int[3][3];

    static int size = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n------ 2D ARRAY MENU ------");
            System.out.println("1. Add Value");
            System.out.println("2. Insert at Position");
            System.out.println("3. Fill Array");
            System.out.println("4. Delete Last Element");
            System.out.println("5. Delete by Position");
            System.out.println("6. Display");
            System.out.println("7. Search Value");
            System.out.println("8. Get Value at Position");
            System.out.println("9. Replace/Update Value");
            System.out.println("10. Size");
            System.out.println("11. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addValue();
                    break;

                case 2:
                    insertAtPosition();
                    break;

                case 3:
                    fillArray();
                    break;

                case 4:
                    deleteLastElement();
                    break;

                case 5:
                    deleteByPosition();
                    break;

                case 6:
                    display();
                    break;

                case 7:
                    searchValue();
                    break;

                case 8:
                    getAtSpecificPosition();
                    break;

                case 9:
                    replaceValueAtSpecificPosition();
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


    // 1. Add Value
    static void addValue() {

        if (size == arr.length * arr[0].length) {
            System.out.println("Array is Full!");
            return;
        }

        System.out.println("Enter Value:");
        int value = sc.nextInt();

        int row = size / arr[0].length;
        int col = size % arr[0].length;

        arr[row][col] = value;

        size++;

        System.out.println("------ Value is added ------");
    }


    // 2. Insert at Position
    static void insertAtPosition() {

        if (size == arr.length * arr[0].length) {
            System.out.println("Array is Full!");
            return;
        }

        System.out.println("Enter row (0 to " + (arr.length - 1) + "):");
        int row = sc.nextInt();

        System.out.println("Enter column (0 to " + (arr[0].length - 1) + "):");
        int col = sc.nextInt();

        if (row < 0 || row >= arr.length ||
            col < 0 || col >= arr[0].length) {

            System.out.println("Invalid position!");
            return;
        }

        System.out.println("Enter Value:");
        int value = sc.nextInt();

        int index = row * arr[0].length + col;

        // Shift elements forward
        for (int i = size - 1; i >= index; i--) {

            int oldRow = i / arr[0].length;
            int oldCol = i % arr[0].length;

            int newRow = (i + 1) / arr[0].length;
            int newCol = (i + 1) % arr[0].length;

            arr[newRow][newCol] = arr[oldRow][oldCol];
        }

        arr[row][col] = value;

        size++;

        System.out.println("------ Value is inserted ------");
    }


    // 3. Fill Array
    static void fillArray() {

        if (size == arr.length * arr[0].length) {
            System.out.println("Array is already full!");
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (size < arr.length * arr[0].length) {

                    System.out.println(
                        "Enter value for row " + i +
                        ", column " + j + ":"
                    );

                    arr[i][j] = sc.nextInt();

                    size++;
                }
            }
        }

        System.out.println("----- Array filled successfully -----");
    }


    // 4. Delete Last Element
    static void deleteLastElement() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        size--;

        int row = size / arr[0].length;
        int col = size % arr[0].length;

        arr[row][col] = 0;

        System.out.println("----- Last element is deleted -----");
    }


    // 5. Delete by Position
    static void deleteByPosition() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        System.out.println("Enter row:");
        int row = sc.nextInt();

        System.out.println("Enter column:");
        int col = sc.nextInt();

        if (row < 0 || row >= arr.length ||
            col < 0 || col >= arr[0].length) {

            System.out.println("Invalid position!");
            return;
        }

        int index = row * arr[0].length + col;

        if (index >= size) {
            System.out.println("No value exists at this position!");
            return;
        }

        // Shift elements backward
        for (int i = index; i < size - 1; i++) {

            int currentRow = i / arr[0].length;
            int currentCol = i % arr[0].length;

            int nextRow = (i + 1) / arr[0].length;
            int nextCol = (i + 1) % arr[0].length;

            arr[currentRow][currentCol] =
                    arr[nextRow][nextCol];
        }

        size--;

        int lastRow = size / arr[0].length;
        int lastCol = size % arr[0].length;

        arr[lastRow][lastCol] = 0;

        System.out.println("---- Value is deleted ----");
    }


    // 6. Display
    static void display() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        System.out.println("Array = ");

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (count < size) {
                    System.out.print(arr[i][j] + "\t");
                    count++;
                }
            }

            System.out.println();
        }
    }


    // 7. Search Value
    static void searchValue() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        System.out.println("Enter value you want to search:");
        int value = sc.nextInt();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (count < size && arr[i][j] == value) {

                    System.out.println(
                        "Value " + value +
                        " is found at row " + i +
                        ", column " + j
                    );

                    return;
                }

                count++;
            }
        }

        System.out.println("------ Value is not found ------");
    }


    // 8. Get Value
    static void getAtSpecificPosition() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        System.out.println("Enter row:");
        int row = sc.nextInt();

        System.out.println("Enter column:");
        int col = sc.nextInt();

        if (row < 0 || row >= arr.length ||
            col < 0 || col >= arr[0].length) {

            System.out.println("Invalid position!");
            return;
        }

        int index = row * arr[0].length + col;

        if (index >= size) {
            System.out.println("No value exists at this position!");
            return;
        }

        System.out.println(
            "Value " + arr[row][col] +
            " is at row " + row +
            ", column " + col
        );
    }


    // 9. Replace / Update
    static void replaceValueAtSpecificPosition() {

        if (size == 0) {
            System.out.println("---- Array is empty ----");
            return;
        }

        System.out.println("Enter row:");
        int row = sc.nextInt();

        System.out.println("Enter column:");
        int col = sc.nextInt();

        if (row < 0 || row >= arr.length ||
            col < 0 || col >= arr[0].length) {

            System.out.println("Invalid position!");
            return;
        }

        int index = row * arr[0].length + col;

        if (index >= size) {
            System.out.println("No value exists at this position!");
            return;
        }

        System.out.println("Enter new value:");
        int newValue = sc.nextInt();

        arr[row][col] = newValue;

        System.out.println("Value is updated successfully!");
    }


    // 10. Size
    static void showSize() {

        int total = arr.length * arr[0].length;

        System.out.println("Filled boxes in array = " + size);
        System.out.println("Empty boxes in array = " + (total - size));
        System.out.println("Total boxes = " + total);
    }
}
