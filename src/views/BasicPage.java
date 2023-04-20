package views;

import javax.swing.*;
import java.awt.*;

/**
 * favicon = icone de la fenetre
 * backgroundImage = background du jeux (main menu)
 * contentPane = contenu
 * X_SIZE = largeur de la fenetre de jeux
 * Y_SIZE = hauteur de la fenetre de jeux
 * css = import de fonctionnalités css dans notre content pane
 * startHtml = implémentation de balises (debut)  Html dans le jeux et du css das le html
 * endHtml = implémentation de balises de fin (html)
 */
public class BasicPage {

    JFrame window;
    public JPanel contentPane;
    public static int X_SIZE = 1280;
    public static int Y_SIZE = 720;
    JLabel backgroundImageHome =  new JLabel("", new ImageIcon("assets/fond_deck_main.jpg"), JLabel.CENTER);
    JLabel backgroundImageGame =  new JLabel("", new ImageIcon("assets/fond_deck.png"), JLabel.CENTER);
    JLabel backgroundImage =  new JLabel("", new ImageIcon("assets/fond_deck_main_Home.png"), JLabel.CENTER);

    

    public String css = "    <style>        * {            font-family: Arial;            color: #212121;        }        h1 {            font-style: italic;       }    </style>    ";

    public String startHtml = "<html>" + css + "<h3>";
    public String endHtml = "</h3></html>";

    public BasicPage(){
       
    }
    /**
     * permet d'ajouter et le positionner l'arriere plan du jeux
     */
   

    /**
     * permet d'ajouter et le positionner l'arriere plan du jeux
     */
   
    
    /**
     * permet  de tranformer n'importe quel texte en texte HTML (entre deux balises HTML)
     * @param text
     * @return le texte en mode HTML
     */
    public String textHTML(String text){
        return startHtml + text + endHtml;
    }

    public void dispose(){
        this.window.dispose();
    }

    public void setBackgroundLaunch(JPanel contentPane){
        backgroundImage.setBounds(0, 0, 1280, 720);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(backgroundImage);
        contentPane.repaint();
    }

    public void setBackgroundHome(JPanel contentPane){
        backgroundImageHome.setBounds(0, 0, 1280, 720);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(backgroundImageHome);
        contentPane.repaint();
    }

    public void setBackgroundGame(JPanel contentPane){
        backgroundImageGame.setBounds(0, 0, 1280, 700);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(backgroundImageGame);
        contentPane.repaint();
    }
}
