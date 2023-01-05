package com.example.proiect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {

    @FXML
    private Button login;
    @FXML
    private TextField usernameFXML;
    @FXML
    private TextField passwordFXML;

    @FXML
    private Label eroare;
    private Connection connection;

    @FXML
    public void logat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if(usernameFXML.getText().isBlank()==false || passwordFXML.getText().isBlank()==false){
            DataBase connectionClass = new DataBase();
            Connection connection = connectionClass.getConnection();

            String sql = "select count(1) from users where username = '" + usernameFXML.getText() + "' and password = '"+passwordFXML.getText()+"';";
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    if(rs.getInt(1)==1){

                        //intra pe pagina cand e logat
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logat.fxml"));
                        Parent root2 = (Parent) fxmlLoader.load();
                        LogatController usc = fxmlLoader.getController();
                        Stage stage = new Stage();
                        stage.setTitle("Logat");
                        stage.setScene(new Scene(root2));
                        stage.show();

                        //inchidere
                        Node n = (Node) actionEvent.getSource();
                        Stage st = (Stage) n.getScene().getWindow();
                        st.close();

                    }
                    else{
                        eroare.setText("Nu i bine");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            eroare.setText("Introdu username-ul si parola");
        }



    }
}