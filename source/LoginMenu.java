package tppoao2018;

import javax.swing.*;

public class LoginMenu extends JFrame {

    private JLabel menuString, passwordString, usernameString;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    public LoginMenu() {

        JLabel menuString = new JLabel("Pleaneador de Viagens");
        menuString.setBounds(10, 0, 250, 25);

        JLabel usernameString = new JLabel("Utilizador:");
        usernameString.setBounds(125, 50, 125, 25);

        JTextField usernameField = new JTextField(10);
        usernameField.setBounds(125, 70, 125, 25);

        JLabel passwordString = new JLabel("Password:");
        passwordString.setBounds(250, 50, 125, 25);

        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(250, 70, 125, 25);

        JButton loginButton = new JButton("Entrar");
        loginButton.setBounds(375, 70, 70, 24);

        JButton registerButton = new JButton("Registar");
        registerButton.setBounds(450, 130, 100, 25);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.add(menuString);
        loginPanel.add(usernameString);
        loginPanel.add(usernameField);
        loginPanel.add(passwordString);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        this.add(loginPanel);
        loginPanel.setVisible(true);
    }
}
