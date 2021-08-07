/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.project10_swing_03.views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ramon
 */
public class LoginView extends JPanel implements ActionListener{
    
    Image loginImage;
    JTextField username;
    JPasswordField password;
    JButton loginButton, clearButton, exitButton;
    
    public LoginView(){
        configPanel();
        initComponents();
    }
    
    private void configPanel(){
        setLayout(null);
    }
    
    private void initComponents(){
      header();
      inputData();
      footer();
    }
    
    private void header(){
        JLabel description = new JLabel("Iniciar sesión");
        description.setBounds(100, 10, 200, 20);
        this.add(description);
    }
    
    private void inputData(){
       JLabel labelUsername = new JLabel("username");
       labelUsername.setBounds(30, 220, 80, 30);
       
       username = new JTextField();
       username.setBounds(115, 220, 100, 30);
       
       JLabel labelPassword = new JLabel("password");
       labelPassword.setBounds(30, 260, 80, 30);
       
       password = new JPasswordField();
       password.setBounds(115, 260, 100, 30);
       
       this.add(labelUsername);
       this.add(username);
       this.add(labelPassword);
       this.add(password);
    }
    
    private void footer(){
       loginButton = new JButton("Login");
       loginButton.setBounds(100, 300, 80, 30);
       loginButton.addActionListener(this);
       
       clearButton = new JButton("Clear");
       clearButton.setBounds(100, 340, 80, 30);
       clearButton.addActionListener(this);
       
       exitButton = new JButton("Exit");
       exitButton.setBounds(100, 390, 80, 30);
       exitButton.addActionListener(this);
       
       this.add(loginButton);
       this.add(clearButton);
       this.add(exitButton);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File imageLogin = new File("src/assets/Logo-Android.png");
        try{
           Image image = ImageIO.read(imageLogin);
           this.loginImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
           g.drawImage(this.loginImage, 100, 40, this);
        }
        catch(IOException e){
            System.out.println("error de lectura");
            JOptionPane.showMessageDialog(this, "Error de lectura de imagen");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
       Object clickedButton = e.getSource();       
       if(clickedButton == clearButton){
           username.setText("");
           password.setText("");
       }
       else if(clickedButton == exitButton){
           System.exit(0);
       }
       else{
          String pass = new String(this.password.getPassword());
          JOptionPane.showMessageDialog(this, pass); 
       }
    }
}
