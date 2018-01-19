package cz.cvut.fel.omo.inteligenthouses.gui;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author kahoumic
 */
@SuppressWarnings("serial")

public abstract class Dialog extends JDialog {
    
    public static final Font TITLE_FONT = new Font("Tahoma", 0, 24);
    
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 320;
    
    
    public Dialog(Frame parent, boolean modal) {
        super(parent, "", modal);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
//        this.setVisible(true);
    }
    
    public Dialog(Frame parent, boolean modal, String title) {
        super(parent, title, modal);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
//        this.setVisible(true);
    }
    
    public Dialog(Frame parent, boolean modal, String title, int height, int width) {
        super(parent, title, modal);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
//        this.setVisible(true);
    }
    
    
}
