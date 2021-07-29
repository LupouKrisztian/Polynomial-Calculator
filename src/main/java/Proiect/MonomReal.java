package Proiect;

public class MonomReal {
    private double coeficient;
    private int power;
    public MonomReal (double coeficient, int putere)
    {
        this.coeficient=coeficient;
        this.power=putere;
    }
    public double getCoeficientR() {
        return coeficient;
    }

    public int getPowerR() {
        return power;
    }
}
