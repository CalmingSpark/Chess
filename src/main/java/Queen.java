
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
public class Queen extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackQueen.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhiteQueen.png");

    Queen(boolean isBlack, int positionX, int positionY) {
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
        Castle cstl = new Castle(false, 0, 0);
        cstl.Motion(massb, x, y);
        
        Bishop bshp = new Bishop(false, 0, 0);
        bshp.Motion(massb, x, y);
    }
    
}
