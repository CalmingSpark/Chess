
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    private JButton[][] matrixFloor;
    private JButton jbCell;
    private JLabel leftSide, rightSide, topSide, bottomSide;
    
    void initUI() throws IOException {
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
        matrixFloor = new JButton [8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrixFloor[i][j] = new JButton();
                jbCell.add(matrixFloor[i][j]);
                matrixFloor[i][j].setBorderPainted(false);
                matrixFloor[i][j].setFocusPainted(false);
                matrixFloor[i][j].setText(null);

                if ((i+j)%2 == 0) {
                    matrixFloor[i][j].setBackground(new java.awt.Color(231,200,231));
                }
                else { 
                    matrixFloor[i][j].setBackground(new java.awt.Color(174,81,126));
                }
                jpCell.add(matrixFloor[i][j]); 
            }
        }
        
        Shapes BlackCastle1 = new Castle(true, 0, 0);
        AddFigure(BlackCastle1);
        Shapes BlackCastle2 = new Castle(true, 0, 7);
        AddFigure(BlackCastle2);
        
        Shapes WhiteCastle1 = new Castle(false, 7, 0);
        AddFigure(WhiteCastle1);
        Shapes WhiteCastle2 = new Castle(false, 7, 7);
        AddFigure(WhiteCastle2);

        Shapes BlackKnight1 = new Knight(true, 0, 1);
        AddFigure(BlackKnight1);
        Shapes BlackKnight2 = new Knight(true, 0, 6);
        AddFigure(BlackKnight2);
        
        Shapes WhiteKnight1 = new Knight(false, 7, 1);
        AddFigure(WhiteKnight1);
        Shapes WhiteKnight2 = new Knight(false, 7, 6);
        AddFigure(WhiteKnight2);
        
        Shapes BlackBishop1 = new Bishop(true, 0, 2);
        AddFigure(BlackBishop1);
        Shapes BlackBishop2 = new Bishop(true, 0, 5);
        AddFigure(BlackBishop2);
        
        Shapes WhiteBishop1 = new Bishop(false, 7, 2);
        AddFigure(WhiteBishop1);
        Shapes WhiteBishop2 = new Bishop(false, 7, 5);
        AddFigure(WhiteBishop2);
        
        Shapes BlackKing = new King(true, 0, 4);
        AddFigure(BlackKing);
        Shapes WhiteKing = new King(false, 7, 4);
        AddFigure(WhiteKing);
        
        Shapes BlackQueen = new Queen(true, 0, 3);
        AddFigure(BlackQueen);
        Shapes WhiteQueen = new Queen(false, 7, 3);
        AddFigure(WhiteQueen);
         
        frame.setExtendedState(Floors.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new java.awt.Color(83,28,41));
        frame.add(jpCell);
    //    frame.pack();
        frame.setVisible(true);
    }
        private void AddFigure(Shapes s) {
        matrixFloor[s.positionX][s.positionY].setIcon(s.img);
        }
}
