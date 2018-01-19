package cz.cvut.fel.omo.inteligenthouses.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a single console
 * @author macekja7
 */
public abstract class Console {
    //System Info
    
    public static final String systemName = "Inteligent Houses";
    public static final String version = "1.0.0";

    //Messages
    public static final String welcomeMsg = "Welcome to the Matrix with Inteligent Houses and Binary people inside them.";
    public static final String errorMsg = "\r\nError input try again:";
    public static final String exitMsg = "exit";
    public static final String iterateMsg = "Number of iteration cycles:";

    //Classes names
    public static final String initName = "Init";
    public static final String configName = "Config";
    public static final String staticConfigName = "Static_Config";
    public static final String simulationName = "Simulation";
    public static final String iterateSimulationName = "Iterate_Simulation";
    public static final String printDevicesName = "Print_Devices";
    public static final String printEventsName = "Print_Events";
    public static final String printHousesName = "Print_Houses";
    public static final String printSpecimensName = "Print_Specimens";
    public static final String reportingName = "Reporting";
    public static final String houseConfigurationReportName = "House_Configuration_Report";
    public static final String eventReportingName = "Event_Reporting";
    public static final String activityAndUsageReportName = "Activity_And_Usage_Report";
    public static final String consumptionReportName = "Consumption_Report";
    public static final String savingsReportName = "Savings_Report";

    //other variables
    public static final int separatorLineLenght = 128;
    private Console back;
    private String name;
    private List<Console> consoles;
    private Scanner in;

    /**
     * Creates new console
     * @param name name of the console
     * @param back parent of this console 
     */
    public Console(String name, Console back) {
        this.name = name;
        consoles = new ArrayList<Console>();
        this.back = back;
        in = new Scanner(System.in);
    }

    /**
     * Starts the console
     */
    public abstract void start();

    /**
     * Runs the console
     */
    public void run() {
        Console console = null;
        while (console == null) {
            printMenu();
            console = validateInput(loadInput());
            if (console == null) {
                System.out.println(errorMsg);
            }
        }
        console.start();
    }

    /**
     * Prints menu
     */
    public void printMenu() {
        System.out.println(getLineSeparator());
        System.out.println(name + " Menu:");
        printConsoles();
        if (back == null) {
            System.out.println(consoles.size() + 1 + " - " + exitMsg);
        } else {
            System.out.println(consoles.size() + 1 + " - " + back.getName());
        }
        System.out.println(getLineSeparator());
    }

    /**
     * Validates if user's input is a valid number
     * @param input given input
     * @return new Console based on the input; null if input is not valid
     */
    public Console validateInput(String input) {
        if (isNumber(input)) {
            int i = Integer.parseInt(input) - 1;
            if (!consoles.isEmpty() && i >= 0 && i < consoles.size()) {
                return consoles.get(i);
            }
            if (i == consoles.size()) {
                if (back != null) {
                    return back;
                } else {
                    System.exit(0);
                }
            }
        }
        if (input.equals(exitMsg)) {
            System.exit(0);
        }
        if (back != null && input.equals(back.getName())) {
            return back;
        }
        if (containConsole(input)) {
            return getConsole(input);
        }
        return null;
    }

    /**
     * Validates int in given string
     * @param input string value of int
     * @return <code>true</code> iff input can be parsed to an int, <code>false</code> otherwise
     */
    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Loads input from console
     * @return input
     */
    public String loadInput() {
        return in.nextLine();
    }

    /**
     * Prints all consoles under this parent
     */
    public void printConsoles() {
        for (int i = 0; i < consoles.size(); i++) {
            System.out.println(i + 1 + " - " + consoles.get(i).getName());
        }
    }

    /**
     * 
     * @return a line of dashes with length given by <code>separatorLineLength</code>
     */
    public String getLineSeparator() {
        String line = "";
        for (int i = 0; i < separatorLineLenght; i++) {
            line += "-";
        }
        return line;
    }

    public Console getBack() {
        return back;
    }

    public String getName() {
        return name;
    }

    public List<Console> getConsoles() {
        return consoles;
    }

    public void setBack(Console back) {
        this.back = back;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public void addConsole(Console console) {
        this.consoles.add(console);
    }

    public void removeConsole(Console console) {
        this.consoles.remove(console);
    }

    public boolean containConsole(String name) {
        for (Console c : consoles) {
            if (c.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Console getConsole(String name) {
        for (Console c : consoles) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

}
