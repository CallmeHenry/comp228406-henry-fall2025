package utils;
import java.sql.*;

public class SupabaseConnection {
    private static final String URL = "jdbc:postgresql://aws-0-us-west-2.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.jhduoxhpaoxzsneehdpl";
    private static final String PASSWORD = "bAy02JG4VZNfFAiU";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}