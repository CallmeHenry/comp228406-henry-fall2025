import java.sql.*;

public class GameData {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USER = "system";
    private static final String PASSWORD = "oracle";

    private Game game;
    private Connection connection;


    public GameData(Game game) {
        openConnection();
        this.game = game;
    }

    private void openConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int nextGameId() {
        int nextAvailableId = 1;
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT MAX(game_id) FROM Game"
            );
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int max = rs.getInt(1);
                if (!rs.wasNull()) {
                    nextAvailableId = max + 1;
                }
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextAvailableId;
    }

    public void insertGame() {
        try {
            int id = nextGameId();
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Game (game_id, game_title) VALUES (?, ?)"
            );
            pst.setInt(1, id);
            pst.setString(2, game.getGameTitle());
            pst.executeUpdate();
            pst.close();
            game.setGameId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGameId() {
        return game.getGameId();
    }
}