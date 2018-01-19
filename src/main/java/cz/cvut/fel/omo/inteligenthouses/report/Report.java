package cz.cvut.fel.omo.inteligenthouses.report;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Represents a report
 * @author macekja7
 */
public abstract class Report {
    
    //report names
    public static final String eventReport = "Event_Report";
    public static final String houseReport = "House_Configuration_Report";
    public static final String specimenReport = "Activity_And_Usage_Report";
    public static final String consumptionReport = "Consumption_Report";
    public static final String savingReport = "SavingsReport";
    /**
     * Extention of file with report
     */
    public static final String fileExtension = ".txt";

    /**
     * Creates new Report
     */
    public Report() {

    }

    /**
     * Saves a report to a file with <code>fileExtention</code>
     * @param name name of the report
     * @param list list of strings to be saved (report)
     */
    public void saveReport(String name, List<String> list) {
        File reportFile = new File(name + getSystemDate() + fileExtension);
        System.out.println(name + " file is saved with name \"" + name + getSystemDate() + fileExtension + "\"");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
            for (String s : list) {
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return date in format _yyyyMMdd_HHmmss
     */
    public String getSystemDate() {
        return (new SimpleDateFormat("_yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
    }
}
