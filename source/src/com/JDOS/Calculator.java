package com.JDOS;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Calculator implements ActionListener {
    static JFrame f = new JFrame();
    public static final int Width = 300;
    public static final int Height = 500;

    static JTextField poly = new JTextField("");
    static String last_sym = "oper";

    Calculator() {
        poly.setEnabled(false);
        poly.setBounds(45,100, 200,30);
        poly.setFont(new Font("ARIAL",Font.PLAIN,16));
        poly.setDisabledTextColor(Color.BLACK);
        f.add(poly);


        int x = 30;
        int y = 150;

        for (int i = 8; i >= 0; i--){
            JButton num = new JButton(String.valueOf(i+1));
            num.setActionCommand(String.valueOf(i+1));
            num.addActionListener(this);
            num.setBounds(x,y,50,50);

            x += 51;
            if (i % 3 == 0){
                x = 30;
                y += 51;
            }

            f.add(num);
        }
        JButton num = new JButton(String.valueOf(0));
        num.setActionCommand(String.valueOf(0));
        num.addActionListener(this);
        num.setBounds(81,303,50,50);
        f.add(num);

        String[] opers = {"+", "-", "/", "*"};


        x = 203;
        y = 150;
        for (String k: opers){
            JButton oper = new JButton(k);
            oper.setActionCommand(k);
            oper.addActionListener(this);
            oper.setBounds(x,y,50,50);

            y += 51;

            f.add(oper);
        }
        JButton oper = new JButton("=");
        oper.setActionCommand("=");
        oper.addActionListener(this);
        oper.setBounds(132, 303,50,50);
        f.add(oper);
        JButton opert = new JButton("C");
        opert.setActionCommand("C");
        opert.addActionListener(this);
        opert.setBounds(30, 303,50,50);
        f.add(opert);




        f.setTitle("JDOS Calculator");
        f.setIconImage(new ImageIcon("C:/Program Files/JDOS/resource/icon.png").getImage());
        f.setLayout(null);
        f.setBounds(160,0,Width,Height);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void calc(String mode) {
        if (mode == "detect"){
            String[] d = poly.getText().split(" ");
            if (d.length >= 3){ calc("calc"); }
            return;
        }
        String[] parts = poly.getText().split(" ");

        switch (parts[1]) {
            case ("+") -> poly.setText(String.valueOf(Integer.parseInt(parts[0]) + Integer.parseInt(parts[2])) + " " + parts[3] + " ");
            case ("-") -> poly.setText(String.valueOf(Integer.parseInt(parts[0]) - Integer.parseInt(parts[2])) + " " + parts[3] + " ");
            case ("/") -> poly.setText(String.valueOf(Integer.parseInt(parts[0]) / Integer.parseInt(parts[2])) + " " + parts[3] + " ");
            case ("*") -> poly.setText(String.valueOf(Integer.parseInt(parts[0]) * Integer.parseInt(parts[2])) + " " + parts[3] + " ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ("1") -> {
                poly.setText(poly.getText() + "1");
                last_sym = "num";
                calc("detect");
            }
            case ("2") -> {
                poly.setText(poly.getText() + "2");
                last_sym = "num";
                calc("detect");
            }
            case ("3") -> {
                poly.setText(poly.getText() + "3");
                last_sym = "num";
                calc("detect");
            }
            case ("4") -> {
                poly.setText(poly.getText() + "4");
                last_sym = "num";
                calc("detect");
            }
            case ("5") -> {
                poly.setText(poly.getText() + "5");
                last_sym = "num";
                calc("detect");
            }
            case ("6") -> {
                poly.setText(poly.getText() + "6");
                last_sym = "num";
                calc("detect");
            }
            case ("7") -> {
                poly.setText(poly.getText() + "7");
                last_sym = "num";
                calc("detect");
            }
            case ("8") -> {
                poly.setText(poly.getText() + "8");
                last_sym = "num";
                calc("detect");
            }
            case ("9") -> {
                poly.setText(poly.getText() + "9");
                last_sym = "num";
                calc("detect");
            }
            case ("0") -> {
                poly.setText(poly.getText() + "0");
                last_sym = "num";
                calc("detect");
            }
            case ("+") -> {
                if (last_sym == "oper") {break;}
                poly.setText(poly.getText() + " + ");
                last_sym = "oper";
            }
            case ("-") -> {
                if (last_sym == "oper") {break;}
                poly.setText(poly.getText() + " - ");
                last_sym = "oper";
            }
            case ("/") -> {
                if (last_sym == "oper") {break;}
                poly.setText(poly.getText() + " / ");
                last_sym = "oper";
            }
            case ("*") -> {
                if (last_sym == "oper") {break;}
                poly.setText(poly.getText() + " * ");
                last_sym = "oper";
            }
            case ("=") -> {
                calc("calc");
            }
            case ("C") -> {
                poly.setText("");
            }
        }
    }
}