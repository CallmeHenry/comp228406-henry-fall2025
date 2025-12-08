import java.sql.*;
import java.util.ArrayList;

public class PlayerAndGameData {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USER = "system";
    private static final String PASSWORD = "oracle";

    private PlayerAndGame playerGame;
    private Connection connection;

    public PlayerAndGameData(PlayerAndGame playerGame) {
        openConnection();
        this.playerGame = playerGame;
    }

    public PlayerAndGameData() {
        openConnection();
    }

    private void openConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int nextPlayerGameId() {
        int nextAvailableId = 1;
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT MAX(player_game_id) FROM PlayerAndGame"
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

    public void insertPlayerAndGame() {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO PlayerAndGame (player_game_id, player_id, game_id, playing_date, score) VALUES (?,?,?,?,?)"
            );
            int id = nextPlayerGameId();
            pst.setInt(1, id);
            pst.setInt(2, playerGame.getPlayerId());
            pst.setInt(3, playerGame.getGameId());
            pst.setDate(4, playerGame.getPlayingDate());
            pst.setInt(5, playerGame.getScore());
            pst.executeUpdate();
            pst.close();
            playerGame.setPlayerGameId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> displayReport(int playerId) {
        ArrayList<String[]> rows = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT p.first_name, p.last_name, p.address, p.postal_code, p.province, p.phone_number, " +
                            "g.game_title, pg.playing_date, pg.score " +
                            "FROM PlayerAndGame pg " +
                            "JOIN Player p ON pg.player_id = p.player_id " +
                            "JOIN Game g ON pg.game_id = g.game_id " +
                            "WHERE pg.player_id = ?"
            );
            pst.setInt(1, playerId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rows.add(new String[]{
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("postal_code"),
                        rs.getString("province"),
                        rs.getString("phone_number"),
                        rs.getString("game_title"),
                        rs.getDate("playing_date").toString(),
                        String.valueOf(rs.getInt("score"))
                });
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}