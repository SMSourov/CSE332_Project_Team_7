/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assembler;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Sk. Mashrur Sourov
 */
public class Assembler extends JFrame implements ActionListener {

    Container container = getContentPane();

    // Application Label
    JLabel appLabel = new JLabel("Enter instruction");

    JTextField textField = new JTextField();

    String instructionToBinary = "";
    String binaryToHex = "";

    JButton convertButton = new JButton("Convert");
    JButton convertFromFile = new JButton("Convert from file");
    boolean doNotAppend;

    public Assembler() {
        this.setTitle("12-bit Assembly converter");
        this.setBounds(500, 100, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Initailize();
        addActionEvent();
    }

    public void Initailize() {
        container.setLayout(null);
        container.setBackground(new Color(169, 118, 188));

        // Font
        Font fontLarge = new Font("Noto Sans", Font.BOLD, 30);
        Font fontSmall = new Font("Noto Sans", Font.BOLD, 16);

        // Labels
        appLabel.setBounds(52, 82, 272, 56);
        appLabel.setForeground(Color.white);
        appLabel.setFont(fontLarge);
        appLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.appLabel);

        // Text Fields
        textField.setBounds(42, 185, 315, 37);
        textField.setToolTipText("Enter instruction");
        textField.setFont(fontSmall);
        container.add(this.textField);

        // Convert button
        convertButton.setBounds(145, 354, 97, 26);
        convertButton.setHorizontalTextPosition(SwingConstants.CENTER);
        convertButton.setVerticalTextPosition(SwingConstants.CENTER);
        convertButton.setBackground(new Color(255, 255, 255));
        convertButton.setFont(fontSmall);
        convertButton.setFocusPainted(false);
        container.add(this.convertButton);

//        Convert from file button
        convertFromFile.setHorizontalTextPosition(SwingConstants.CENTER);
        convertFromFile.setVerticalTextPosition(SwingConstants.CENTER);
        convertFromFile.setFocusPainted(false);
        convertFromFile.setBounds(100, 460, 200, 26);
        convertFromFile.setBackground(new Color(255, 255, 255));
        convertFromFile.setFont(fontSmall);
        container.add(convertFromFile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String userText;
            doNotAppend = false;

            userText = textField.getText();

//            File fileVerify = new File("instructions.txt");
//            if (!fileVerify.exists()) {
//                System.out.println("The file doesn't exist.");
//                try {
//                    fileVerify.createNewFile();
//                    try ( FileWriter fw = new FileWriter(fileVerify)) {
//                        fw.append("v2.0 raw\n");
//                        fw.close();
//                        System.out.println("The file v2.0 raw is created.");
//                    }
//                } catch (IOException ex) {
//                    System.out.println("Unable to create file.");
//                }
//            } else {
//                System.out.println("The file exist.");
//            }
            // File verification and creation process ends here.
            // If the operation is add, sub, addi, subi, store, load
            System.out.println(userText + "\n");
            String[] splitedText = userText.split(" ");
            if (splitedText[0].equals("add")
                    || splitedText[0].equals("sub")
                    || splitedText[0].equals("addi")
                    || splitedText[0].equals("subi")
                    || splitedText[0].equals("store")
                    || splitedText[0].equals("load")) {
                for (int start = 0; start < splitedText.length; start++) {

                    if (splitedText[start].equalsIgnoreCase("add")) {
                        splitedText[start] = "000";
                    } else if (splitedText[start].equalsIgnoreCase("sub")) {
                        splitedText[start] = "001";
                    } else if (splitedText[start].equalsIgnoreCase("store")) {
                        splitedText[start] = "010";
                    } else if (splitedText[start].equalsIgnoreCase("load")) {
                        splitedText[start] = "011";
                    } else if (splitedText[start].equalsIgnoreCase("addi")) {
                        splitedText[start] = "100";
                    } else if (splitedText[start].equalsIgnoreCase("subi")) {
                        splitedText[start] = "101";
                    } else if (splitedText[start].equalsIgnoreCase("r0")) {
                        splitedText[start] = "000";
                    } else if (splitedText[start].equalsIgnoreCase("r1")) {
                        splitedText[start] = "001";
                    } else if (splitedText[start].equalsIgnoreCase("r2")) {
                        splitedText[start] = "010";
                    } else if (splitedText[start].equalsIgnoreCase("r3")) {
                        splitedText[start] = "011";
                    } else if (splitedText[start].equalsIgnoreCase("r4")) {
                        splitedText[start] = "100";
                    } else if (splitedText[start].equalsIgnoreCase("r5")) {
                        splitedText[start] = "101";
                    } else if (splitedText[start].equalsIgnoreCase("r6")) {
                        splitedText[start] = "110";
                    } else if (splitedText[start].equalsIgnoreCase("r7")) {
                        splitedText[start] = "111";
                    } else if (splitedText[start].equalsIgnoreCase("0")) {
                        splitedText[start] = "000";
                    } else if (splitedText[start].equalsIgnoreCase("1")) {
                        splitedText[start] = "001";
                    } else if (splitedText[start].equalsIgnoreCase("2")) {
                        splitedText[start] = "010";
                    } else if (splitedText[start].equalsIgnoreCase("3")) {
                        splitedText[start] = "011";
                    } else if (splitedText[start].equalsIgnoreCase("4")) {
                        splitedText[start] = "100";
                    } else if (splitedText[start].equalsIgnoreCase("5")) {
                        splitedText[start] = "101";
                    } else if (splitedText[start].equalsIgnoreCase("6")) {
                        splitedText[start] = "110";
                    } else if (splitedText[start].equalsIgnoreCase("7")) {
                        splitedText[start] = "111";
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                        doNotAppend = true;
                    }
                    System.out.println(splitedText[start] + "\n");

                }
                instructionToBinary = splitedText[0] + splitedText[1] + splitedText[2] + splitedText[3];

            } // If the operation is jump
            else if (splitedText[0].equalsIgnoreCase("jump")) {

                if (splitedText[0].equalsIgnoreCase("jump")) {
                    splitedText[0] = "110";

                } else {
                    JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                    doNotAppend = true;
                }
                System.out.println(splitedText[0] + "\n");

                // if the jump instruction has only one digit
                if (splitedText[1].length() == 1) {
                    if (splitedText[1].equals("0")) {
                        splitedText[1] = "000";
                    } else if (splitedText[1].equals("1")) {
                        splitedText[1] = "001";
                    } else if (splitedText[1].equals("2")) {
                        splitedText[1] = "010";
                    } else if (splitedText[1].equals("3")) {
                        splitedText[1] = "011";
                    } else if (splitedText[1].equals("4")) {
                        splitedText[1] = "100";
                    } else if (splitedText[1].equals("5")) {
                        splitedText[1] = "101";
                    } else if (splitedText[1].equals("6")) {
                        splitedText[1] = "110";
                    } else if (splitedText[1].equals("7")) {
                        splitedText[1] = "111";
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                        doNotAppend = true;
                    }
                    splitedText[1] = "000000" + splitedText[1];
                    System.out.println(splitedText[1] + "\n");
                } // If the jump instruction has 2 digit
                else if (splitedText[1].length() == 2) {
                    String[] temp = new String[2];
                    for (int start = 0; start < splitedText[1].length(); start++) {
                        char c = getCharFromString(splitedText[1], start);
                        System.out.println("Viewing the character");
                        System.out.println(c);
//                        System.out.println("Character viewed.");
                        if (c == '0') {
                            temp[start] = "000";
                        } else if (c == '1') {
                            temp[start] = "001";
                        } else if (c == '2') {
                            temp[start] = "010";
                        } else if (c == '3') {
                            temp[start] = "011";
                        } else if (c == '4') {
                            temp[start] = "100";
                        } else if (c == '5') {
                            temp[start] = "101";
                        } else if (c == '6') {
                            temp[start] = "110";
                        } else if (c == '7') {
                            temp[start] = "111";
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                            doNotAppend = true;
                        }
                    }
                    splitedText[1] = "000" + temp[0] + temp[1];
                    System.out.println(splitedText[1] + "\n");
                } // If the jump instruction has 3 digitss
                else if (splitedText[1].length() == 3) {
                    String[] temp = new String[3];
                    for (int start = 0; start < splitedText[1].length(); start++) {
                        char c = getCharFromString(splitedText[1], start);
                        System.out.println("Viewing the character");
                        System.out.println(c);
//                        System.out.println("Character viewed.");
                        if (c == '0') {
                            temp[start] = "000";
                        } else if (c == '1') {
                            temp[start] = "001";
                        } else if (c == '2') {
                            temp[start] = "010";
                        } else if (c == '3') {
                            temp[start] = "011";
                        } else if (c == '4') {
                            temp[start] = "100";
                        } else if (c == '5') {
                            temp[start] = "101";
                        } else if (c == '6') {
                            temp[start] = "110";
                        } else if (c == '7') {
                            temp[start] = "111";
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                            doNotAppend = true;
                        }
                    }

                    splitedText[1] = temp[0] + temp[1] + temp[2];
                    System.out.println(splitedText[1] + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                    doNotAppend = true;
                }
                instructionToBinary = splitedText[0] + splitedText[1];

            } else {
                System.out.println("Invalid instruction");
            }

            // temporarily hold each 4 bits of instructionToBinary
            char[] ch = new char[4];
            String[] temp = new String[3];
            instructionToBinary.getChars(0, 4, ch, 0);
            temp[0] = new String(ch);
            instructionToBinary.getChars(4, 8, ch, 0);
            temp[1] = new String(ch);
            instructionToBinary.getChars(8, 12, ch, 0);
            temp[2] = new String(ch);
//            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);

            // convert the temporary values to hexadecimal
            for (int start = 0; start < temp.length; start++) {
                if (temp[start].equalsIgnoreCase("0000")) {
                    temp[start] = "0";
                } else if (temp[start].equalsIgnoreCase("0001")) {
                    temp[start] = "1";
                } else if (temp[start].equalsIgnoreCase("0010")) {
                    temp[start] = "2";
                } else if (temp[start].equalsIgnoreCase("0011")) {
                    temp[start] = "3";
                } else if (temp[start].equalsIgnoreCase("0100")) {
                    temp[start] = "4";
                } else if (temp[start].equalsIgnoreCase("0101")) {
                    temp[start] = "5";
                } else if (temp[start].equalsIgnoreCase("0110")) {
                    temp[start] = "6";
                } else if (temp[start].equalsIgnoreCase("0111")) {
                    temp[start] = "7";
                } else if (temp[start].equalsIgnoreCase("1000")) {
                    temp[start] = "8";
                } else if (temp[start].equalsIgnoreCase("1001")) {
                    temp[start] = "9";
                } else if (temp[start].equalsIgnoreCase("1010")) {
                    temp[start] = "a";
                } else if (temp[start].equalsIgnoreCase("1011")) {
                    temp[start] = "b";
                } else if (temp[start].equalsIgnoreCase("1100")) {
                    temp[start] = "c";
                } else if (temp[start].equalsIgnoreCase("1101")) {
                    temp[start] = "d";
                } else if (temp[start].equalsIgnoreCase("1110")) {
                    temp[start] = "e";
                } else if (temp[start].equalsIgnoreCase("1111")) {
                    temp[start] = "f";
                }

                binaryToHex += temp[start];
                System.out.println(temp[start]);
            }

            System.out.println(instructionToBinary);
            System.out.println(binaryToHex);
//            if (!doNotAppend){
//                try (FileWriter fw = new FileWriter(fileVerify)){
//                    fw.append(binaryToHex + " ");
//                    fw.close();
//                } catch (IOException ex) {
//                    System.out.println("Unable to append file.");;
//                }
//            }
//            File fileVerify = new File("instructions.txt");
//            if (!fileVerify.exists()) {
//                System.out.println("The file doesn't exist.");
//                try {
//                    fileVerify.createNewFile();
//                    try ( FileWriter fw = new FileWriter(fileVerify)) {
//                        fw.append("v2.0 raw\n");
//                        fw.close();
//                        System.out.println("The file v2.0 raw is created.");
//                    }
//                } catch (IOException ex) {
//                    System.out.println("Unable to create file.");
//                }
//            } else {
//                System.out.println("The file exist.");
//            }

            File file = new File("instructions.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    try ( FileWriter fw = new FileWriter(file)) {
                        fw.write("v2.0 raw\n" + binaryToHex + " ");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.exists()) {
                try {
                    FileWriter fw = new FileWriter(file, true);
                    try ( BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write(binaryToHex + " ");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            binaryToHex = "";
        }

        
        
        
        
        
        
        
        
        
        
        
        if (e.getSource() == convertFromFile) {
            String userText;
            doNotAppend = false;

            File inputFile = new File("input.txt");
            try {
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
                userText = br.readLine();
                while (userText != null) {
                    System.out.println(userText + "\n");
                    String[] splitedText = userText.split(" ");
                    if (splitedText[0].equals("add")
                            || splitedText[0].equals("sub")
                            || splitedText[0].equals("addi")
                            || splitedText[0].equals("subi")
                            || splitedText[0].equals("store")
                            || splitedText[0].equals("load")) {
                        for (int start = 0; start < splitedText.length; start++) {

                            if (splitedText[start].equalsIgnoreCase("add")) {
                                splitedText[start] = "000";
                            } else if (splitedText[start].equalsIgnoreCase("sub")) {
                                splitedText[start] = "001";
                            } else if (splitedText[start].equalsIgnoreCase("store")) {
                                splitedText[start] = "010";
                            } else if (splitedText[start].equalsIgnoreCase("load")) {
                                splitedText[start] = "011";
                            } else if (splitedText[start].equalsIgnoreCase("addi")) {
                                splitedText[start] = "100";
                            } else if (splitedText[start].equalsIgnoreCase("subi")) {
                                splitedText[start] = "101";
                            } else if (splitedText[start].equalsIgnoreCase("r0")) {
                                splitedText[start] = "000";
                            } else if (splitedText[start].equalsIgnoreCase("r1")) {
                                splitedText[start] = "001";
                            } else if (splitedText[start].equalsIgnoreCase("r2")) {
                                splitedText[start] = "010";
                            } else if (splitedText[start].equalsIgnoreCase("r3")) {
                                splitedText[start] = "011";
                            } else if (splitedText[start].equalsIgnoreCase("r4")) {
                                splitedText[start] = "100";
                            } else if (splitedText[start].equalsIgnoreCase("r5")) {
                                splitedText[start] = "101";
                            } else if (splitedText[start].equalsIgnoreCase("r6")) {
                                splitedText[start] = "110";
                            } else if (splitedText[start].equalsIgnoreCase("r7")) {
                                splitedText[start] = "111";
                            } else if (splitedText[start].equalsIgnoreCase("0")) {
                                splitedText[start] = "000";
                            } else if (splitedText[start].equalsIgnoreCase("1")) {
                                splitedText[start] = "001";
                            } else if (splitedText[start].equalsIgnoreCase("2")) {
                                splitedText[start] = "010";
                            } else if (splitedText[start].equalsIgnoreCase("3")) {
                                splitedText[start] = "011";
                            } else if (splitedText[start].equalsIgnoreCase("4")) {
                                splitedText[start] = "100";
                            } else if (splitedText[start].equalsIgnoreCase("5")) {
                                splitedText[start] = "101";
                            } else if (splitedText[start].equalsIgnoreCase("6")) {
                                splitedText[start] = "110";
                            } else if (splitedText[start].equalsIgnoreCase("7")) {
                                splitedText[start] = "111";
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                                doNotAppend = true;
                            }
                            System.out.println(splitedText[start] + "\n");

                        }
                        instructionToBinary = splitedText[0] + splitedText[1] + splitedText[2] + splitedText[3];

                    } // If the operation is jump
                    else if (splitedText[0].equalsIgnoreCase("jump")) {

                        if (splitedText[0].equalsIgnoreCase("jump")) {
                            splitedText[0] = "110";

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                            doNotAppend = true;
                        }
                        System.out.println(splitedText[0] + "\n");

                        // if the jump instruction has only one digit
                        if (splitedText[1].length() == 1) {
                            if (splitedText[1].equals("0")) {
                                splitedText[1] = "000";
                            } else if (splitedText[1].equals("1")) {
                                splitedText[1] = "001";
                            } else if (splitedText[1].equals("2")) {
                                splitedText[1] = "010";
                            } else if (splitedText[1].equals("3")) {
                                splitedText[1] = "011";
                            } else if (splitedText[1].equals("4")) {
                                splitedText[1] = "100";
                            } else if (splitedText[1].equals("5")) {
                                splitedText[1] = "101";
                            } else if (splitedText[1].equals("6")) {
                                splitedText[1] = "110";
                            } else if (splitedText[1].equals("7")) {
                                splitedText[1] = "111";
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                                doNotAppend = true;
                            }
                            splitedText[1] = "000000" + splitedText[1];
                            System.out.println(splitedText[1] + "\n");
                        } // If the jump instruction has 2 digit
                        else if (splitedText[1].length() == 2) {
                            String[] temp = new String[2];
                            for (int start = 0; start < splitedText[1].length(); start++) {
                                char c = getCharFromString(splitedText[1], start);
                                System.out.println("Viewing the character");
                                System.out.println(c);
//                        System.out.println("Character viewed.");
                                if (c == '0') {
                                    temp[start] = "000";
                                } else if (c == '1') {
                                    temp[start] = "001";
                                } else if (c == '2') {
                                    temp[start] = "010";
                                } else if (c == '3') {
                                    temp[start] = "011";
                                } else if (c == '4') {
                                    temp[start] = "100";
                                } else if (c == '5') {
                                    temp[start] = "101";
                                } else if (c == '6') {
                                    temp[start] = "110";
                                } else if (c == '7') {
                                    temp[start] = "111";
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                                    doNotAppend = true;
                                }
                            }
                            splitedText[1] = "000" + temp[0] + temp[1];
                            System.out.println(splitedText[1] + "\n");
                        } // If the jump instruction has 3 digitss
                        else if (splitedText[1].length() == 3) {
                            String[] temp = new String[3];
                            for (int start = 0; start < splitedText[1].length(); start++) {
                                char c = getCharFromString(splitedText[1], start);
                                System.out.println("Viewing the character");
                                System.out.println(c);
//                        System.out.println("Character viewed.");
                                if (c == '0') {
                                    temp[start] = "000";
                                } else if (c == '1') {
                                    temp[start] = "001";
                                } else if (c == '2') {
                                    temp[start] = "010";
                                } else if (c == '3') {
                                    temp[start] = "011";
                                } else if (c == '4') {
                                    temp[start] = "100";
                                } else if (c == '5') {
                                    temp[start] = "101";
                                } else if (c == '6') {
                                    temp[start] = "110";
                                } else if (c == '7') {
                                    temp[start] = "111";
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                                    doNotAppend = true;
                                }
                            }

                            splitedText[1] = temp[0] + temp[1] + temp[2];
                            System.out.println(splitedText[1] + "\n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalild instruction", "Kindly check your instruction", JOptionPane.ERROR_MESSAGE);
                            doNotAppend = true;
                        }
                        instructionToBinary = splitedText[0] + splitedText[1];

                    } else {
                        System.out.println("Invalid instruction");
                    }

                    // temporarily hold each 4 bits of instructionToBinary
                    char[] ch = new char[4];
                    String[] temp = new String[3];
                    instructionToBinary.getChars(0, 4, ch, 0);
                    temp[0] = new String(ch);
                    instructionToBinary.getChars(4, 8, ch, 0);
                    temp[1] = new String(ch);
                    instructionToBinary.getChars(8, 12, ch, 0);
                    temp[2] = new String(ch);
//            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);

                    // convert the temporary values to hexadecimal
                    for (int start = 0; start < temp.length; start++) {
                        if (temp[start].equalsIgnoreCase("0000")) {
                            temp[start] = "0";
                        } else if (temp[start].equalsIgnoreCase("0001")) {
                            temp[start] = "1";
                        } else if (temp[start].equalsIgnoreCase("0010")) {
                            temp[start] = "2";
                        } else if (temp[start].equalsIgnoreCase("0011")) {
                            temp[start] = "3";
                        } else if (temp[start].equalsIgnoreCase("0100")) {
                            temp[start] = "4";
                        } else if (temp[start].equalsIgnoreCase("0101")) {
                            temp[start] = "5";
                        } else if (temp[start].equalsIgnoreCase("0110")) {
                            temp[start] = "6";
                        } else if (temp[start].equalsIgnoreCase("0111")) {
                            temp[start] = "7";
                        } else if (temp[start].equalsIgnoreCase("1000")) {
                            temp[start] = "8";
                        } else if (temp[start].equalsIgnoreCase("1001")) {
                            temp[start] = "9";
                        } else if (temp[start].equalsIgnoreCase("1010")) {
                            temp[start] = "a";
                        } else if (temp[start].equalsIgnoreCase("1011")) {
                            temp[start] = "b";
                        } else if (temp[start].equalsIgnoreCase("1100")) {
                            temp[start] = "c";
                        } else if (temp[start].equalsIgnoreCase("1101")) {
                            temp[start] = "d";
                        } else if (temp[start].equalsIgnoreCase("1110")) {
                            temp[start] = "e";
                        } else if (temp[start].equalsIgnoreCase("1111")) {
                            temp[start] = "f";
                        }

                        binaryToHex += temp[start];
                        System.out.println(temp[start]);
                    }

                    System.out.println(instructionToBinary);
                    System.out.println(binaryToHex);
//            if (!doNotAppend){
//                try (FileWriter fw = new FileWriter(fileVerify)){
//                    fw.append(binaryToHex + " ");
//                    fw.close();
//                } catch (IOException ex) {
//                    System.out.println("Unable to append file.");;
//                }
//            }
//            File fileVerify = new File("instructions.txt");
//            if (!fileVerify.exists()) {
//                System.out.println("The file doesn't exist.");
//                try {
//                    fileVerify.createNewFile();
//                    try ( FileWriter fw = new FileWriter(fileVerify)) {
//                        fw.append("v2.0 raw\n");
//                        fw.close();
//                        System.out.println("The file v2.0 raw is created.");
//                    }
//                } catch (IOException ex) {
//                    System.out.println("Unable to create file.");
//                }
//            } else {
//                System.out.println("The file exist.");
//            }

                    File file = new File("output.txt");
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                            try ( FileWriter fw = new FileWriter(file)) {
                                fw.write("v2.0 raw\n" + binaryToHex + " ");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (file.exists()) {
                        try {
                            FileWriter fw = new FileWriter(file, true);
                            try ( BufferedWriter bw = new BufferedWriter(fw)) {
                                bw.write(binaryToHex + " ");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    binaryToHex = "";
                    userText = br.readLine();
                }
                br.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addActionEvent() {
        convertButton.addActionListener(this);
        convertFromFile.addActionListener(this);
    }

    public void reset() {
        textField.setText("");
    }

    private char getCharFromString(String string, int index) {
        return string.charAt(index);
    }
}
