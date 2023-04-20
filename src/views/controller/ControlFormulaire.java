package views.controller;

import javax.swing.JFrame;
import blackjack.*;
import cartes.Hand;

import java.awt.event.*;
import java.awt.*;
import views.Home;
import views.GamePage;
import java.awt.Color;
import views.Formulaire;
import javax.swing.*;

public class ControlFormulaire{

    int NB_PLAYERS;
    String style = "";
    JFrame window;
    JPanel contentPane;
    public String css = "    <style>        * {            font-family: Arial;            color: #212121;        }        h1 {            font-style: italic;       }    </style>    ";

    public String startHtml = "<html>" + css + "<h3>";
    public String endHtml = "</h3></html>";

    private Formulaire graphics;
    JLabel backgroundImageHome =  new JLabel("", new ImageIcon("assets/fond_deck_main.jpg"), JLabel.CENTER);


    public ControlFormulaire(Formulaire graphics, JFrame window, JPanel contentPane){
        // Valeur par défaut si l'utilisateur ne sélectionne rien
        this.NB_PLAYERS = 1;
        this.window = window;
        this.graphics = graphics;
        this.contentPane = contentPane;
    }

    public void actionGoGameButton(ActionEvent event) {
        Party p = new Party(11, style);

        for (int i = 0; i < NB_PLAYERS; i++) {
            p.addHand(new Hand());
        }
        //this.window.dispose();
        //this.contentPane.removeAll();
        this.contentPane.removeAll();
        new GamePage(p, this.window, this.contentPane);

        // Utiliser la PARTY, créer nouvelle page
    }

    public void actionReturnGameButton(ActionEvent event) {
        new Home(this.window, this.contentPane);
    }

    /**
     * 
     * methode qui gère l'action sur la check box
     */
    public void actionCheckVintageButton(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            graphics.checkClassique.setEnabled(false);
        } else {
            graphics.checkClassique.setEnabled(true);
        }

        style = "vintage";

        graphics.label4.setForeground(Color.green);
        graphics.label4.setText("le style est maintenant " + style + ".");

    }

    /**
     * methode qui gère l'action sur la check box
     */
    public void actionCheckClassiqueButton(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            graphics.checkVintage.setEnabled(false);
        } else {
            graphics.checkVintage.setEnabled(true);
        }

        style = "classique";

        graphics.label4.setForeground(Color.green);
        graphics.label4.setText("le style est maintenant " + style + ".");

    }

    /**
     * 
     * methode qui gère l'action sur le boutton
     */

    public void actionListeGameButton(ActionEvent event) {
        event.getSource();
        Integer nbPlayer = (Integer) graphics.liste.getSelectedItem();
        NB_PLAYERS = nbPlayer;

        graphics.label.setText("Vous Avez selectionne " + nbPlayer + " joueurs");
    }

    public String textHTML(String text){
        return startHtml + text + endHtml;
    }
   
}
