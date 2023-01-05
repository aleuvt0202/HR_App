package com.example.proiect;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBase {
    public Connection con;

    //conexiune la db
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/p3", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

}