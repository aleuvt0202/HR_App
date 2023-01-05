package com.example.proiect;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.*;

public class CompanieController {
    @FXML
    private Button inapoi;

    @FXML
    private TableView tabel;
    @FXML
    private TableColumn dept;
    @FXML
    private TableColumn loc;
    @FXML
    private TableColumn id;

    private ObservableList<ObservableList> data;


    public void inapoi(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logat.fxml"));

        Stage window= (Stage) inapoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    public void buildData(){
        data = FXCollections.observableArrayList();
        try{
            DataBase connectionClass = new DataBase();
            Connection connection = connectionClass.getConnection();

            String SQL = "SELECT * from departament";


            ResultSet rs = connection.createStatement().executeQuery(SQL);
            System.out.println(SQL);
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(javafx.scene.control.TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tabel.getColumns().addAll(col);
            }

            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tabel.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
