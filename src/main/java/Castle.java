
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
public class Castle extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackCastle.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhiteCastle.png");

    Castle(boolean isBlack, int positionX, int positionY) {
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
        
        //doun
        for (int i = (x + 1); i < 8 ; i++) {
            if (massb[i][y].shape == null)
                massb[i][y].setFreePosition(i, y);
            else {
                if (massb[i][y].shape.isBlack != c) {
                    massb[i][y].setFreePosition(i, y);
                    break;
                }
                else break;
            }
        }
        
        //up
        for (int i = (x - 1) ; i >=0 ; i--) {
            if (massb[i][y].shape == null)
                massb[i][y].setFreePosition(i, y);
            else {
                if (massb[i][y].shape.isBlack != c) {
                    massb[i][y].setFreePosition(i, y);
                    break;
                }
                else break;
            }
        }
        
        //right
        for (int j = (y + 1); j < 8; j++) {
            if (massb[x][j].shape == null)
                massb[x][j].setFreePosition(x, j); 
            else {
                if (massb[x][j].shape.isBlack != c) {
                    massb[x][j].setFreePosition(x, j);
                    break;
                }
                else break;
            }
        }
        
        //left
        for (int j = (y - 1); j >=0 ; j--) {
            if (massb[x][j].shape == null)
                massb[x][j].setFreePosition(x, j); 
            else {
                if (massb[x][j].shape.isBlack != c) {
                    massb[x][j].setFreePosition(x, j);
                    break;
                }
                else break;
            }
        }
    }
    
}
