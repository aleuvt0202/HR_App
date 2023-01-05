package com.example.proiect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogatController {
    @FXML
    private Button viz;
    @FXML
    private Button calc;
    @FXML
    private Button concediu;


    public void handleComp(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Companie.fxml"));

        Stage window= (Stage) viz.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    public void handleCalc(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CalcSalar.fxml"));

        Stage window= (Stage) viz.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    public void handleAng(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Stage window= (Stage) concediu.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

}
