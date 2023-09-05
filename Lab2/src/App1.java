import java.util.Scanner;

class Lab1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int levelCount = in.nextInt();
        printPineTree(levelCount);
        in.close();
    }

    private static void printPineTree(int levelCount) {
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
}