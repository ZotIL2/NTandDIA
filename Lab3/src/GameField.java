public class GameField {

    public char[][] field;

    public GameField() {
        this.field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public void printField() {
        for (int i = 0; i < field.length; i++) {
            System.out.print("|");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setField(int row, int col, char symbol) {
        field[row][col] = symbol;
    }

    public boolean isWinner(char symbol) {
        // перевірка по вертикалі
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                return true;
            }
        }

        // перевірка по горизонталі
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) {
                return true;
            }
        }

        // перевірка по діагоналі
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            return true;
        }

        // перевірка по діагоналі
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
            return true;
        }

        return false;
    }
}
