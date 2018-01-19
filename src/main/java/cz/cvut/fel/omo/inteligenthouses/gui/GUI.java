package cz.cvut.fel.omo.inteligenthouses.gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
*
* @author kahoumic
*/
@SuppressWarnings("serial")
public abstract class GUI extends JFrame {
    
    public static final Font TITLE_FONT = new Font("Tahoma", 0, 24);

    public GUI(String title, int height, int width) {
        super(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
