
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
    int positionX;
    int positionY;
    Shape shape;

    public void setChessShape(Shape shape) {
        this.shape = shape;
        setIcon(shape.img);
    }
    public Shape getChessShape() {
        return shape;
    }
}
