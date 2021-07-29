package Proiect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller implements ActionListener {

    private View view;

    public Controller(View v) {
        this.view = v;
    }

    String pol1, pol2, check = "(\\+|-)+[0-9x]+\\^+[0-9]"; //pattern dupa care se verifica sirul introdus

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.adunare) {
            addPolynoms();
        } else if (e.getSource() == view.scadere) {
            subtractPolynoms();
        } else if (e.getSource() == view.derivare) {
            derivePolynom();
        } else if (e.getSource() == view.inmultire) {
            multiplyPolynoms();
        } else if (e.getSource() == view.clear) {
            clear();
        } else if (e.getSource() == view.integrare) {
            integratePolynom();
        }
    }


    public static ArrayList<Monom> regexChecker(String theRegex, String str2Check) {
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str2Check);
        ArrayList<Monom> pol3 = new ArrayList<Monom>();
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Integer put = Integer.parseInt(str2Check.substring(regexMatcher.end() - 1, regexMatcher.end()));
                Integer coef = Integer.parseInt(str2Check.substring(regexMatcher.start(), regexMatcher.start() + 2));
                Monom m = new Monom(coef, put);
                pol3.add(m);
            }
        }
        return pol3;
    }

    public void addPolynoms() {
        ArrayList<Monom> aux = new ArrayList<Monom>();
        pol1 = view.text1.getText();
        pol2 = view.text2.getText();
        Polinom polynom1 = new Polinom(regexChecker(check, pol1));
        Polinom polynom2 = new Polinom(regexChecker(check, pol2));
        aux = Operatii.adunare(polynom1, polynom2);
        Polinom result_polynom = new Polinom(aux);
        view.text3.setText(result_polynom.toString());
    }

    public void subtractPolynoms() {
        ArrayList<Monom> aux = new ArrayList<Monom>();
        pol1 = view.text1.getText();
        pol2 = view.text2.getText();
        Polinom polynom1 = new Polinom(regexChecker(check, pol1));
        Polinom polynom2 = new Polinom(regexChecker(check, pol2));
        aux = Operatii.scadere(polynom1, polynom2);
        Polinom result_polynom = new Polinom(aux);
        view.text3.setText(result_polynom.toString());
    }

    public void derivePolynom() {
        ArrayList<Monom> aux = new ArrayList<Monom>();
        pol1 = view.text1.getText();
        Polinom polynom1 = new Polinom(regexChecker(check, pol1));
        aux = Operatii.derivare(polynom1);
        Polinom result_polynom = new Polinom(aux);
        view.text3.setText(result_polynom.toString());
    }

    public void integratePolynom() {
        ArrayList<MonomReal> aux = new ArrayList<MonomReal>();
        pol1 = view.text1.getText();
        Polinom polynom1 = new Polinom(regexChecker(check, pol1));
        aux = Operatii.integrare(polynom1);
        String s = Polinom.toStringReal(aux);
        view.text3.setText(s);
    }

    public void multiplyPolynoms() {
        ArrayList<Monom> aux = new ArrayList<Monom>();
        pol1 = view.text1.getText();
        pol2 = view.text2.getText();
        Polinom polynom1 = new Polinom(regexChecker(check, pol1));
        Polinom polynom2 = new Polinom(regexChecker(check, pol2));
        aux = Operatii.produs(polynom1, polynom2);
        Polinom result_polynom = new Polinom(aux);
        view.text3.setText(result_polynom.toString());
    }

    public void clear() {
        view.text1.setText(""); //seteaza TextField-urile cu siruri goale
        view.text2.setText("");
        view.text3.setText("");
    }

}
