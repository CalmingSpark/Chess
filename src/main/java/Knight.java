
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
public class Knight extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackKnight.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhiteKnight.png");
            
    Knight(boolean isBlack, int positionX, int positionY) {
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
        
        if ((x - 2) >= 0 && (y + 1) <= 7)
            if (massb[(x - 2)][(y + 1)].shape == null || massb[(x - 2)][(y + 1)].shape.isBlack != c)
            massb[(x - 2)][(y + 1)].setFreePosition();
        

        if ((x - 1) >= 0 && (y + 2) <= 7)
            if (massb[(x - 1)][(y + 2)].shape == null || massb[(x - 1)][(y + 2)].shape.isBlack != c)
            massb[(x - 1)][(y + 2)].setFreePosition();
    
        if ((x + 1) <= 7 && (y - 2) >= 0)
            if (massb[(x + 1)][(y - 2)].shape == null || massb[(x + 1)][(y - 2)].shape.isBlack != c)
            massb[(x + 1)][(y - 2)].setFreePosition();
        
        if ((x + 1) <= 7 && (y + 2) <= 7)
            if (massb[(x + 1)][(y + 2)].shape == null || massb[(x + 1)][(y + 2)].shape.isBlack != c)
            massb[(x + 1)][(y + 2)].setFreePosition();
        
        if ((x + 2) <= 7 && (y + 1) <= 7)
            if (massb[(x + 2)][(y + 1)].shape == null || massb[(x + 2)][(y + 1)].shape.isBlack != c)
            massb[(x + 2)][(y + 1)].setFreePosition();
        
        if ((x + 2) <= 7 && (y - 1) >= 0)
            if (massb[(x + 2)][(y - 1)].shape == null || massb[(x + 2)][(y - 1)].shape.isBlack != c)
            massb[(x + 2)][(y - 1)].setFreePosition();
        
        if ((x - 1) >= 0 && (y - 2) >= 0)
            if (massb[(x - 1)][(y - 2)].shape == null || massb[(x - 1)][(y - 2)].shape.isBlack != c)
            massb[(x - 1)][(y - 2)].setFreePosition();
        
        if ((x - 2) >= 0 && (y - 1) >= 0)
            if (massb[(x - 2)][(y - 1)].shape == null || massb[(x - 2)][(y - 1)].shape.isBlack != c)
            massb[(x - 2)][(y - 1)].setFreePosition();
    }
}
