package Proiect;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Polinom {

    ArrayList<Monom> polynom=new ArrayList<Monom>();
    private static DecimalFormat df2 = new DecimalFormat("#.##"); //un format pentru afisarea polinomului integrat cu coeficienti cu 2 zecimale

    public Polinom(ArrayList<Monom> polynom)
    {
        this.polynom=polynom;
    }
    public ArrayList<Monom> getPolynom()
    {
        return polynom;
    }
    public String toString()
    {
        String s="";
        if(this.polynom.size()==0)s="0"; //polinomul e gol
        else for(Monom m : this.polynom)
        {	if(m.getCoeficient()>0)
            s=s+"+"; //coeficient pozitiv, in String se pune plus
            if(m.getCoeficient()==0)
                s=s+"";  //nu mai afisam monomul daca coeficientul e 0
            else
                s=s+(m.getCoeficient()+"x^"+m.getPower());

        }
        return s;
    }
    public static String toStringReal(ArrayList<MonomReal> real)
    {
        String s="";
        if(real.size()==0)s="0";
        else for(MonomReal m : real)
        {	if(m.getCoeficientR()>0)
            s=s+"+";
            if(m.getCoeficientR()==0)
                s=s+"";
            else
                s=s+(df2.format(m.getCoeficientR())+"x^"+m.getPowerR());

        }
        return s;
    }
    public void add(Monom m)
    {
        polynom.add(m);
    }

}