
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zver
 */
public class Choice extends javax.swing.JFrame {
    private final JReferencingButton[][] massb; 
    private final int x; 
    private final int y;
    private final boolean isBlack;
    private JFrame form2 = new JFrame("Choose a shape");
    private JReferencingButton[] jrbListChoice;
    
    Choice(JReferencingButton[][] massb, int x, int y, boolean isBlack) {
        this.massb = massb;
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }
    
        public void AddFrameChoice() {
        JPanel jpChoice = new JPanel();
        GridLayout layout = new GridLayout(1, 4, 0, 0);
        JReferencingButton jrbChoice;
        
        jpChoice.setLayout(layout);               
        jrbListChoice = new JReferencingButton[4];
        for (int i = 0; i < 4; i++) {
            jrbChoice = new JReferencingButton(i, 0); 
            jrbListChoice[i] = new JReferencingButton(i, 0);
            ActionListener actionListener = new Choice.TestActionListener();
            jrbListChoice[i].addActionListener(actionListener);
            jrbChoice.add(jrbListChoice[i]);
            jrbListChoice[i].setBorderPainted(false);
            jrbListChoice[i].setFocusPainted(false);
            jrbListChoice[i].setText(null);
            jrbListChoice[i].setBackground(new java.awt.Color(149,242,211));
            jpChoice.add(jrbListChoice[i]); 
        }
        
        if(isBlack) {
            Shape BlackCastle = new Castle(true, 0, 0);
            jrbListChoice[0].setChessShape(BlackCastle);

            Shape BlackKnight = new Knight(true, 1, 0);
            jrbListChoice[1].setChessShape(BlackKnight);

            Shape BlackBishop = new Bishop(true, 2, 0);
            jrbListChoice[2].setChessShape(BlackBishop);

            Shape BlackQueen = new Queen(true, 3, 0);
            jrbListChoice[3].setChessShape(BlackQueen);
        }
        else {
            Shape WhiteCastle = new Castle(false, 0, 0);
            jrbListChoice[0].setChessShape(WhiteCastle);

            Shape WhiteKnight = new Knight(false, 1, 0);
            jrbListChoice[1].setChessShape(WhiteKnight);

            Shape WhiteBishop = new Bishop(false, 2, 0);
            jrbListChoice[2].setChessShape(WhiteBishop);

            Shape WhiteQueen = new Queen(false, 3, 0);
            jrbListChoice[3].setChessShape(WhiteQueen);            
        } 
        
        form2.add(jpChoice);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - 350) / 2;
        int locationY = (screenSize.height - 150) / 2;
        form2.setBounds(locationX, locationY, 350, 150);
        form2.setBackground(new java.awt.Color(149,242,211));
        form2.setVisible(true);
    }
    
    public class TestActionListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            JReferencingButton jrButton = (JReferencingButton) e.getSource();
            int xb = jrButton.getPositionX();
            Shape s = jrbListChoice[xb].getChessShape();
            massb[x][y].setChessShape(s);
            form2.setVisible(false);
        }
     }
}
