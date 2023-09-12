public class App2 {
    public static void main(String[] args) {
       
   
      
       
    }

    // Метод для створення і заповнення двовимірного масиву
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