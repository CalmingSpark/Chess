
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
    
}
