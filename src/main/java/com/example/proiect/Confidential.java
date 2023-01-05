package com.example.proiect;

public class Confidential extends Angajat{
    int salar, bonus, concediu;

    public Confidential(){};

    public Confidential(int salar, int bonus, int concediu) {
       // this.angID=angID;
        this.salar = salar;
        this.bonus = bonus;
        this.concediu = concediu;
       // this.nume=nume;
      //  this.prenume=prenume;
    }

    public int addBonus(int n, int bonus){
        int t=n+ bonus;
        return t;
    }

    public int addConcediu(int n, int concediu){
        int c=n+ concediu;
        return c;
    }

    public int CalcSalar(int salar, int bonus){
        int d=salar+bonus;
        return d;
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
