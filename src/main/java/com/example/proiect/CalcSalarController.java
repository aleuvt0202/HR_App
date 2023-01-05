package com.example.proiect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CalcSalarController {
    @FXML
    private Button adaugare;

    @FXML
    private Button inapoi;
    
    @FXML
    private TextField id;

    @FXML
    private TextField bonus;

    @FXML
    private TextField concediu;

    @FXML
    private TextField err;

    public void inapoi(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logat.fxml"));

        Stage window= (Stage) inapoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }


    public void adaugare(javafx.event.Event actionEvent) throws SQLException {
        if((id.getText()).equals("")){
            System.out.println("Alo scrie id");
        }
        else{
            DataBase connectionClass = new DataBase();
            Connection connection = connectionClass.getConnection();

            bonus.getText();
            id.getText();
            concediu.getText();

            String sql = "update confidential set bonus = 'bonus', concediu='concediu' where angID = 'id';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            concediu.getText();

        }

    }
}