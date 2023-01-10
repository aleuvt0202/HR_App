package com.example.proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Confidential{
    private IntegerProperty idP;
    private IntegerProperty salarP;
    private IntegerProperty bonusP;
    private IntegerProperty concediuP;

    public Confidential(){
        this.idP= new SimpleIntegerProperty();
        this.salarP=new SimpleIntegerProperty();
        this.bonusP=new SimpleIntegerProperty();
        this.concediuP=new SimpleIntegerProperty();
    };

    //angID
    public int getIdP() {
        return idP.get();
    }

    public void setIdP(int idP) {
        this.idP.set(idP);
    }

    public IntegerProperty getIDP() {
        return idP;
    }

    //salar
    public int getSalarP() {
        return salarP.get();
    }

    public void setSalarP(int salarP) {
        this.salarP.set(salarP);

    }

    public IntegerProperty getSP() {
        return salarP;
    }

    //bonus
    public int getBonusP() {
        return bonusP.get();
    }

    public void setBonusP(int bonusP) {
        this.bonusP.set(bonusP);
    }

    public IntegerProperty getBP() {
        return bonusP;
    }

    //concediu
    public int getConcediuP() {
        return concediuP.get();
    }

    public void setConcediuP(int concediuP) {
        this.concediuP.set(concediuP);
    }

    public IntegerProperty getCP() {
        return concediuP;
    }




}
