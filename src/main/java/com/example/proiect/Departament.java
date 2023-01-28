package com.example.proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departament {
    private StringProperty dept;
    private StringProperty locatie;
    private IntegerProperty deptNr;


    public Departament() {
        this.dept= new SimpleStringProperty();
        this.locatie=new SimpleStringProperty();
        this.deptNr=new SimpleIntegerProperty();
    }

    /**
     * <h1>Clasa Departament contine datele:</h1>
     * ->nume departament, locatie si id
     */

    public String getDept() {
        return dept.get();
    }

    public StringProperty deptProperty() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept.set(dept);
    }

    public String getLocatie() {
        return locatie.get();
    }

    public StringProperty locatieProperty() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie.set(locatie);
    }

    public int getDeptNr() {
        return deptNr.get();
    }

    public IntegerProperty deptNrProperty() {
        return deptNr;
    }

    public void setDeptNr(int deptNr) {
        this.deptNr.set(deptNr);
    }
}
