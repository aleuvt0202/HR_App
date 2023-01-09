package com.example.proiect;

public class Confidential extends Angajat{
    int salar, bonus, concediu;

    public Confidential(){};

    public Confidential(String angID, String nume, String prenume,int salar, int bonus, int concediu) {
        this.angID=angID;
        this.salar = salar;
        this.bonus = bonus;
        this.concediu = concediu;
        this.nume=nume;
        this.prenume=prenume;
    }

    public void addBonus(int n, int bonus){
        int t=n+ bonus;
        System.out.println(t);
    }

    public void addConcediu(int n, int concediu){
        int c=n+concediu;
        System.out.println(c);
    }

    public void CalcSalar(int salar, int bonus){
        int d=salar+bonus;
        System.out.println(d);
    };

    @Override
    public String toString() {
        return "Confidential[" +
                "salar=" + salar +
                ", bonus=" + bonus +
                ", concediu=" + concediu +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", andID=" + angID +  ']';
    }

}
