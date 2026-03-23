/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectop2_germanfigueroa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gafm2
 */
public class FiguraUML extends JPanel{
    private String tipo;
    private String contenido = "";
    private Color colorFondo = new Color(200, 230, 255);
    
    FiguraUML(String tipo, int x, int y){
        this.tipo = tipo;
        this.setBounds(x, y, 140, 60);
        this.setOpaque(false);
        
        MouseAdapter ma = new MouseAdapter(){
            private Point clickPoint;
            
            @Override
            public void mousePressed(MouseEvent e){
                clickPoint = e.getPoint();
                if(SwingUtilities.isRightMouseButton(e)){
                    menuContextual(e);
                }
            }
            @Override
            public void mouseDragged(MouseEvent e){
                Point p = SwingUtilities.convertPoint(FiguraUML.this, e.getPoint(), getParent());
                setLocation(p.x - clickPoint.x, p.y - clickPoint.y);
                getParent().repaint();
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }
    private void menuContextual(MouseEvent e){
        JPopupMenu menu = new JPopupMenu();
        JMenuItem prop = new JMenuItem("Propiedades");
        JMenuItem del = new JMenuItem("Eliminar");
        
        prop.addActionListener(al -> {
            String input = JOptionPane.showInputDialog("Texto para: " + tipo + ":", contenido);
            if(input != null){
                contenido = input;
                repaint();
            }
        });
        del.addActionListener(al ->{
            Container parent = getParent();
            parent.remove(this);
            parent.repaint();
        });
        menu.add(prop);
        menu.add(del);
        menu.show(this, e.getX(), e.getY());
    }
    public String getCodigoJava(){
        switch(tipo){
            case "Inicio": return "public class Main {\n   public static void main(String[] args) {";
            case "Fin": return "  }\n}";
            case "sout": return "  System.out.println(\"" + contenido + "\");";
            case "If": return "    if(" + contenido + "; i++) {\n          }";
            case "For": return "   for(int i = 0; i < " + contenido + "; i++) {\n   }";
            case "While": return " while(" + contenido + ") {\n    }";
            case "Operacion": return "   " + contenido + "; ";
            default: return "";
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(colorFondo);
        if(tipo.equals("IF")){
            int [] x = {getWidth()/2, getWidth(), getWidth()/2, 0};
            int [] y = {0, getHeight()/2, getHeight(), getHeight()/2};
            g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        g2.setFont(new Font("Sanseriff", Font.BOLD, 11));
        g2.drawString(tipo, 10, 20);
        g2.setFont(new Font("Sanseriff", Font.PLAIN, 10));
        g2.drawString(contenido, 10, 40);
    }
}
