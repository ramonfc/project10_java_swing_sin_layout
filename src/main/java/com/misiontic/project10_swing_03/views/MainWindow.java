/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.project10_swing_03.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Ramon
 */
public class MainWindow extends JFrame{
    
    public MainWindow(){
       configWindow(); 
       initComponents();
    }
    
    private void configWindow(){
        //Confg para al ventana:
        Toolkit screen = Toolkit.getDefaultToolkit(); //detectar pantalla
        Dimension dimension = screen.getScreenSize(); //obtener dimensiones de la pantalla
        int height = dimension.height;
        int width = dimension.width;
        double scaleHeight = 0.70;
        double scaleWidth = 0.30;        
        setSize((int)(width * scaleWidth), (int)(height * scaleHeight));
        setLocationRelativeTo(null);
        //setBounds(100,100,400,300); // tamaño y posición
        setTitle("Mision TIC"); // titulo de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initComponents(){
        LoginView login = new LoginView();
        this.getContentPane().add(login);
    }
}
