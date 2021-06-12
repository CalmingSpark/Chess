
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

    public JReferencingButton(int positionX,int positionY) {
        this.isFree = false;
        this.shape = null;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getPositionX() {
        return positionX;
    }
    
    public int getPositionY() {
        return positionY;
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
    
    public void setFreePosition(int x, int y) {
        if ((x + y)%2 == 0) {
            setBackground(new java.awt.Color(201,255,231));
        }
        else { 
            setBackground(new java.awt.Color(111,255,191));
        }
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
