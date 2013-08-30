/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Jean
 */
public abstract class FrameDisposable extends JDialog{

    public FrameDisposable(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
