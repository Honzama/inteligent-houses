package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.gui.*;

/**
 *
 * @author macekja7
 */
public class GUIFactory extends Factory {

    private static GUIFactory instance = null;
    
    protected GUIFactory() {}

    public MenuGUI createMenu(String title, int height, int width) {
        return new MenuGUI(title, height, width);
    }

    public static GUIFactory getInstance() {
        if (instance == null) {
            instance = new GUIFactory();
        }
        return instance;
    }
}
