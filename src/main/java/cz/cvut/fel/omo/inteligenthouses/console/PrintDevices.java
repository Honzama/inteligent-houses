package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;

/**
 *
 * @author macekja7
 */
public class PrintDevices extends Console {

    /**
     * Creates new PrintDevices Console
     * @param back
     */
    public PrintDevices(Console back) {
        super(printDevicesName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());

        int count = 0;
        for (House h : Init.getInstance().getConfig().getHouses()) {
            count += h.getDevices().size();
        }

        System.out.println("Number of devices in simulation: " + count);

        for (House h : Init.getInstance().getConfig().getHouses()) {
            System.out.println("\r\n -Devices for " + h + ":\r\n");
            for (Device d : h.getDevices()) {
                System.out.println("  -" + d + ".");
            }
        }

        getBack().run();
    }

}
