package cz.cvut.fel.omo.inteligenthouses.report;

/**
 * Represents names of reports
 * @author kahoumic
 */
public enum ReportEnum {

    HOUSE_CONFIG_REPORT ("House Config Report"),
    EVENT_REPORT ("Event Report"),
    ACTIVITY_AND_USAGE_REPORT ("Activity And Usage Report"),
    CONSUPTION_REPORT ("Consuption Report"),
    SAVINGS_REPORT ("Savings Report");
        
    private final String name;
    
    ReportEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     *
     * @param index index of desired item in enum
     * @return ReportEnum on given index
     */
    public static ReportEnum get(int index) {
        return ReportEnum.values()[index];
    }
}
