package com.example.proiect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.awt.*;
import java.awt.TextArea;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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
    private Label text1;

    @FXML
    private TableView viz;

    @FXML
    private TableColumn<Confidential, Integer> colID;

    @FXML
    private TableColumn<Confidential, Integer> colSal;

    @FXML
    private TableColumn<Confidential, Integer> colBonus;

    @FXML
    private TableColumn<Confidential, Integer> colConcediu;


    public void inapoi(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logat.fxml"));

        Stage window= (Stage) inapoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }


    public void update(javafx.event.Event actionEvent) throws SQLException, ClassNotFoundException {
        if((id.getText()).equals("")){
            System.out.println("Alo scrie id");
        }
        else{
            DataBase connectionClass = new DataBase();
            Connection connection = connectionClass.getConnection();

            String sql = "update confidential set bonus=?, concediu=? where angID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, Integer.parseInt(id.getText()));
            preparedStatement.setInt(1, Integer.parseInt(bonus.getText()));
            preparedStatement.setInt(2, Integer.parseInt(concediu.getText()));
            preparedStatement.executeUpdate();
            text1.setText("Ati modificat cu succes datele!");
            ObservableList<Confidential> cflist=CalcSalarController.getAll();
            populateTable(cflist);
        }

    }

    public static ObservableList<Confidential> getAll() throws ClassNotFoundException, SQLException {
        DataBase connectionClass = new DataBase();
        Connection connection = connectionClass.getConnection();

        String sql="select * from confidential";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ObservableList<Confidential> cflist=getConf(rs);
            return cflist;
        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Confidential> getConf(ResultSet rs) throws  ClassNotFoundException, SQLException{

        try {
            ObservableList<Confidential> cflist = FXCollections.observableArrayList();
            while (rs.next()) {
                Confidential confidential = new Confidential();
                confidential.setIdP(rs.getInt("angID"));
                confidential.setSalarP(rs.getInt("salar"));
                confidential.setBonusP(rs.getInt("bonus"));
                confidential.setConcediuP(rs.getInt("concediu"));
                cflist.add(confidential);
            }
            return cflist;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception{
        colID.setCellValueFactory(cellData -> cellData.getValue().getIDP().asObject());
        colSal.setCellValueFactory(cellData -> cellData.getValue().getSP().asObject());
        colBonus.setCellValueFactory(cellData -> cellData.getValue().getBP().asObject());
        colConcediu.setCellValueFactory(cellData -> cellData.getValue().getCP().asObject());
        ObservableList<Confidential> cflist= CalcSalarController.getAll();
        populateTable(cflist);
    }

    private void populateTable(ObservableList<Confidential> cflist) {
        viz.setItems(cflist);

    }

}
