package Proiect;

import java.util.ArrayList;

public class Operatii {
    public static ArrayList<Monom> adunare(Polinom poly1 , Polinom poly2)
    {
        ArrayList<Monom> result=new ArrayList<Monom>();
        for( Monom m1 : poly1.getPolynom() )
        {
            for( Monom m2 : poly2.getPolynom() )
            {
                if( m1.getPower() == m2.getPower() )
                {
                    m1.setParcurs( true );
                    m2.setParcurs( true );
                    result.add(new Monom( m1.getCoeficient() + m2.getCoeficient(),m1.getPower()));	// se aduna coeficientii monoamelor de acelasi grad
                }
            }
        }
        for( Monom m1 : poly1.getPolynom() )
        {
            if( m1.getParcurs() == false )  //se parcurg monoamele si se adauga monoamele neparcurse la rezultat
                result.add(m1);
        }
        for( Monom m2 : poly2.getPolynom() )
        {
            if( m2.getParcurs() == false )
                result.add( m2 );
        }
        return result;
    }

    public static ArrayList<Monom> scadere(Polinom poly1 , Polinom poly2)
    {
        ArrayList<Monom> result=new ArrayList<Monom>();
        for( Monom m1 : poly1.getPolynom() )
        {
            for( Monom m2 : poly2.getPolynom() )
            {
                if( m1.getPower() == m2.getPower() )
                {
                    m1.setParcurs( true );
                    m2.setParcurs( true );
                    result.add(new Monom( m1.getCoeficient( ) - m2.getCoeficient( ),m1.getPower( )));		// se scad coeficientii monoamelor de acelasi grad
                }
            }
        }
        for( Monom m1 : poly1.getPolynom() )
        {
            if(m1.getParcurs() == false)     //se parcurg monoamele si se adauga monoamele neparcurse la rezultat
                result.add(m1);
        }
        for( Monom m2 : poly2.getPolynom() )
        {
            if( m2.getParcurs() == false )
                result.add( m2 );
        }
        return result;
    }

    public static ArrayList<Monom> derivare(Polinom poly1)
    {
        ArrayList<Monom> result=new ArrayList<Monom>();
        for( Monom m : poly1.getPolynom() )
        {
            result.add(new Monom(m.getCoeficient()*m.getPower(), m.getPower()-1)); //formula: (coef*X^p)' = coef*p*X^(p-1)
        }
        return result;
    }

    public static ArrayList<MonomReal> integrare(Polinom poly1)
    {
        ArrayList<MonomReal> result=new ArrayList<MonomReal>();
        for( Monom m : poly1.getPolynom() )
        {
            result.add(new MonomReal(((double)m.getCoeficient())/(double)(m.getPower()+1), m.getPower()+1));  //formula: $(coef*X^p)dx = coef/(p+1)*X^(p+1)
        }
        return result;
    }
    public static ArrayList<Monom> produs(Polinom poly1, Polinom poly2)
    {
        ArrayList<Monom> result=new ArrayList<Monom>();
        ArrayList<Monom> result1=new ArrayList<Monom>();
        for( Monom m : poly1.getPolynom() )
        {
            for( Monom n : poly2.getPolynom() )
            {
                result.add(new Monom( m.getCoeficient() * n.getCoeficient(),m.getPower() + n.getPower() )); // se face inmultirea monom cu monom
            }
        }
        for(Monom m : result)
        {	if( m.getParcurs()== false) {    //se parcurge lista rezultata anterior
            m.setParcurs( true );            // monomul e parcurs
            int sum_coef=m.getCoeficient(), pw_crt=m.getPower();
            for(Monom n : result)
                if( m.getPower() == n.getPower() && n.getParcurs() == false ) //lista se mai parcurge si se cauta monoame de acelasi grad
                {	sum_coef=sum_coef+n.getCoeficient(); //se face suma coeficientilor unor monoame de un grad respectiv
                    n.setParcurs( true ); // monomul gasit egal se noteaza parcurs
                }
            result1.add(new Monom(sum_coef,pw_crt));
        }
        }
        return result1;
    }
}
