
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
//import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zver
 */
public class Floors extends javax.swing.JFrame{
    JPanel jpCell = new JPanel();
    int[][] matrixFloor;
    private JButton jbCell;
    private JLabel leftSide, rightSide, topSide, bottomSide;
    
    void initUI() {
        final JFrame frame = new JFrame(Floors.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        leftSide = new javax.swing.JLabel();
        leftSide.setPreferredSize(new Dimension(320, 320));
        
        rightSide = new javax.swing.JLabel();
        rightSide.setPreferredSize(new Dimension(320, 320));
        
        topSide = new javax.swing.JLabel();
        topSide.setPreferredSize(new Dimension(20, 20));
        
        bottomSide = new javax.swing.JLabel();
        bottomSide.setPreferredSize(new Dimension(20, 20));
        
        frame.add(leftSide, BorderLayout.WEST);
        frame.add(rightSide, BorderLayout.EAST);
        frame.add(topSide, BorderLayout.NORTH);
        frame.add(bottomSide, BorderLayout.SOUTH);
        
        GridLayout layout = new GridLayout(8, 8, 0, 0);
        jpCell.setLayout(layout);
        
        jbCell = new javax.swing.JButton();                
        matrixFloor = new int [8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final JButton newjbCell = new JButton();
                jbCell.add(newjbCell);
                newjbCell.setBorderPainted(false);
                newjbCell.setFocusPainted(false);
                newjbCell.setText(null);

                if ((i+j)%2 == 0) {
                    newjbCell.setBackground(new java.awt.Color(231,200,231));
                }
                else newjbCell.setBackground(new java.awt.Color(174,81,126));
                jpCell.add(newjbCell);
            }
        }
        
        frame.setExtendedState(Floors.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new java.awt.Color(83,28,41));
        frame.add(jpCell);
    //    frame.pack();
        frame.setVisible(true);
    }
}
