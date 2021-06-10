
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.awt.Container;

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

public class Floor extends javax.swing.JFrame{
    JPanel jpCell = new JPanel();
    GridLayout layout = new GridLayout(8, 8, 0, 0);
    private JReferencingButton[][] matrixFloor;
    private JReferencingButton jbCell, tempbtn;
    private JLabel leftSide, rightSide, topSide, bottomSide;
    
    void initUI() throws IOException {
        final JFrame frame = new JFrame(Floor.class.getSimpleName());
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
        
        jpCell.setLayout(layout);
                
        jbCell = new JReferencingButton();                
        matrixFloor = new JReferencingButton[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrixFloor[i][j] = new JReferencingButton();
                ActionListener actionListener = new TestActionListener();
                matrixFloor[i][j].addActionListener(actionListener);
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
        CreateFigure(); 
        
        frame.setExtendedState(Floor.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new java.awt.Color(83,28,41));
        frame.add(jpCell);
    //    frame.pack();
        frame.setVisible(true);
    }

    private void CreateFigure() {
        Shape BlackCastle1 = new Castle(true, 0, 0);
        AddFigure(BlackCastle1);
        Shape BlackCastle2 = new Castle(true, 0, 7);
        AddFigure(BlackCastle2);
        
        Shape WhiteCastle1 = new Castle(false, 7, 0);
        AddFigure(WhiteCastle1);
        Shape WhiteCastle2 = new Castle(false, 7, 7);
        AddFigure(WhiteCastle2);

        Shape BlackKnight1 = new Knight(true, 0, 1); //0,1
        AddFigure(BlackKnight1);
        Shape BlackKnight2 = new Knight(true, 0, 6);
        AddFigure(BlackKnight2);
        
        Shape WhiteKnight1 = new Knight(false, 7, 1);
        AddFigure(WhiteKnight1);
        Shape WhiteKnight2 = new Knight(false, 7, 6);
        AddFigure(WhiteKnight2);
        
        Shape BlackBishop1 = new Bishop(true, 0, 2);
        AddFigure(BlackBishop1);
        Shape BlackBishop2 = new Bishop(true, 0, 5);
        AddFigure(BlackBishop2);
        
        Shape WhiteBishop1 = new Bishop(false, 7, 2);
        AddFigure(WhiteBishop1);
        Shape WhiteBishop2 = new Bishop(false, 7, 5);
        AddFigure(WhiteBishop2);
        
        Shape BlackKing = new King(true, 0, 4);
        AddFigure(BlackKing);
        Shape WhiteKing = new King(false, 7, 4);
        AddFigure(WhiteKing);
        
        Shape BlackQueen = new Queen(true, 0, 3);
        AddFigure(BlackQueen);
        Shape WhiteQueen = new Queen(false, 7, 3);
        AddFigure(WhiteQueen);
        
        Shape[] blackPawns = new Shape[8];
        for(int i = 0; i < 8; i++) {
            blackPawns[i] = new Pawn(true, 1, i);
            AddFigure(blackPawns[i]);
        }
        
        Shape[] whitePawns = new Shape[8];
        for(int i = 0; i < 8; i++) {
            whitePawns[i] = new Pawn(false, 6, i);
            AddFigure(whitePawns[i]);
        }
    }
    
    private void AddFigure(Shape s) {
        this.matrixFloor[s.positionX][s.positionY].setChessShape(s);
    }
        
    public class TestActionListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(source == matrixFloor[i][j]){
                    if(tempbtn == null) {
                        tempbtn = matrixFloor[i][j];
                        Shape s = matrixFloor[i][j].getChessShape();
                        s.Motion(matrixFloor, i, j);
                    }
                    else {
                        if (matrixFloor[i][j].isFree) {
                        Shape s = tempbtn.getChessShape();
                        matrixFloor[i][j].setChessShape(s);
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                if (tempbtn == matrixFloor[x][y]) {
                                    matrixFloor[x][y].delChessShape();
                                }
                            }
                        }
                        DelFreeButt();
                        tempbtn = null;
                        }
                    }
                }
            }
        }
    }
    private void DelFreeButt() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrixFloor[i][j].delFreePosition(i, j);
                }
            }
        }
    }     
}
    
