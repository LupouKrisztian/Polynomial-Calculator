package Proiect;

public class Monom {
    private int coeficient;
    private int power;
    boolean parcurs;  //true- monom parcurs, false- monom neparcurs

    public Monom (int coeficient, int putere)
    {
        this.coeficient=coeficient;
        this.power=putere;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public int getPower() {
        return power;
    }

    public void setParcurs( boolean parcurs )
    {
        this.parcurs = parcurs;
    }
    // folosim metode set si get parcurs pentru a indica daca s-a gasit sau nu un monmom de acelasi grad

    public boolean getParcurs( )
    {
        return parcurs;
    }
}
