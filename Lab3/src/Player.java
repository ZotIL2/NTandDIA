public class Player {

    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(GameField field) {
        // запит на місце розташування фігури
        int row = 0;
        int col = 0;  
        System.out.println("Введiть рядок для фiгури:");
        row = Integer.parseInt(System.console().readLine());
    
        System.out.println("Введiть стовпець для фiгури ");
        col = Integer.parseInt(System.console().readLine());
    
       

        // перевірка, чи вільна клітина
        if (field.field[row][col] != ' ') {
            System.out.println("Клiтина зайнята!");
            return;
        }

        // зміна стану ігрового поля
        field.setField(row, col, symbol);
    }
}
