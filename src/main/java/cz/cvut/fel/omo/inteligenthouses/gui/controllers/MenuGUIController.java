package cz.cvut.fel.omo.inteligenthouses.gui.controllers;

import cz.cvut.fel.omo.inteligenthouses.report.ReportEnum;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Animal;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kahoumic
 */
public class MenuGUIController {
    public static List<Specimen> getSpecimen() {
        //TODO put actual data here pls (after solving games with json)
        List<Specimen> ss = new ArrayList<>();
        //ss.add(new Animal("Alik", new House("doma")));
        //ss.add(new Person("Petr", new Outside("venku")));
        //ss.add(new Animal("Julca", new Outside("jinde venku")));
        return ss;
    }
    
    public static List<String> getReportTypes() {
        List<String> list = new ArrayList<>();
        for (ReportEnum e : ReportEnum.values()) {
            list.add(e.getName());
        }
        return list;
    }
    
    /**
     * 
     * @param reportType
     * @return <code>true</code> iff report successfully generated 
     */
    public static boolean generateReport(ReportEnum reportType) {
        //TODO
        System.out.println(reportType.getName());
        return true;
    }
}
