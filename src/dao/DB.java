package dao;

import java.sql.*;

public class DB {
    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;

    public Connection getConnection(){
        String dbURL = "jdbc:postgresql://localhost/gestion_etudiants_db";
        String user = "postgres";
        String pass = "your-password";
        try{
            this.cnx = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connected");
            return this.cnx;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
