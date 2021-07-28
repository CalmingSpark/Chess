
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
public class King extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackKing.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhiteKing.png");

    King(boolean isBlack, int positionX, int positionY) {
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
        boolean isCastlingBlack = false;
        boolean isCastlingWhite = false;
        
        if (c && !isCastlingBlack){
            if (massb[(x - 1)][(y - 1)].shape == null || massb[(x - 1)][(y - 1)].shape.isBlack != c)
            massb[(x - 1)][(y - 1)].setFreePosition((x - 1),(y - 1));            
        }
        
        if (!c && !isCastlingWhite) {
            
        }
        
        if ((x + 1) < 8 && (y + 1) < 8)
            if (massb[(x + 1)][(y + 1)].shape == null || massb[(x + 1)][(y + 1)].shape.isBlack != c)
            massb[(x + 1)][(y + 1)].setFreePosition((x + 1),(y + 1));
        
        if ((x - 1) >= 0 && (y - 1) >= 0)
            if (massb[(x - 1)][(y - 1)].shape == null || massb[(x - 1)][(y - 1)].shape.isBlack != c)
            massb[(x - 1)][(y - 1)].setFreePosition((x - 1),(y - 1));
        
        if ((x + 1) < 8 && (y - 1) >= 0)
            if (massb[(x + 1)][(y - 1)].shape == null || massb[(x + 1)][(y - 1)].shape.isBlack != c)
            massb[(x + 1)][(y - 1)].setFreePosition((x + 1),(y - 1));

        if ((x - 1) >= 0 && (y + 1) < 8)
            if (massb[(x - 1)][(y + 1)].shape == null || massb[(x - 1)][(y + 1)].shape.isBlack != c)
            massb[(x - 1)][(y + 1)].setFreePosition((x - 1),(y + 1));     
        
        if ((x + 1) < 8 && y >= 0 && y < 8)
            if (massb[(x + 1)][y].shape == null || massb[(x + 1)][y].shape.isBlack != c)
            massb[(x + 1)][y].setFreePosition((x + 1),y);     
        
        if ((x - 1) >= 0 && y >= 0 && y < 8)
            if (massb[(x - 1)][y].shape == null || massb[(x - 1)][y].shape.isBlack != c)
            massb[(x - 1)][y].setFreePosition((x - 1),y);        
        
        if ((y + 1) < 8 && x >= 0 && x < 8)
            if (massb[x][(y + 1)].shape == null || massb[x][(y + 1)].shape.isBlack != c)
            massb[x][(y + 1)].setFreePosition(x,(y + 1));     
        
        if ((y - 1) >= 0 && x >= 0 && x < 8)
            if (massb[x][(y - 1)].shape == null || massb[x][(y - 1)].shape.isBlack != c)
            massb[x][(y - 1)].setFreePosition(x,(y - 1)); 
    }
    
}
