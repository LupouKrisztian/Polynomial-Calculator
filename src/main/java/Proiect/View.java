package Proiect;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {

    JTextField text1 = new JTextField(20); //pentru polinomul 1
    JTextField text2 = new JTextField(20); //pentru polinomul 2
    JTextField text3 = new JTextField(20); //rezultat

    JButton adunare = new JButton("Add");  //butoanele
    JButton scadere = new JButton("Subtract");
    JButton derivare = new JButton("Derivative");
    JButton inmultire = new JButton("Multiply");
    JButton clear = new JButton("Clear");
    JButton integrare = new JButton("Integral");


    Controller controller = new Controller(this);

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 160);
        setLocationRelativeTo(null);
        setTitle("POLYNOMIAL CALCULATOR");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        text1.setPreferredSize(new Dimension(150, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 5;
        c.weightx = 0.5;
        text1.setText("Polynom 1");
        panel.add(text1, c);

        text2.setPreferredSize(new Dimension(150, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        text2.setText("Polynom 2");
        panel.add(text2, c);

        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        adunare.addActionListener(controller);
        panel.add(adunare, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        scadere.addActionListener(controller);
        panel.add(scadere, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 1;
        c.gridheight = 2;
        clear.addActionListener(controller);
        panel.add(clear, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 3;
        derivare.addActionListener(controller);
        panel.add(derivare, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        inmultire.addActionListener(controller);
        panel.add(inmultire, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 3;
        integrare.addActionListener(controller);
        panel.add(integrare, c);

        text3.setPreferredSize(new Dimension(150, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 6;
        c.gridx = 0;
        c.gridy = 5;
        panel.add(text3, c);

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String args[]) {
        JFrame frame = new View();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
