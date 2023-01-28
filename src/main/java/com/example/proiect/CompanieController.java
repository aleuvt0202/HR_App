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
import javafx.scene.control.*;
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
    private TableColumn<Departament, String> coldept;
    @FXML
    private TableColumn<Departament, String> colloc;
    @FXML
    private TableColumn<Departament, Integer> colnr;
    @FXML
    private Label text;

    @FXML
    private Label nume;
    @FXML
    private Label nr;
    @FXML
    private Label locatie;


    @FXML
    private TextField nume1;
    @FXML
    private TextField loc1;
    @FXML
    private TextField nr1;

    @FXML
    private Button adauga;


    /**
     * <h1>CompanieController:</h1>
     * Acest controler este folosit pentru a vizualiza si aduga departamente ale companiei.
     * @param actionEvent Pentru intoarcerea la pagina principala si adaugarea departamentelor.
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public void inapoi(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logat.fxml"));

        Stage window= (Stage) inapoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    public void adaugare() throws SQLException, ClassNotFoundException {
        if((nume.getText()).equals("")){
            text.setText("Scrie numele departamentului!");
        }
        else{
            DataBase connectionClass = new DataBase();
            Connection connection = connectionClass.getConnection();

            String sql = "insert into dept(dept,deptLoc,deptNr) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nume1.getText());
            preparedStatement.setString(2, loc1.getText());
            preparedStatement.setInt(3, Integer.parseInt(nr1.getText()));
            preparedStatement.executeUpdate();

            text.setText("Ati modificat cu succes datele!");
            ObservableList<Departament> dplist=CompanieController.getAll();
            populateTable(dplist);
        }

    }

    public static ObservableList<Departament> getAll() throws ClassNotFoundException, SQLException {
        DataBase connectionClass = new DataBase();
        Connection connection = connectionClass.getConnection();

        String sql="select * from dept";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ObservableList<Departament> dplist=getDept(rs);
            return dplist;
        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Departament> getDept(ResultSet rs) throws  ClassNotFoundException, SQLException{

        try {
            ObservableList<Departament> dplist = FXCollections.observableArrayList();
            while (rs.next()) {
                Departament departament= new Departament();
                departament.setDept(rs.getString("dept"));
                departament.setLocatie(rs.getString("deptloc"));
                departament.setDeptNr(rs.getInt("deptNr"));
                dplist.add(departament);
            }
            return dplist;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception{
        coldept.setCellValueFactory(cellData -> cellData.getValue().deptProperty());
        colloc.setCellValueFactory(cellData -> cellData.getValue().locatieProperty());
        colnr.setCellValueFactory(cellData -> cellData.getValue().deptNrProperty().asObject());
        ObservableList<Departament> dplist= CompanieController.getAll();
        populateTable(dplist);
    }

    private void populateTable(ObservableList<Departament> dplist) {
        tabel.setItems(dplist);

    }


}
