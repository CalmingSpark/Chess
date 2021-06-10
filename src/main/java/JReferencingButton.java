
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zver
 * @param <T>
 */
public class JReferencingButton<T> extends JButton {
    public int positionX;
    public int positionY;
    boolean isFree;
    Shape shape;

    public JReferencingButton() {
        this.isFree = false;
        this.shape = null;
    }

    public void setChessShape(Shape shape) {
        this.shape = shape;
        setIcon(shape.img);
    }
    
    public Shape getChessShape() {
        return shape;
    }
    
    public void delChessShape() {
        this.shape = null;
        setIcon(null);
    }
    
    public void setFreePosition() {
        setBackground(new java.awt.Color(167,255,217));
        isFree = true;
    }
    
    public void delFreePosition(int x, int y) {
        if ((x + y)%2 == 0) {
            setBackground(new java.awt.Color(231,200,231));
        }
        else { 
            setBackground(new java.awt.Color(174,81,126));
        }
        isFree = false;       
    }
}
