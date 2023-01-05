package com.example.proiect;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void schimbLogat(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("logat.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void delogare(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/hello-view.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
