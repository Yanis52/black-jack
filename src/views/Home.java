package views;

import views.controller.ControlHome;
import javax.swing.*;

public class Home extends BasicPage {

    private ControlHome controller;

    JButton newGameButton = new JButton(textHTML("Nouvelle partie"), new ImageIcon("assets/start_icon1.png"));
    JButton rulesButton = new JButton(textHTML("Regles du jeux"), new ImageIcon("assets/rules_icon.png"));
    JButton exitGameButton = new JButton(textHTML("Quitter"), new ImageIcon("assets/exit_icon.png"));

    public Home() {
        super();
        this.window = new JFrame("BlackJack Game");
        this.window.setSize(1280, 720);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon favIcon = new ImageIcon("assets/logo.png");
        this.window.setIconImage(favIcon.getImage());
        this.contentPane = new JPanel();
        this.window.getContentPane().add(contentPane);

        this.controller = new ControlHome(this, this.window, this.contentPane);

        int height = 50;
        int width = 200;

        newGameButton.setBounds(X_SIZE - 1150, 540, width, height);
        contentPane.add(newGameButton);
        newGameButton.addActionListener((e) -> this.controller.actionLoadGameButton(e));

        rulesButton.setBounds(X_SIZE - 750, 540, width, height);
        rulesButton.addActionListener((e) -> this.controller.actionRulesButton(e));
        contentPane.add(rulesButton);

        exitGameButton.setBounds(X_SIZE - 350, 540, width, height);
        exitGameButton.addActionListener((e) -> this.controller.actionExitButton(e));
        contentPane.add(exitGameButton);
        this.setBackgroundLaunch(this.contentPane);
        this.contentPane.repaint();
        this.window.setVisible(true);

    }

    public Home(JFrame window, JPanel contentPane) {
        super();
        this.contentPane = contentPane;
        this.contentPane.removeAll();

        this.window = window;

        this.controller = new ControlHome(this, this.window, this.contentPane);

        int height = 50;
        int width = 200;

        newGameButton.setBounds(X_SIZE - 1150, 540, width, height);
        newGameButton.addActionListener((e) -> this.controller.actionLoadGameButton(e));
        contentPane.add(newGameButton);

        rulesButton.setBounds(X_SIZE - 750, 540, width, height);
        rulesButton.addActionListener((e) -> this.controller.actionRulesButton(e));
        contentPane.add(rulesButton);

        exitGameButton.setBounds(X_SIZE - 350, 540, width, height);
        exitGameButton.addActionListener((e) -> this.controller.actionExitButton(e));
        contentPane.add(exitGameButton);

        this.setBackgroundLaunch(this.contentPane);
        this.contentPane.repaint();
    }

    public static void main(String[] args) {
        new Home();

    }

}