package com.example.proiect;

public class Angajat extends Departament{
    String nume, prenume, dataAng;
    int angID;

    public Angajat(){};

    public Angajat(int deptNr, String nume, String prenume, int angID, String dataAng) {
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

    public void setAngID(int angID) {
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

    public int getAngID() {
        return angID;
    }

    @Override
    public String toString() {
        return "Angajat[" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", andID=" + angID +
                ", dataAng=" + dataAng +
                ", deptNr=" + deptNr  + ']';
    }
}
