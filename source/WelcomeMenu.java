package tppoao2018;

import javax.swing.*;

public class WelcomeMenu extends JFrame {

    private JLabel menuString;
    private JLabel userString;
    private JButton planButton;
    private JButton userPrefButton;
    private JButton viewButton;

    public WelcomeMenu() {

        JLabel menuString = new JLabel("Bem vindo");
        menuString.setBounds(10, 0, 250, 25);

        JLabel userString = new JLabel("Trip Planner 0.1");
        userString.setBounds(35, 50, 225, 25);

        JButton planButton = new JButton("Planear uma viagem");
        planButton.setBounds(400, 50, 150, 25);

        JButton userPrefButton = new JButton("Preferências");
        userPrefButton.setBounds(400, 100, 150, 25);

        JButton viewButton = new JButton("Ver destinos");
        viewButton.setBounds(400, 150, 150, 25);

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.add(menuString);
        welcomePanel.add(userString);
        welcomePanel.add(planButton);
        welcomePanel.add(userPrefButton);
        welcomePanel.add(viewButton);

        this.add(welcomePanel);
        welcomePanel.setVisible(true);
    }

}
