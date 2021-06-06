
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
public abstract class Shapes extends javax.swing.JFrame {
    ImageIcon img;
    boolean isBlack; // 0 - white, 1 - black
    int positionX;
    int positionY;
    
    public void SetPosition (int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        
    }
    
    public int[] GetPosition () {
        return new int[]{positionX, positionY};
    }
    
    public void Motion() {}
}
