package cz.cvut.fel.omo.inteligenthouses.gui;

import cz.cvut.fel.omo.inteligenthouses.gui.controllers.SpecimanGUIController;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kahoumic
 */
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class SpecimanGUI extends Dialog {

    Frame parent;

    private JButton buttonMachine;
    private JButton buttonSpeciman;
    private JComboBox<String> comboBoxSpeciman;
    private JComboBox<String> comboBoxMachine;
    private JLabel labelChangePosition;
    private JComboBox<String> comboBoxChangePosition;
    private JButton buttonChangePosition;
    private JLabel labelMachine;
    private JLabel labelName;
    private JLabel labelNameInfo;
    private JLabel labelPosition;
    private JLabel labelPositionInfo;
    private JLabel labelSpecies;
    private JLabel labelSpeciesInfo;
    private JLabel labelSpeciman;
    private JLabel labelTitle;
    private JPanel panelAbout;
    private JPanel panelAction;

    private final int HGAP = 15;
    private final int VGAP = 5;

    private static final String TITLE = "Speciman";

    private final Dimension MINIMUM_SIZE = new Dimension(WIDTH, HEIGHT);

    private final Specimen speciman;
    private Position position;

    private List<Machine> machines = new ArrayList<>();
    private List<String> machineNames = new ArrayList<>();
    private List<Specimen> specimen = new ArrayList<>();
    private List<String> specimanNames = new ArrayList<>();
    private List<Position> positions = new ArrayList<>();
    private List<String> positionNames = new ArrayList<>();

    public SpecimanGUI(Frame parent, boolean modal, String title, int height, int width) {
        super(parent, modal, title, height, width);
        this.parent = parent;
        this.setMinimumSize(MINIMUM_SIZE);
        this.speciman = null;
        initComponents();
    }

    public SpecimanGUI(Frame parent, boolean modal, Specimen speciman) {
        super(parent, modal, TITLE);
        this.parent = parent;
        this.setMinimumSize(MINIMUM_SIZE);
        this.speciman = speciman;
        this.position = speciman.getActualPosition();
        initComponents();
    }

    private void initComponents() {

        if (speciman == null) {
            System.exit(0);
        }

        labelTitle = new JLabel();
        panelAbout = new JPanel();
        labelSpecies = new JLabel();
        labelSpeciesInfo = new JLabel();
        labelName = new JLabel();
        labelNameInfo = new JLabel();
        labelPosition = new JLabel();
        labelPositionInfo = new JLabel();
        panelAction = new JPanel();
        labelMachine = new JLabel();
        comboBoxMachine = new JComboBox<>();
        buttonMachine = new JButton();
        labelSpeciman = new JLabel();
        comboBoxSpeciman = new JComboBox<>();
        buttonSpeciman = new JButton();
        labelChangePosition = new JLabel();
        comboBoxChangePosition = new JComboBox<>();
        buttonChangePosition = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelAbout.setBorder(BorderFactory.createTitledBorder(null, "About", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        labelSpecies.setText("Species");

        labelSpeciesInfo.setText(SpecimanGUIController.getSpecimanSpecies(speciman));

        labelName.setText("Name");

        labelNameInfo.setText(SpecimanGUIController.getSpecimanName(speciman));

        labelPosition.setText("Position");

        labelPositionInfo.setText(SpecimanGUIController.getSpecimanPosition(speciman));

        GridLayout panelAboutLayout = new GridLayout(3, 2);
        panelAbout.setLayout(panelAboutLayout);
        panelAboutLayout.setHgap(HGAP);
        panelAboutLayout.setVgap(VGAP);

        panelAbout.add(labelSpecies);
        panelAbout.add(labelSpeciesInfo);

        panelAbout.add(labelName);
        panelAbout.add(labelNameInfo);

        panelAbout.add(labelPosition);
        panelAbout.add(labelPositionInfo);

        //----------------------------------------------------------------------
        panelAction.setBorder(BorderFactory.createTitledBorder(null, "Action", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        labelMachine.setText("Machine");

        setComboBoxMachine();
//        comboBoxMachine.setModel(new DefaultComboBoxModel(machineNames.toArray()));

        buttonMachine.setText("Manage");
        buttonMachine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonMachineActionPerformed(evt);
            }
        });

        labelSpeciman.setText("Speciman");

        setComboBoxSpeciman();
//        comboBoxSpeciman.setModel(new DefaultComboBoxModel(specimanNames.toArray()));

        buttonSpeciman.setText("Interact");
        buttonSpeciman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSpecimanActionPerformed(evt);
            }
        });

        labelChangePosition.setText("Change position to");

        setComboBoxChangePosition();
//        comboBoxChangePosition.setModel(new DefaultComboBoxModel(positionNames.toArray()));

        buttonChangePosition.setText("Go");
        buttonChangePosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonChangePositionActionPerformed(evt);
            }
        });

        GridLayout panelActionLayout = new GridLayout(3, 3);
        panelAction.setLayout(panelActionLayout);
        panelActionLayout.setHgap(HGAP);
        panelActionLayout.setVgap(VGAP);

        panelAction.add(labelMachine);
        panelAction.add(comboBoxMachine);
        panelAction.add(buttonMachine);

        panelAction.add(labelSpeciman);
        panelAction.add(comboBoxSpeciman);
        panelAction.add(buttonSpeciman);

        panelAction.add(labelChangePosition);
        panelAction.add(comboBoxChangePosition);
        panelAction.add(buttonChangePosition);

        //----------------------------------------------------------------------
        GridLayout layout = new GridLayout(3, 1);
        getContentPane().setLayout(layout);

        labelTitle.setFont(TITLE_FONT);
        labelTitle.setText(TITLE);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);

        layout.setHgap(HGAP);
        layout.setVgap(VGAP);

        getContentPane().add(labelTitle);
        getContentPane().add(panelAbout);
        getContentPane().add(panelAction);

        pack();
    }

    private void buttonMachineActionPerformed(ActionEvent evt) {
        //TODO open machine dialog
        int index = comboBoxMachine.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no machine to manage.", "No machine to manage", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Machine m = machines.get(index);

        MachineGUI window = new MachineGUI(parent, true, speciman, m);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void buttonSpecimanActionPerformed(ActionEvent evt) {
        //TODO open speciman interaction dialog
        int index = comboBoxSpeciman.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no one to interact with.", "No one to interact with", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void buttonChangePositionActionPerformed(ActionEvent evt) {
        int index = comboBoxChangePosition.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no place to go.", "No place to go", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int choice = JOptionPane.showConfirmDialog(
                this, "Do you want to change position?", "Change position", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION) {
            Position newPosition = positions.get(comboBoxChangePosition.getSelectedIndex());
            SpecimanGUIController.changePosition(speciman, newPosition);
            labelPositionInfo.setText(SpecimanGUIController.getSpecimanPosition(speciman));
        }
    }
    
    private void setComboBoxMachine() {
        machines = SpecimanGUIController.getMachines(position);
        machineNames = machines
                .stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
        comboBoxMachine.setModel(new DefaultComboBoxModel(machineNames.toArray()));
    }

	private void setComboBoxSpeciman() {
        specimen = SpecimanGUIController.getSpecimen(speciman);
        specimanNames = specimen
                .stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
        comboBoxSpeciman.setModel(new DefaultComboBoxModel(specimanNames.toArray()));
    }

	private void setComboBoxChangePosition() {
        positions = SpecimanGUIController.getPositions(position);
        positionNames = positions
                .stream()
                .map(p -> p.getAddress())
                .collect(Collectors.toList());
        comboBoxChangePosition.setModel(new DefaultComboBoxModel(positionNames.toArray()));
    }

    public static void main(String args[]) {
        /*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                SpecimanGUI dialog = new SpecimanGUI(new JFrame(), true, TITLE, HEIGHT, WIDTH);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
