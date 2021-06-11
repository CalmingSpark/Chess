
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zver
 */
public class Bishop extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackBishop.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhiteBishop.png");

    Bishop(boolean isBlack, int positionX, int positionY) {
        this.isBlack = isBlack;
        if(this.isBlack) {
           this.img = this.blackIcon;
        }
        else {
            this.img = this.whiteIcon;
        }
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    @Override
    public void Motion(JReferencingButton[][] massb, int x, int y) {
        boolean c = massb[x][y].shape.isBlack;
        
        //doun right
        for (int i = (x + 1), j = (y + 1); i < 8 && j < 8; i++, j++) {
            if (massb[i][j].shape == null)
                massb[i][j].setFreePosition(i, j);
            else {
                if (massb[i][j].shape.isBlack != c) {
                    massb[i][j].setFreePosition(i, j);
                    break;
                }
                else break;
            }
        }
        
        //up right
        for (int i = (x - 1), j = (y + 1); i >=0 && j < 8; i--, j++) {
            if (massb[i][j].shape == null)
                massb[i][j].setFreePosition(i, j);
            else {
                if (massb[i][j].shape.isBlack != c) {
                    massb[i][j].setFreePosition(i, j);
                    break;
                }
                else break;
            }
        }  
        
        //down left
        for (int i = (x + 1), j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (massb[i][j].shape == null)
                massb[i][j].setFreePosition(i, j); 
            else {
                if (massb[i][j].shape.isBlack != c) {
                    massb[i][j].setFreePosition(i, j);
                    break;
                }
                else break;
            }
        }
        
        //up left
        for (int i = (x - 1), j = (y - 1); i >= 0 && j >= 0; i--, j--) {
            if (massb[i][j].shape == null)
                massb[i][j].setFreePosition(i, j);
            else {
                if (massb[i][j].shape.isBlack != c) {
                    massb[i][j].setFreePosition(i, j);
                    break;
                }
                else break;
            }
        }        
    }
    
}
