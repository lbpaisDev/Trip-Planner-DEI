package tppoao2018;

import javax.swing.*;

public class RegisterMenu extends JFrame {

    private JLabel menuString;
    private JLabel textString;
    private JLabel courseString;
    private JLabel usernameString;
    private JLabel passwordString;
    private JButton backButton;
    private JButton finishButton;
    private JComboBox courseList;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegisterMenu() {

        JLabel menuString = new JLabel("Registar novo Utilizador");
        menuString.setBounds(10, 0, 250, 25);

        JLabel textString = new JLabel("Escolha um username e password:");
        textString.setBounds(35, 50, 225, 25);

        JLabel usernameString = new JLabel("Nome:");
        usernameString.setBounds(40, 75, 125, 25);

        JTextField usernameField = new JTextField(10);
        usernameField.setBounds(115, 75, 125, 25);

        JLabel passwordString = new JLabel("Password:");
        passwordString.setBounds(40, 100, 125, 25);

        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(115, 100, 125, 25);

        JLabel courseString = new JLabel("Indique o grau onde está inscrito:");
        courseString.setBounds(35, 135, 225, 25);

        String[] courseStrings = {"Licenciatura", "Mestrado"};
        JComboBox courseList = new JComboBox(courseStrings);
        courseList.setSelectedIndex(1);
        courseList.setBounds(115, 160, 125, 25);

        JButton backButton = new JButton("Anterior");
        backButton.setBounds(40, 230, 100, 25);

        JButton finishButton = new JButton("Registar");
        finishButton.setBounds(145, 230, 100, 25);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);
        registerPanel.add(menuString);
        registerPanel.add(textString);
        registerPanel.add(courseString);
        registerPanel.add(usernameString);
        registerPanel.add(usernameField);
        registerPanel.add(passwordString);
        registerPanel.add(courseList);
        registerPanel.add(passwordField);
        registerPanel.add(backButton);
        registerPanel.add(finishButton);

        this.add(registerPanel);
        registerPanel.setVisible(true);
    }
}
