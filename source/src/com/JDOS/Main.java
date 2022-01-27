package com.JDOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    //v1

    static JFrame f = new JFrame();
    public static final int Width = 1080;
    public static final int Height = 720;

    public static void menu_ADD() {
        JMenuBar mb = new JMenuBar();

        JMenu jdos_menu = new JMenu("JDOS");

        JMenuItem quit_jdos_menu = new JMenuItem("Quit");
        quit_jdos_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jdos_menu.add(quit_jdos_menu);

        JMenu programs_menu = new JMenu("Programs");

        JMenuItem calculator_menu = new JMenuItem("Calculator");
        calculator_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator calc = new Calculator();
            }
        });
        programs_menu.add(calculator_menu);


        mb.add(jdos_menu);
        mb.add(programs_menu);
        f.setJMenuBar(mb);
    }

    public static void desktop_icons_ADD() {
        int x = 30;
        int y = 30;

        for (int i = 0; i <= 48; i++) {
            JButton icon = new JButton("none");
            icon.setBounds(x, y, 100, 100);

            if (i == 0) {
                icon.setText("");
                icon.setIcon(new ImageIcon("C:/Program Files/JDOS/resource/icon_calculator.png"));
                icon.setActionCommand(String.valueOf(i+1));
                icon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calculator calc = new Calculator();
                    }
                });
            } else {
                icon.setVisible(false);
            }


            x += 130;
            if ((i % 10 == 0) && (i != 0)) {
                x = 30;
                y += 130;
            }

            f.add(icon);
        }
    }

    public static void main(String[] args) {
        Container c = f.getContentPane();

        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        menu_ADD();
        desktop_icons_ADD();


        f.setTitle("JDOS");
        f.setIconImage(new ImageIcon("C:/Program Files/JDOS/resource/icon.png").getImage());
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(160, 0, Width, Height);
        f.setResizable(false);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}