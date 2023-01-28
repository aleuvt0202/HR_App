package com.example.proiect;

import javafx.application.Platform;
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

    /**
     * <h1>Pagina principala.</h1>
     * In aceasta pagina se pot observa 3 butoane prin care putem
     * <br>naviga prin aplicatie.
     * @param actionEvent Pentru navigare.
     * @throws IOException
     */
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
        Parent root = FXMLLoader.load(getClass().getResource("Angajati.fxml"));

        Stage window= (Stage) concediu.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }


}
