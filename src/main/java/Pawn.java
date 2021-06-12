
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
public class Pawn extends Shape {
    private final ImageIcon blackIcon = new ImageIcon("resources/BlackPawn.png");
    private final ImageIcon whiteIcon = new ImageIcon("resources/WhitePawn.png");
    
    Pawn(boolean isBlack, int positionX, int positionY) {
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
        if (c) {
            if ((x + 1) < 8 && (y - 1) >= 0 && massb[x + 1][y - 1].shape != null && 
                    !massb[x + 1][y - 1].shape.isBlack) 
                massb[x + 1][y - 1].setFreePosition((x + 1),(y - 1));
            
            if ((x + 1) < 8 && (y + 1) < 8 && massb[x + 1][y + 1].shape != null && 
                    !massb[x + 1][y + 1].shape.isBlack) 
                massb[x + 1][y + 1].setFreePosition((x + 1),(y + 1));
            
            if (x == 1) {
                for (int i = 2; i < 4; i++) {
                    if (massb[i][y].shape == null)
                        massb[i][y].setFreePosition(i, y);
                    else break;
                }
            }
            if (x != 1 && x < 7) {
                if (massb[(x + 1)][y].shape == null)
                massb[(x + 1)][y].setFreePosition((x + 1),y);
            }
            if (x == 7) {
                Choice choice = new Choice(massb, x, y, c);
                choice.AddFrameChoice();
            }
        }
        else {
            if ((x - 1) >= 0 && (y - 1) >= 0 && massb[x - 1][y - 1].shape != null && 
                    massb[x - 1][y - 1].shape.isBlack) 
                massb[x - 1][y - 1].setFreePosition((x - 1),(y - 1));
            
            if ((x - 1) >= 0 && (y + 1) < 8 && massb[x - 1][y + 1].shape != null && 
                    massb[x - 1][y + 1].shape.isBlack) 
                massb[x - 1][y + 1].setFreePosition((x - 1),(y + 1));
            
            if (x == 6) {
                for (int i = 5; i > 3; i--) {
                    if (massb[i][y].shape == null)
                        massb[i][y].setFreePosition(i, y);
                    else break;
                    }
                }              
            if (x != 6 && x > 0) {
                if (massb[(x - 1)][y].shape == null)
                massb[(x - 1)][y].setFreePosition((x - 1),y);
            }
            if (x == 0) {
                Choice choice = new Choice(massb, x, y, c);
                choice.AddFrameChoice();
            }
        }
    }
    @Override
    public String GetName(){
        return "Pawn";
    }
}    
    
