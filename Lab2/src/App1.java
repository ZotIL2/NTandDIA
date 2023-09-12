import java.util.Scanner;

class Lab1 {

    
    public static void main(String[] args) {
        Lab1 obj1 = new Lab1();
        obj1.printPineTree();
        obj1.ArrayCreate();
    }

    private void printPineTree() {
         Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int levelCount = in.nextInt();
        in.close();
        for (int i = 0; i < levelCount; i++) {
            for (int j = 0; j < levelCount - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void ArrayCreate() {
        int rows = 5; 
        int cols = 5; 
        int[][] array = new int[rows][cols];
        int startV = 1; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = startV;
                startV += 3; // Кожен наступний елемент на 3 більший
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}