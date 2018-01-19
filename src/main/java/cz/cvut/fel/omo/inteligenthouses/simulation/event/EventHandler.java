package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import cz.cvut.fel.omo.inteligenthouses.config.Config;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.*;

/**
 *
 * @author macekja7
 */
public class EventHandler {

    private Config config;

    /**
     * Creates new EventHandler
     */
    public EventHandler() {

    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * Handles an event, handles Alert if event is an Alert, handles Info if event is an Info
     * @param event
     * @param config
     * @return 
     */
    public boolean handleEvent(Event event, Config config) {
        this.setConfig(config);
        if (event instanceof Alert) {
            return handleAlert((Alert) event);
        }
        if (event instanceof Info) {
            return handleInfo((Info) event);
        }
        return false;
    }

    private boolean handleAlert(Alert alert) {
        if (alert.getInput() instanceof Device) {
            Device device = (Device) alert.getInput();
            Position position = device.getPosition();
            List<Specimen> specimens = config.getSpecimens().parallelStream()
                    .filter(t -> t.getActualPosition() == position)
                    .collect(Collectors.toList());
            Specimen specimen = null;
            for (Specimen s : specimens) {
                if (s.getUsing() == null) {
                    specimen = s;
                    break;
                }
            }
            if (specimen != null) {
            	device.setNextState();
            	specimen.setUsing(device, generateRandom(0, 5));
                return true;
            }
        }
        return false;
    }

    private boolean handleInfo(Info info) {
    	//System.out.println("Handle info event: "+info);
        if (info.getInput() instanceof Specimen && info.getOutput() instanceof Device) {
            Specimen specimen = (Specimen) info.getInput();
            Device device = (Device) info.getOutput();
            if (specimen.getUsing() == null) {
            	device.setNextState();
            	specimen.setUsing(device, generateRandom(0, 5));
                return true;
            }
        }
        return false;
    }

    private int generateRandom(int min, int max) {
    	Random r = new Random();
        return (r.nextInt((int) ((max - min) + 1)) + min);
    }
}
