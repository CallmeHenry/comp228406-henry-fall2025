import java.sql.*;
import java.util.ArrayList;

public class PlayerData {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USER = "system";
    private static final String PASSWORD = "oracle";

    private Player player;
    private Connection connection;

    public PlayerData(Player player) {
        openConnection();
        this.player = player;
    }

    public PlayerData() {
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

    private int nextPlayerId() {
        int nextAvailableId = 1;
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT MAX(player_id) FROM Player"
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

    public void insertPlayer() {
        try {
            int id = nextPlayerId();
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) " +
                            "VALUES (?,?,?,?,?,?,?)"
            );

            pst.setInt(1, id);
            pst.setString(2, player.getFirstName());
            pst.setString(3, player.getLastName());
            pst.setString(4, player.getAddress());
            pst.setString(5, player.getPostalCode());
            pst.setString(6, player.getProvince());
            pst.setString(7, player.getPhoneNumber());
            pst.executeUpdate();
            pst.close();
            player.setPlayerId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer() {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "UPDATE Player SET first_name = ?, last_name = ?, address = ?, " +
                            "postal_code = ?, province = ?, phone_number = ? " +
                            "WHERE player_id = ?"
            );
            pst.setString(1, player.getFirstName());
            pst.setString(2, player.getLastName());
            pst.setString(3, player.getAddress());
            pst.setString(4, player.getPostalCode());
            pst.setString(5, player.getProvince());
            pst.setString(6, player.getPhoneNumber());
            pst.setInt(7, player.getPlayerId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAllPlayerIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT player_id FROM Player");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}