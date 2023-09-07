
class Game {

    public static void main(String[] args) {
GameField field = new GameField();
Player player1 = new Player("Хрестик", 'X');
Player player2 = new Player("Нулик", 'O');
field.printField();
while (!field.isWinner(player1.getSymbol()) || !field.isWinner(player2.getSymbol())) {
    
    System.out.println("Ходить гравець Хрестиком:");
    player1.makeMove(field);
    field.printField();
    if(field.isWinner(player1.getSymbol()) ){
        break;
    }
    System.out.println("Ходить гравець Нуликом:");
    player2.makeMove(field);
    field.printField();
}

if (field.isWinner(player1.getSymbol())) {
    System.out.println("Перемiг гравець Хрестик!");
} else {
    System.out.println("Перемiг гравець Нулик!");
}
}
}
