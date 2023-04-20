package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import views.controller.ControlFormulaire;

public class Formulaire extends BasicPage {

    private ControlFormulaire controller;
    public JCheckBox checkVintage = new JCheckBox("Vintage");
    public JCheckBox checkClassique = new JCheckBox("Classique");
    public JLabel label4 = new JLabel("");
    public JLabel label = new JLabel("");
    public Object[] nbJoueurs = new Object[] { 1, 2, 3, 4 };
    public JComboBox<Integer> liste = new JComboBox(nbJoueurs);
    protected JPanel contentPane;

    public Formulaire(JFrame window, JPanel contentPane) {
        super();
        this.window = window;
        this.contentPane = contentPane;
        this.controller = new ControlFormulaire(this, this.window, this.contentPane);
        JButton startButton = new JButton(this.controller.textHTML("Commencer"), new ImageIcon("assets/go_icon.png"));
        JButton returnButton = new JButton(this.controller.textHTML(""), new ImageIcon("assets/return.png"));
        startButton.setBounds(550, 300, 200, 50);
        startButton.addActionListener((e) -> this.controller.actionGoGameButton(e));
        contentPane.add(startButton);

        returnButton.setBounds(1175, 2, 100, 43);
        returnButton.addActionListener((e) -> this.controller.actionReturnGameButton(e));
        contentPane.add(returnButton);

        /*
         * ajout de la JcomboBox pour avoir le nombre de joueur désirés.
         */
        liste.setBounds(550, 80, 200, 50);
        contentPane.add(liste);

        /*
         * creation des checkbox pour la valeur de l'as
         */

        checkVintage.setBounds(560, 180, 80, 15);

        checkClassique.setBounds(650, 180, 83, 15);
        contentPane.add(checkVintage);
        contentPane.add(checkClassique);

        /**
         * options pour la JcomboBox
         */

        label.setForeground(Color.green);
        contentPane.add(label);
        label.setBounds(430, 140, 240, 20);

        JLabel label1 = new JLabel("Options de la partie");
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);
        contentPane.add(label1);
        label1.setBounds(550, 10, 200, 22);

        JLabel label2 = new JLabel("Nombre de joueurs: ");
        label2.setForeground(Color.WHITE);
        contentPane.add(label2);
        label2.setBounds(410, 100, 150, 20);

        JLabel label3 = new JLabel("Style  de paquet : ");
        label3.setForeground(Color.WHITE);
        contentPane.add(label3);
        label3.setBounds(410, 180, 150, 20);

        label4.setForeground(Color.WHITE);
        contentPane.add(label4);
        label4.setBounds(430, 210, 170, 20);

        /*
         * methodes listener
         */

        checkVintage.addItemListener((e) -> this.controller.actionCheckVintageButton(e));
        checkClassique.addItemListener((e) -> this.controller.actionCheckClassiqueButton(e));
        liste.addActionListener((e) -> this.controller.actionListeGameButton(e));

        this.setBackgroundHome(this.contentPane);
        this.contentPane.repaint();
        this.contentPane.revalidate();
    }

}
