package cz.cvut.fel.omo.inteligenthouses.gui;

import cz.cvut.fel.omo.inteligenthouses.gui.controllers.MenuGUIController;
import cz.cvut.fel.omo.inteligenthouses.report.ReportEnum;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
*
* @author kahoumic
*/
@SuppressWarnings({ "rawtypes", "unchecked", "serial", "unused" })
public class MenuGUI extends GUI {

    private JButton buttonChooseFile;
    private JButton buttonGenerate;
    private JButton buttonPerson;
    private JComboBox<String> comboBoxSpeciman;
    private JComboBox<String> comboBoxReport;
    private JLabel labelPerson;
    private JPanel panelReport;
    private JLabel labelConfigFile;
    private JLabel labelFileName;
    private JLabel labelGenerate;
    private JLabel labelTitle;
    private JPanel panelConfiguration;
    private JPanel panelMenu;

    private final int HGAP = 15;
    private final int VGAP = 5;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    private final Dimension MINIMUM_SIZE = new Dimension(WIDTH, HEIGHT);

    private List<Specimen> specimen = new ArrayList<>();
    private List<String> specimanNames = new ArrayList<>();
    private List<String> reportTypes = new ArrayList<>();

    private static final String REPORT_SUFFIX = "txt";
    //TODO change to json
    private static final String CONFIG_SUFFIX = "jpg";

    public MenuGUI(String title, int height, int width) {
        super(title, height, width);
        this.setMinimumSize(MINIMUM_SIZE);
        //setmaxsize?
        initComponents();
//        specimen.add(new Person("tata", new Outside("out")));
    }

    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        panelConfiguration = new JPanel();
        labelConfigFile = new JLabel();
        buttonChooseFile = new JButton();
        labelFileName = new JLabel();
        panelMenu = new JPanel();
        labelPerson = new JLabel();
        buttonPerson = new JButton();
        comboBoxSpeciman = new JComboBox<>();
        panelReport = new JPanel();
        labelGenerate = new JLabel();
        comboBoxReport = new JComboBox<>();
        buttonGenerate = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelConfiguration.setBorder(BorderFactory.createTitledBorder(null, "Configuration", TitledBorder.LEFT, TitledBorder.TOP));

        labelConfigFile.setText("Config file");

        buttonChooseFile.setText("Choose a file");
        buttonChooseFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonChooseFileActionPerformed(evt);
            }
        });

        labelFileName.setText("...");

        GridLayout panelConfigurationLayout = new GridLayout(0, 3);
        panelConfigurationLayout.setHgap(HGAP);
        panelConfigurationLayout.setVgap(VGAP);
        panelConfiguration.setLayout(panelConfigurationLayout);
        panelConfiguration.add(labelConfigFile);
        panelConfiguration.add(buttonChooseFile);
        panelConfiguration.add(labelFileName);

        //------------------------------------------------------------------------------------------------------------
        panelMenu.setBorder(BorderFactory.createTitledBorder("Simulation"));

        labelPerson.setText("Take control over");

        buttonPerson.setText("now");
        buttonPerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonPersonActionPerformed(evt);
            }
        });

        comboBoxSpeciman.setModel(new DefaultComboBoxModel<>());

        GridLayout panelMenuLayout = new GridLayout(0, 3);
        panelMenuLayout.setHgap(HGAP);
        panelMenuLayout.setVgap(VGAP);
        panelMenu.setLayout(panelMenuLayout);
        panelMenu.add(labelPerson);
        panelMenu.add(comboBoxSpeciman);
        panelMenu.add(buttonPerson);

        //------------------------------------------------------------------------------------------------------------
        panelReport.setBorder(BorderFactory.createTitledBorder(null, "Reporting", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        labelGenerate.setText("Generate");

        comboBoxReport.setModel(new DefaultComboBoxModel<>());

        buttonGenerate.setText("now");
        buttonGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        GridLayout panelReportLayout = new GridLayout(0, 3);
        panelReportLayout.setHgap(HGAP);
        panelReportLayout.setVgap(VGAP);
        panelReport.setLayout(panelMenuLayout);
        panelReport.add(labelGenerate);
        panelReport.add(comboBoxReport);
        panelReport.add(buttonGenerate);

        //------------------------------------------------------------------------------------------------------------
        GridLayout layout = new GridLayout(4, 0);
        layout.setHgap(HGAP);
        layout.setVgap(VGAP);

        labelTitle.setFont(TITLE_FONT);
        labelTitle.setText("Menu");
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().setLayout(layout);
        getContentPane().add(labelTitle);
        getContentPane().add(panelConfiguration);
        getContentPane().add(panelMenu);
        getContentPane().add(panelReport);

        pack();
    }

    private void buttonChooseFileActionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", CONFIG_SUFFIX);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            labelFileName.setText(chooser.getSelectedFile().getName());
            String path = chooser.getCurrentDirectory().toString();
            String fileName = chooser.getSelectedFile().getName();
            System.out.println(path + " " + fileName);
            //TODO predat informaci o konfiguraci!!!
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            buttonChooseFile.setEnabled(false);
            setComboBoxes();
        }
    }

    private void buttonPersonActionPerformed(ActionEvent evt) {
        int index = comboBoxSpeciman.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no person to take control over.", "No one here", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Specimen s = specimen.get(index);

        SpecimanGUI window = new SpecimanGUI(this, true, s);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void buttonGenerateActionPerformed(ActionEvent evt) {
        int index = comboBoxReport.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no report to be generated.", "No report to be generated", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", REPORT_SUFFIX);
        chooser.setFileFilter(filter);

        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getCurrentDirectory().toString();
            String fileName = chooser.getSelectedFile().getName();
//            System.out.println(path + " " + fileName);
            //TODO predat informaci o ceste k souboru!!!
            System.out.println("You chose save to this file: " + chooser.getSelectedFile().getName());
            //TODO iff save successful
            if (MenuGUIController.generateReport(ReportEnum.get(index))) {
                JOptionPane.showMessageDialog(this,
                        "The report is saved in " + path + "\\" + fileName + "." + REPORT_SUFFIX,
                        "Report",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "An error occurred. Sorry.",
                        "Report error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void setComboBoxes() {
        setSpecimenComboBox();
        setReportComboBox();
    }

    private void setSpecimenComboBox() {
        specimen = MenuGUIController.getSpecimen();
        specimanNames = specimen
                .stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
        comboBoxSpeciman.setModel(new DefaultComboBoxModel(specimanNames.toArray()));
    }

    private void setReportComboBox() {
        reportTypes = MenuGUIController.getReportTypes();
        comboBoxReport.setModel(new DefaultComboBoxModel(reportTypes.toArray()));
    }

    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
				MenuGUI window = new MenuGUI("Menu", HEIGHT, WIDTH);
            }
        });
    }
}
