package com.example.proiect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Angajat extends Departament{
    String nume, prenume, dataAng, angID;

    public Angajat(){};

    public Angajat(String deptNr, String nume, String prenume, String angID, String dataAng) {
        this.deptNr=deptNr;
        this.nume = nume;
        this.prenume = prenume;
        this.angID = angID;
        this.dataAng = dataAng;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDataAng(String dataAng) {
        this.dataAng = dataAng;
    }

    public void setAngID(String angID) {
        this.angID = angID;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDataAng() {
        return dataAng;
    }

    public String getAngID() {
        return angID;
    }


}
