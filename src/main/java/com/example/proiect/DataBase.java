package com.example.proiect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
    public Connection con;

    //conexiune la db

    /**
     * <h1>Baza de date.</h1>
     * Am facut o clasa java speciala pentru baza de date pentru
     * a face mai usor conectarea la ea cand este nevoie in alte clase.
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/p3", "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
    public void dbDisconnect() throws SQLException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

}