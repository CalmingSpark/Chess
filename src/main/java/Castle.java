
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
public class Castle extends Shapes {
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
    
}
