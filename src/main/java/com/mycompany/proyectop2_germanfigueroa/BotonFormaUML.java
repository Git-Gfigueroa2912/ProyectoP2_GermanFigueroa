/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectop2_germanfigueroa;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

/**
 *
 * @author gafm2
 */
public class BotonFormaUML extends JButton{
    private String tipo;
    
    public BotonFormaUML(String texto, String tipo){
    super(texto);
    this.tipo = tipo;
    
    this.setContentAreaFilled(false);
    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.setForeground(Color.WHITE);
    this.setFont(new Font("Consolas", Font.BOLD, 12));
  }
  @Override
     protected void paintComponent(Graphics g){
         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         
         g2.setColor(new Color(60,60,60));
         
         int w = getWidth();
         int h = getHeight();
         
         switch(tipo.toLowerCase()){
             case "inicio":
             case "fin":
                 
                 g2.fillRoundRect(5, 5, w - 10, h - 10, 30, 30);
                 break;
             case "if":
                 
                 int [] xDiamante = {w / 2, w - 10, w / 2, 10};
                 int [] yDiamante = {5, h / 2, h - 5, h / 2};
                 g2.fillPolygon(xDiamante, yDiamante, 4);
                 break;
             case "for":
             case "while":
                 
                 int [] xHex = {15, w - 15, w - 5, w - 5, 15, 5};
                 int [] yHex = {5, 5, h / 2, h - 5, h - 5, h / 2};
                 g2.fillPolygon(xHex, yHex, 6);
                 break;
             default:
                 
                 g2.fillRect(5, 5, w - 10, h - 10);
                 break;
                 
         }
         
         super.paintComponent(g);
     }  
    
}
