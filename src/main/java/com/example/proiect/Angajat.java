package com.example.proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Angajat extends Departament{
    private StringProperty nume;
    private StringProperty prenume;
    private IntegerProperty angID, deptNr;


    public Angajat() {
        this.nume= new SimpleStringProperty();
        this.prenume=new SimpleStringProperty();
        this.deptNr=new SimpleIntegerProperty();
        this.angID=new SimpleIntegerProperty();
    }

    /**
     * <h1>Clasa Angajat contine datele:</h1>
     * ->nume, prenume angajat<br>
     * ->id-ul si departamentul unde se afla persoana angajata
     */

    public void setAngID(int angID) {
        this.angID.set(angID);
    }
    public void setDeptNr(int deptNr) {
        this.deptNr.set(deptNr);
    }

    public IntegerProperty deptNrProperty() {
        return deptNr;
    }

    public IntegerProperty idProperty() {
        return angID;
    }


}
