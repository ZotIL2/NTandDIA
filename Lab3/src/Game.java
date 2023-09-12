import java.sql.*;


class Game {
    public void gameBody(GameField field1, Player player1, Player player2) {
        field1.printField();
        while (!field1.isWinner(player1.getSymbol()) || !field1.isWinner(player2.getSymbol())) {

            System.out.println("Ходить гравець Хрестиком:");
            player1.makeMove(field1);
            field1.printField();
            if (field1.isWinner(player1.getSymbol())) {
                break;
            }
            System.out.println("Ходить гравець Нуликом:");
            player2.makeMove(field1);
            field1.printField();
        }

        if (field1.isWinner(player1.getSymbol())) {
            System.out.println("Перемiг гравець Хрестик!");
        } else {
            System.out.println("Перемiг гравець Нулик!");
        }
    }

    Connection con;

    public void Db() {
        String dbUrl = "jdbc:mysql://localhost:3306/myGame?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = "Mylove19022021";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean Register() {
        String username, password;
        System.out.print("Please register for play\n");
        System.out.print("Input a username: ");
        username = System.console().readLine();
        System.out.print("Input a password: ");
        password = System.console().readLine();
        try {
              Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(
                    "SELECT count(*) FROM users WHERE username='" + username + "' and password='" + password + "';");
            while (rs.next())
                if (rs.getInt(1) == 1) {
                    return true;
                } else{
                    String sql = " insert into users (username, password)" + " values (?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(sql);
                    preparedStmt.setString(1, username);
                    preparedStmt.setString(2, password);
                    preparedStmt.execute();
                    System.out.print("Register success!\n");
                }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean Login() {
        String username, password;
        System.out.print("Please Login for play\n");
        System.out.print("Input a username: ");
        username = System.console().readLine();
        System.out.print("Input a password: ");
        password = System.console().readLine();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT count(*) FROM users WHERE username='" + username + "' and password='" + password + "';");
            while (rs.next())
                if (rs.getInt(1) == 1) {
                    return true;
                } else
                    return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void auth() {
        System.out.print("Create or login for play(use Log or Reg): ");
        String authS = System.console().readLine();
        if (authS.equals("Reg")) {
            if (Register()) {
                System.out.print("The user already exists and you are logged in!\n");
            } else {
                System.out.print("Register Error. Repeat steps!\n");
                Register();
            }
        } else if (authS.equals("Log")) {
                if(!Login()){
                    System.out.print("Invalid data please try again: ");
                    Login();
                }
        }

    }

    public static void main(String[] args) {
        GameField field1 = new GameField();
        Player player1 = new Player("Хрестик", 'X');
        Player player2 = new Player("Нулик", 'O');
        Game GameObj = new Game();
        GameObj.Db();
        GameObj.auth();
        GameObj.gameBody(field1, player1, player2);
        GameObj.close();
    }
}
