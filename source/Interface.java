package tppoao2018;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Interface extends JFrame {

    int userID = -1;
    ArrayList<Utilizador> utilizadores = new ArrayList<>();
    ArrayList<Viagem> viagens = new ArrayList<>();
    ArrayList<Local> locais = new ArrayList<>();

    ArrayList<PontoInteresse> pontos = new ArrayList<>();
    private JLabel menuString, passwordString, usernameString, courseString, textString, userString, numberString, sliderString, descriptionString, genericString;
    private JLabel distanceString, costString, distanceValue, costValue;
    private JTextField usernameField, numberField;
    private JPasswordField passwordField;
    private JButton localButton, loginButton, registerButton, backButton, otherBackButton, finishButton, exitButton, planButton, userPrefButton, viewButton, saveButton, logoutButton, addButton, anotherBackButton;
    private JButton saveTripButton, checkLocalButton, goBackButton, addFavouriteButton, addHotButton, checkOtherLocalButton;
    private JComboBox courseList;
    private final JFrame frame;
    private final JPanel panel;
    private JList placeList, pointList, faveList, chosenList;
    private JScrollPane listScroller, pointScroller, faveScroller;
    private JSlider budgetSlider;
    private final ButtonListener buttonActionListener;
    private final SlideListener slideActionListener;
    private int dist;
    private int custo;
    private int budget;
    private int placeID;
    private int pointID;
    DefaultListModel chosenModel;
    DefaultListModel model2 = new DefaultListModel();
    private final int PRICE_MIN = 100;
    private final int PRICE_MAX = 1500;
    private int PRICE_INIT = 100;
    public int conta;

    public Interface() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }

        loadObjectArrayList("Objectos.txt");

        conta = 0;
        frame = new JFrame();
        frame.setTitle("JsLp Trip Planner v0.99");
        frame.setSize(600, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        frame.add(panel);

        buttonActionListener = new ButtonListener();
        slideActionListener = new SlideListener();

        loginMenu();
    }

    public void loadObjectArrayList(String fileString) {
        File file = new File(fileString);

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            utilizadores = (ArrayList<Utilizador>) ois.readObject();
            locais = (ArrayList<Local>) ois.readObject();
            viagens = (ArrayList<Viagem>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException ex) {
            readFile();

        } catch (IOException ex) {
            System.out.println("ERRO: Ficheiro não foi lido com sucesso.");

        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO: Erro a converter objecto.");
        }
    }

    public void saveObjectArrayList(String fileString) {
        File file = new File(fileString);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(viagens);
            oos.writeObject(locais);
            oos.writeObject(utilizadores);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Criação do ficheiro falhou.");
        } catch (IOException ex) {
            System.out.println("ERRO: Escrita no ficheiro falhou.");
        }
    }

    public void loginMenu() {

        menuString = new JLabel("Trip Planner 0.99");
        menuString.setBounds(10, 0, 250, 25);

        usernameString = new JLabel("Utilizador:");
        usernameString.setBounds(125, 50, 125, 25);

        usernameField = new JTextField(10);
        usernameField.setBounds(125, 70, 125, 25);

        passwordString = new JLabel("Password:");
        passwordString.setBounds(250, 50, 125, 25);

        passwordField = new JPasswordField(10);
        passwordField.setBounds(250, 70, 125, 25);

        loginButton = new JButton("Entrar");
        loginButton.setBounds(375, 70, 70, 24);
        loginButton.addActionListener(buttonActionListener);

        registerButton = new JButton("Registar");
        registerButton.setBounds(450, 130, 100, 25);
        registerButton.addActionListener(buttonActionListener);

        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 130, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        frame.setSize(575, 205);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.add(menuString);
        panel.add(usernameString);
        panel.add(usernameField);
        panel.add(passwordString);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);

        panel.setVisible(true);
        frame.setVisible(true);

    }

    public void registerMenu() {
        menuString = new JLabel("Registar novo Utilizador");
        menuString.setBounds(10, 0, 250, 25);

        numberString = new JLabel("Indique o seu nº de estudante:");
        numberString.setBounds(115, 50, 225, 25);
        numberField = new JTextField(10);
        numberField.setBounds(195, 75, 125, 25);

        textString = new JLabel("Escolha um username e password:");
        textString.setBounds(115, 100, 225, 25);

        usernameString = new JLabel("Nome:");
        usernameString.setBounds(145, 125, 125, 25);
        usernameField = new JTextField(10);
        usernameField.setBounds(195, 125, 125, 25);

        passwordString = new JLabel("Password:");
        passwordString.setBounds(120, 150, 125, 25);
        passwordField = new JPasswordField(10);
        passwordField.setBounds(195, 150, 125, 25);

        courseString = new JLabel("Indique o grau onde está inscrito:");
        courseString.setBounds(115, 185, 225, 25);
        String[] courseStrings = {"Licenciatura", "Mestrado"};
        courseList = new JComboBox(courseStrings);
        courseList.setSelectedIndex(0);
        courseList.setBounds(195, 210, 125, 25);

        backButton = new JButton("Anterior");
        backButton.setBounds(115, 285, 100, 25);
        backButton.addActionListener(buttonActionListener);
        finishButton = new JButton("Registar");
        finishButton.setBounds(350, 285, 100, 25);
        finishButton.addActionListener(buttonActionListener);
        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 285, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        frame.setSize(475, 355);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.setLayout(null);
        panel.add(menuString);
        panel.add(textString);
        panel.add(numberString);
        panel.add(courseString);
        panel.add(usernameString);
        panel.add(usernameField);
        panel.add(numberField);
        panel.add(passwordString);
        panel.add(passwordField);
        panel.add(courseList);
        panel.add(backButton);
        panel.add(finishButton);
        panel.add(exitButton);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void welcomeMenu() {

        menuString = new JLabel();
        menuString.setText("Bem vindo, " + utilizadores.get(userID).nome + " [" + utilizadores.get(userID).numeroEstudante + "]");
        menuString.setBounds(10, 0, 250, 25);

        userString = new JLabel("Trip Planner 0.9");
        userString.setBounds(35, 50, 225, 25);

        planButton = new JButton("Planear uma viagem");
        planButton.setBounds(400, 40, 150, 25);
        planButton.addActionListener(buttonActionListener);

        userPrefButton = new JButton("Preferências");
        userPrefButton.setBounds(400, 90, 150, 25);
        userPrefButton.addActionListener(buttonActionListener);

        viewButton = new JButton("Ver destinos");
        viewButton.setBounds(400, 140, 150, 25);
        viewButton.addActionListener(buttonActionListener);

        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 180, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(125, 180, 100, 25);
        logoutButton.addActionListener(buttonActionListener);

        frame.setSize(600, 250);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.add(logoutButton);
        panel.add(menuString);
        panel.add(userString);
        panel.add(planButton);
        panel.add(userPrefButton);
        panel.add(viewButton);
        panel.add(exitButton);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void preferenceMenu() {

        menuString = new JLabel("Preferências");
        menuString.setBounds(10, 0, 250, 25);

        userString = new JLabel();
        userString.setText("Nome: " + utilizadores.get(userID).nome + " [" + utilizadores.get(userID).numeroEstudante + "]");
        userString.setBounds(20, 30, 250, 25);

        descriptionString = new JLabel();
        if (utilizadores.get(userID) instanceof EstLicenciatura) {
            descriptionString.setText("Licenciatura");
            descriptionString.setBounds(20, 45, 250, 25);
        } else {
            descriptionString.setText("Mestrado");
            descriptionString.setBounds(20, 45, 250, 25);
        }

        textString = new JLabel("Orçamento:");
        textString.setBounds(200, 30, 300, 25);

        String[] stringLocais = new String[20];
        for (int i = 0; i < locais.size(); i++) {
            stringLocais[i] = locais.get(i).local;
        }
        placeList = new JList(stringLocais);
        placeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScroller = new JScrollPane(placeList);
        listScroller.setBounds(40, 170, 120, 150);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) placeList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        ListSelectionModel placeModel = placeList.getSelectionModel();
        placeModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    placeID = selectedRow;
                }
            }
        });

        genericString = new JLabel("Escolha ou modifique os seus locais favoritos:");
        genericString.setBounds(20, 120, 300, 25);

        localButton = new JButton("Mostrar Pontos de Int.");
        localButton.setBounds(475, 380, 120, 25);
        localButton.addActionListener(buttonActionListener);

        pointList = new JList();
        pointList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) pointList.getCellRenderer();
        renderer2.setHorizontalAlignment(JLabel.CENTER);
        ListSelectionModel pointModel = pointList.getSelectionModel();
        pointModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    pointID = selectedRow;
                }
            }
        });
        pointScroller = new JScrollPane(pointList);
        pointScroller.setBounds(160, 170, 261, 150);

        faveList = new JList();
        faveList.setModel(model2);
        faveList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) faveList.getCellRenderer();
        renderer3.setHorizontalAlignment(JLabel.CENTER);
        faveScroller = new JScrollPane(faveList);
        faveScroller.setBounds(421, 170, 120, 150);

        checkOtherLocalButton = new JButton("Ver locais");
        checkOtherLocalButton.setBounds(40, 320, 120, 25);
        checkOtherLocalButton.setEnabled(true);
        checkOtherLocalButton.addActionListener(buttonActionListener);

        addFavouriteButton = new JButton("+ Fav.");;
        addHotButton = new JButton("+ Hot");
        addFavouriteButton.setBounds(255, 320, 80, 25);
        addHotButton.setBounds(340, 320, 80, 25);
        addFavouriteButton.addActionListener(buttonActionListener);
        addHotButton.addActionListener(buttonActionListener);
        addFavouriteButton.setEnabled(false);
        addHotButton.setEnabled(false);

        otherBackButton = new JButton("Anterior");
        otherBackButton.setBounds(115, 380, 100, 25);
        otherBackButton.addActionListener(buttonActionListener);

        saveButton = new JButton("Guardar");
        saveButton.setBounds(475, 380, 100, 25);
        saveButton.addActionListener(buttonActionListener);

        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 380, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        budgetSlider = new JSlider(JSlider.HORIZONTAL, PRICE_MIN, PRICE_MAX, PRICE_INIT);
        budgetSlider.setBounds(200, 60, 350, 50);
        budgetSlider.setMajorTickSpacing(150);
        budgetSlider.setMinorTickSpacing(50);
        budgetSlider.setPaintTicks(true);
        budgetSlider.setPaintLabels(true);
        budgetSlider.addChangeListener(slideActionListener);

        sliderString = new JLabel();
        sliderString.setText("€" + PRICE_INIT);
        sliderString.setBounds(270, 30, 300, 25);
        sliderString.setForeground(new Color(50, 50, 50));

        frame.setSize(600, 450);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.add(faveScroller);
        panel.add(addFavouriteButton);
        panel.add(addHotButton);
        panel.add(pointScroller);
        panel.add(checkOtherLocalButton);
        panel.add(menuString);
        panel.add(genericString);
        panel.add(listScroller);
        panel.add(userString);
        panel.add(descriptionString);
        panel.add(exitButton);
        panel.add(saveButton);
        panel.add(otherBackButton);
        panel.add(menuString);
        panel.add(budgetSlider);
        panel.add(sliderString);
        panel.add(textString);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void destinationMenu() {
        menuString = new JLabel("Ver Destinos disponíveis");
        menuString.setBounds(10, 0, 250, 25);

        frame.setSize(600, 450);

        String[] stringLocais = new String[20];
        panel.add(menuString);
        for (int i = 0; i < locais.size(); i++) {
            stringLocais[i] = locais.get(i).local;
        }

        pointList = new JList();
        pointList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pointList.setLayoutOrientation(JList.VERTICAL_WRAP);
        pointList.setVisibleRowCount(-1);
        pointList.setFixedCellWidth(520);
        pointList.setFixedCellHeight(40);
        pointList.setBounds(30, 30, 520, 240);
        DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) pointList.getCellRenderer();
        renderer2.setHorizontalAlignment(JLabel.CENTER);
        pointList.setVisible(false);

        placeList = new JList(stringLocais);
        placeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        placeList.setLayoutOrientation(JList.VERTICAL_WRAP);
        placeList.setVisibleRowCount(-1);
        placeList.setFixedCellWidth(120);
        placeList.setFixedCellHeight(50);
        placeList.setBounds(30, 30, 520, 275);
        placeList.setBorder(BorderFactory.createTitledBorder("Locais"));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) placeList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        ListSelectionModel placeModel = placeList.getSelectionModel();
        placeModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                } else {
                    checkLocalButton.setEnabled(true);
                    int selectedRow = lsm.getMinSelectionIndex();
                    placeID = selectedRow;
                }
            }
        });

        userPrefButton = new JButton("Preferências");
        userPrefButton.setBounds(455, 380, 120, 25);
        userPrefButton.addActionListener(buttonActionListener);

        checkLocalButton = new JButton("Ver detalhes");
        checkLocalButton.setBounds(30, 310, 520, 25);
        checkLocalButton.setEnabled(false);
        checkLocalButton.addActionListener(buttonActionListener);

        goBackButton = new JButton("Voltar atrás");
        goBackButton.setBounds(30, 310, 520, 25);
        goBackButton.setVisible(false);
        goBackButton.addActionListener(buttonActionListener);

        otherBackButton = new JButton("Anterior");
        otherBackButton.setBounds(115, 380, 100, 25);
        otherBackButton.addActionListener(buttonActionListener);

        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 380, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.add(pointList);
        panel.add(goBackButton);
        panel.add(checkLocalButton);
        panel.add(menuString);
        panel.add(userPrefButton);
        panel.add(exitButton);
        panel.add(otherBackButton);
        panel.add(placeList);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void tripMenu() {
        menuString = new JLabel("Planear uma nova Viagem");
        menuString.setBounds(10, 0, 250, 25);

        genericString = new JLabel("Escolha três locais para destinos da viagem:");
        genericString.setBounds(25, 35, 300, 25);

        frame.setSize(600, 450);

        String[] stringLocais = new String[20];
        panel.add(menuString);
        for (int i = 0; i < locais.size(); i++) {
            stringLocais[i] = locais.get(i).local;
        }

        placeList = new JList(stringLocais);
        placeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        placeList.setLayoutOrientation(JList.VERTICAL_WRAP);
        placeList.setVisibleRowCount(-1);
        placeList.setBounds(30, 60, 520, 100);
        placeList.setBorder(BorderFactory.createTitledBorder("Locais Disponíveis"));
        DefaultListCellRenderer placeRenderer = (DefaultListCellRenderer) placeList.getCellRenderer();
        placeRenderer.setHorizontalAlignment(JLabel.CENTER);

        addButton = new JButton("Adicionar Local");
        addButton.setBounds(20, 167, 150, 25);
        addButton.addActionListener(buttonActionListener);

        chosenModel = new DefaultListModel();
        chosenList = new JList(chosenModel);
        chosenList.setLayoutOrientation(JList.VERTICAL_WRAP);
        chosenList.setVisibleRowCount(-1);
        chosenList.setFixedCellWidth(135);
        chosenList.setFixedCellHeight(40);
        chosenList.setBounds(30, 200, 150, 150);
        chosenList.setBorder(BorderFactory.createTitledBorder("Locais Escolhidos"));
        DefaultListCellRenderer chosenRenderer = (DefaultListCellRenderer) chosenList.getCellRenderer();
        chosenRenderer.setHorizontalAlignment(JLabel.CENTER);

        costString = new JLabel("Custo: ");
        costString.setBounds(200, 200, 300, 25);
        costValue = new JLabel("0");
        costValue.setBounds(239, 200, 300, 25);

        distanceString = new JLabel("Distância total: ");
        distanceString.setBounds(200, 220, 300, 25);
        distanceValue = new JLabel("0");
        distanceValue.setBounds(287, 220, 300, 25);

        anotherBackButton = new JButton("Anterior");
        anotherBackButton.setBounds(115, 380, 100, 25);
        anotherBackButton.addActionListener(buttonActionListener);

        exitButton = new JButton("Encerrar");
        exitButton.setBounds(10, 380, 100, 25);
        exitButton.addActionListener(buttonActionListener);

        saveTripButton = new JButton("Finalizar");
        saveTripButton.setBounds(455, 380, 120, 25);
        saveTripButton.addActionListener(buttonActionListener);
        saveTripButton.setEnabled(false);

        panel.removeAll();
        panel.updateUI();
        panel.setLayout(null);

        panel.add(saveTripButton);
        panel.add(distanceValue);
        panel.add(costValue);
        panel.add(distanceString);
        panel.add(costString);
        panel.add(chosenList);
        panel.add(genericString);
        panel.add(menuString);
        panel.add(addButton);
        panel.add(exitButton);
        panel.add(anotherBackButton);
        panel.add(placeList);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void readFile() {
        File file = new File("initfile.txt");

        if (file.exists() && file.isFile() && file.canRead()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splitted = line.split(":");
                    String[] localInfo = splitted[0].split(",");
                    String[] pontos = splitted[1].split(";");
                    PontoInteresse[] listaPontos = new PontoInteresse[pontos.length];
                    for (int i = 0; i < pontos.length; i++) {
                        String[] pontosInfo = pontos[i].split(",");

                        if (Integer.parseInt(pontosInfo[0]) == 1) {//Universidade
                            String[] universidadeInfo = pontosInfo[1].split("-");
                            String[] cursosInfo = universidadeInfo[1].split("_");
                            CursoEngInformatica[] listaCursosEI = new CursoEngInformatica[cursosInfo.length];
                            for (int j = 0; j < listaCursosEI.length; j++) {
                                listaCursosEI[j] = new CursoEngInformatica(cursosInfo[j]);
                            }
                            listaPontos[i] = new Universidade(listaCursosEI, universidadeInfo[0], Float.parseFloat(pontosInfo[2]), Float.parseFloat(pontosInfo[3]));
                            Hora horaIni = new Hora(10, 30);
                            Hora horaFech = new Hora(19, 30);
                            Hora horaIntIni = new Hora(13, 00);
                            Hora horaIntFin = new Hora(14, 00);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioUni = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioUni);

                        } else if (Integer.parseInt(pontosInfo[0]) == 2) {//Museu
                            listaPontos[i] = new Museu(pontosInfo[2], pontosInfo[1], Float.parseFloat(pontosInfo[3]), Float.parseFloat(pontosInfo[4]));
                            Hora horaIni = new Hora(10, 00);
                            Hora horaFech = new Hora(18, 00);
                            Hora horaIntIni = new Hora(12, 0);
                            Hora horaIntFin = new Hora(14, 0);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioMuseu = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioMuseu);

                        } else if (Integer.parseInt(pontosInfo[0]) == 3) {//Bar
                            listaPontos[i] = new Bar(pontosInfo[1], Float.parseFloat(pontosInfo[2]), Float.parseFloat(pontosInfo[3]));
                            Hora horaIni = new Hora(18, 30);
                            Hora horaFech = new Hora(4, 00);
                            Hora horaIntIni = new Hora(19, 30);
                            Hora horaIntFin = new Hora(20, 00);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioBar = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioBar);

                        } else if (Integer.parseInt(pontosInfo[0]) == 4) {//ParqueCultural
                            listaPontos[i] = new Cultural(pontosInfo[2], pontosInfo[1], Float.parseFloat(pontosInfo[3]), Float.parseFloat(pontosInfo[4]));
                            Hora horaIni = new Hora(9, 00);
                            Hora horaFech = new Hora(22, 00);
                            Hora horaIntIni = new Hora(13, 0);
                            Hora horaIntFin = new Hora(14, 0);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioPCult = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioPCult);

                        } else if (Integer.parseInt(pontosInfo[0]) == 5) {//ParqueTematico
                            String[] parqueTEquipamentos = pontosInfo[4].split("-");
                            Equipamento[] listaEquipamentos = new Equipamento[parqueTEquipamentos.length];
                            for (int j = 0; j < parqueTEquipamentos.length; j++) {
                                listaEquipamentos[j] = new Equipamento(parqueTEquipamentos[j]);
                            }
                            listaPontos[i] = new Tematico(pontosInfo[2], Boolean.valueOf(pontosInfo[3]), listaEquipamentos, pontosInfo[1], Float.parseFloat(pontosInfo[5]), Float.parseFloat(pontosInfo[5]));
                            Hora horaIni = new Hora(8, 00);
                            Hora horaFech = new Hora(21, 00);
                            Hora horaIntIni = new Hora(13, 0);
                            Hora horaIntFin = new Hora(14, 0);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioTemat = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioTemat);

                        } else if (Integer.parseInt(pontosInfo[0]) == 6) {//ParqueAquatico
                            String[] parqueAEquipamentos = pontosInfo[4].split("-");
                            Equipamento[] listaEquipamentos = new Equipamento[parqueAEquipamentos.length];
                            for (int j = 0; j < parqueAEquipamentos.length; j++) {
                                listaEquipamentos[j] = new Equipamento(parqueAEquipamentos[j]);
                            }
                            listaPontos[i] = new Aquatico(Boolean.valueOf(pontosInfo[3]), Integer.parseInt(pontosInfo[2]), listaEquipamentos, pontosInfo[1], Float.parseFloat(pontosInfo[5]), Float.parseFloat(pontosInfo[5]));
                            Hora horaIni = new Hora(9, 30);
                            Hora horaFech = new Hora(17, 00);
                            Hora horaIntIni = new Hora(12, 0);
                            Hora horaIntFin = new Hora(14, 0);
                            Intervalo interv = new Intervalo(horaIntIni, horaIntFin);
                            HorarioFuncionamento horarioAquat = new HorarioFuncionamento(horaIni, horaFech, interv);
                            listaPontos[i].setHorarioFunc(horarioAquat);
                        }
                    }
                    ArrayList<PontoInteresse> arrayListPontos = new ArrayList<PontoInteresse>(Arrays.asList(listaPontos));
                    Local local = new Local(localInfo[0], arrayListPontos, Integer.parseInt(localInfo[1]));
                    locais.add(local);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir o fich");
            } catch (IOException ex) {
                System.out.println("ERRO A LER FICH");
            }
        } else {
            System.out.println("FICHEIRO NAO EXISTE");
        }
    }

    private class ButtonListener implements ActionListener {

        int counter = 0;
        int indexer = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {
                int c = 0;
                for (int i = 0; i < utilizadores.size(); i++) {
                    if (utilizadores.get(i).nome.equals(usernameField.getText())) {
                        String passwordString = new String(passwordField.getPassword());
                        if (utilizadores.get(i).password.equals(passwordString)) {
                            JOptionPane.showMessageDialog(null, "SUCESSO: Entrou com sucesso.");
                            c = 1;
                            userID = i;
                            welcomeMenu();

                        }
                    }
                }
                if (c != 1) {
                    JOptionPane.showMessageDialog(null, "ERRO: Credenciais não reconhecidas.");
                }
            } else if (e.getSource() == registerButton) {

                registerMenu();

            } else if (e.getSource() == logoutButton) {
                PRICE_INIT = Math.round(utilizadores.get(userID).getMontanteMax());
                userID = -1;
                loginMenu();

            } else if (e.getSource() == localButton) {
                String selected = (String) placeList.getSelectedValue();
                for (int i = 1; i < locais.size(); i++) {
                    if (locais.get(i).local.equals(selected)) {
                        for (int j = 1; j < locais.get(i).getListaPontos().size(); j++) {
                            String pontoInteresse = locais.get(i).getListaPontos().toString();
                        }
                    }
                }

            } else if (e.getSource() == backButton) {
                loginMenu();

            } else if (e.getSource() == saveButton) {
                utilizadores.get(userID).setMontanteMax(budget);
                JOptionPane.showMessageDialog(null, "SUCESSO: Preferências atualizadas.");
                sliderString.setForeground(new Color(50, 50, 50));

            } else if (e.getSource() == anotherBackButton) {
                chosenModel.removeAllElements();
                counter = 0;
                custo = 0;
                dist = 0;
                indexer = 0;
                dist = 0;
                welcomeMenu();

            } else if (e.getSource() == addButton) {
                counter++;
                chosenModel.add(indexer, placeList.getSelectedValue());
                if (counter == 1) {
                    genericString.setText("Escolha dois locais para destinos da viagem:");
                    dist = 0;

                } else if (counter == 2) {
                    genericString.setText("Escolha mais um local para destinos da viagem:");

                } else if (counter == 3) {
                    genericString.setText("Proceda ao próximo passo.");
                    saveTripButton.setEnabled(true);
                    addButton.setEnabled(false);
                }
                int i;
                String local = (String) placeList.getSelectedValue();
                for (i = 0; i < locais.size(); i++) {
                    String compare = (String) locais.get(i).local;
                    if (compare == local) {
                        dist += Math.abs(dist - locais.get(i).getDistance());
                        distanceValue.setText("Distancia Total: " + dist + "Km");
                        custo += locais.get(i).getCustoTotal();
                        if (utilizadores.get(userID).getMontanteMax() == 0) {
                            costValue.setForeground(new Color(190, 0, 0));
                            costValue.setText("Custo base: €" + custo + " (Ainda não definiu orçamento)");

                        } else if (utilizadores.get(userID).getMontanteMax() < custo) {
                            costValue.setForeground(new Color(190, 0, 0));
                            costValue.setText("Custo base : €" + custo);
                            saveTripButton.setEnabled(false);
                            panel.updateUI();

                        } else {
                            costValue.setForeground(new Color(0, 190, 0));
                            costValue.setText("Custo base: €" + custo);
                        }
                    }
                }
                panel.updateUI();
                indexer++;

            } else if (e.getSource() == otherBackButton) {
                welcomeMenu();

            } else if (e.getSource() == finishButton) {
                for (int i = 0; i < utilizadores.size(); i++) {
                    if (utilizadores.get(i).numeroEstudante.equals(numberField.getText())) {
                        JOptionPane.showMessageDialog(null, "ERRO: Número de estudante já utilizado.");
                        return;
                    }
                }
                String passwordString = new String(passwordField.getPassword());

                if (courseList.getSelectedIndex() == 0) {
                    utilizadores.add(new EstLicenciatura(usernameField.getText(), numberField.getText(), passwordString));
                }
                if (courseList.getSelectedIndex() == 1) {
                    utilizadores.add(new EstMestrado(usernameField.getText(), numberField.getText(), passwordString));
                }
                JOptionPane.showMessageDialog(null, "SUCESSO: Utilizador registado com sucesso.");
                PRICE_INIT = 100;
                loginMenu();

            } else if (e.getSource() == exitButton) {
                saveObjectArrayList("Objectos.txt");
                System.exit(0);

            } else if (e.getSource() == planButton) {
                tripMenu();

            } else if (e.getSource() == addFavouriteButton) {
                for (int i = 0; i < locais.size(); i++) {
                    if (i == placeID) {
                        for (int j = 0; j < locais.get(i).getListaPontos().size(); j++) {
                            if (j == pointID) {
                                model2.addElement(locais.get(i).getListaPontos().get(j).getNome());
                                utilizadores.get(userID).adcPontoPref(locais.get(i).getListaPontos().get(j));
                                utilizadores.get(userID).adcLocalPref(locais.get(i));
                                int temp = locais.get(i).getPopularidade();
                                temp = temp + 1;
                                locais.get(i).setPopularidade(temp);
                                int temp2 = locais.get(i).getListaPontos().get(j).getPopularidade();
                                temp2 = temp2 + 1;
                                locais.get(i).getListaPontos().get(j).setPopularidade(temp2);
                            }
                        }
                    }
                }
                faveList.setModel(model2);
                for (int i = 0; i < locais.size(); i++) {
                    System.out.print(locais.get(i).toString());
                }

            } else if (e.getSource() == addHotButton) {

                for (int i = 0; i < locais.size(); i++) {
                    System.out.println(conta);
                    if (conta == 1) {
                        JOptionPane.showMessageDialog(null, "Já não pode escolher mais pontos Hot!");
                        return;
                    }
                    if (i == placeID) {
                        for (int j = 0; j < locais.get(i).getListaPontos().size(); j++) {
                            if (j == pointID) {
                                model2.addElement(locais.get(i).getListaPontos().get(j).getNome());
                                utilizadores.get(userID).adcPontoPref(locais.get(i).getListaPontos().get(j));
                                utilizadores.get(userID).adcLocalPref(locais.get(i));
                                int temp = locais.get(i).getPopularidade();
                                temp = temp + 10;
                                locais.get(i).setPopularidade(temp);
                                int temp2 = locais.get(i).getListaPontos().get(j).getPopularidade();
                                temp2 = temp2 + 10;
                                locais.get(i).getListaPontos().get(j).setPopularidade(temp2);
                                conta++;
                            }
                        }
                    }
                }
                faveList.setModel(model2);

            } else if (e.getSource() == userPrefButton) {
                preferenceMenu();

            } else if (e.getSource() == saveTripButton) {
                try {
                    String[] locaisAppend = new String[3];
                    int contador = 0;
                    for (int i = 0; i < 3; i++) {
                        locaisAppend[i] = (String) chosenModel.getElementAt(i);
                    }
                    ArrayList<Local> guardar = new ArrayList<>();

                    for (int j = 0; j < locais.size() - 1; j++) {
                        if (contador > 2) {
                            return;

                        }
                        ArrayList<PontoInteresse> pontos = new ArrayList<>();
                        if (locais.get(j).getLocal().equals(locaisAppend[0])) {
                            pontos = (locais.get(j).getListaPontos());
                            contador++;
                        } else if (locais.get(j).getLocal().equals(locaisAppend[1])) {
                            pontos = (locais.get(j).getListaPontos());
                            contador++;
                        } else if (locais.get(j).getLocal().equals(locaisAppend[2])) {
                            pontos = (locais.get(j).getListaPontos());
                            contador++;
                        } else {
                            continue;
                        }

                        for (int p = 0; p < pontos.size(); p++) {
                            PontoInteresse temp;
                            for (int l = p; l < pontos.size() - 1; l++) {
                                int first = pontos.get(p).getPopularidade();
                                int second = pontos.get(l + 1).getPopularidade();
                                if (first < second) {
                                    temp = pontos.get(l + 1);
                                    pontos.set(l + 1, pontos.get(p));
                                    pontos.set(p, temp);
                                }
                            }
                        }

                        ArrayList<PontoInteresse> pontosSave = new ArrayList<>();

                        pontosSave.add(0, pontos.get(0));
                        pontosSave.add(1, pontos.get(1));
                        pontosSave.add(2, pontos.get(2));

                        guardar.add(new Local(locais.get(j).getLocal(), pontosSave, Math.round(locais.get(j).getCustoTotal())));
                    }

                    Viagem voyage = new Viagem(guardar, custo, dist);
                    viagens.add(voyage);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("ERRO: Programa tem falha fatal. Viagens não implementadas totalmente");
                }

            } else if (e.getSource() == viewButton) {
                destinationMenu();

            } else if (e.getSource() == checkLocalButton) {
                placeList.setVisible(false);
                checkLocalButton.setVisible(false);
                goBackButton.setVisible(true);
                DefaultListModel model = new DefaultListModel();
                for (int i = 0; i < locais.size(); i++) {
                    if (i == placeID) {
                        for (int j = 0; j < locais.get(i).getListaPontos().size(); j++) {
                            model.addElement(locais.get(i).getListaPontos().get(j).getNome());
                        }
                    }
                }
                pointList.setModel(model);
                pointList.setVisible(true);

            } else if (e.getSource() == checkOtherLocalButton) {
                DefaultListModel model = new DefaultListModel();
                for (int i = 0; i < locais.size(); i++) {
                    if (i == placeID) {
                        for (int j = 0; j < locais.get(i).getListaPontos().size(); j++) {
                            model.addElement(locais.get(i).getListaPontos().get(j).getNome());
                        }
                    }
                }
                pointList.setModel(model);
                addFavouriteButton.setEnabled(true);
                addHotButton.setEnabled(true);
                pointList.setVisible(true);

            } else if (e.getSource() == goBackButton) {
                pointList.setVisible(false);
                DefaultListModel listModel = (DefaultListModel) pointList.getModel();
                listModel.removeAllElements();
                destinationMenu();
            }

        }
    }

    private class SlideListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            budget = source.getValue();
            sliderString.setForeground(new Color(0, 190, 0));
            sliderString.setText("€" + budget);
            PRICE_INIT = source.getValue();
        }
    }
}
