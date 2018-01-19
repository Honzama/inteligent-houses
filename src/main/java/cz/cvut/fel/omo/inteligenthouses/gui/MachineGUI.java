package cz.cvut.fel.omo.inteligenthouses.gui;

//import static cz.cvut.fel.omo.inteligenthouses.gui.Dialog.WIDTH;
import cz.cvut.fel.omo.inteligenthouses.gui.controllers.MachineGUIController;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Item;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Sensor;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.State;
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
import javax.swing.ComboBoxModel;
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
@SuppressWarnings({"rawtypes", "unchecked", "serial"})
public class MachineGUI extends Dialog {

    private JLabel labelSpeciman;
    private JLabel labelSpecimanInfo;
    private JLabel labelMachine;
    private JLabel labelMachineInfo;
    private JLabel labelSensors;
    private JLabel labelItems;
    private JLabel labelState;
    private JLabel labelPosition;
    private JLabel labelEmpty1;
    private JLabel labelEmpty2;
    private JLabel labelTitle;

	private JComboBox comboBoxSensor;
    private JComboBox comboBoxItem;
    private JComboBox comboBoxState;
    private JComboBox comboBoxPosition;

    private JButton buttonSensors;
    private JButton buttonItems;
    private JButton buttonState;
    private JButton buttonPosition;

    private JPanel panelAbout;
    private JPanel panelAction;

    private final int HGAP = 15;
    private final int VGAP = 5;

    private static final String TITLE = "Machine";

    private final Dimension MINIMUM_SIZE = new Dimension(WIDTH, HEIGHT);

    private final Specimen speciman;
    private final Machine machine;
    private final State state;
    private final Position position;

    private List<Sensor> sensors = new ArrayList<>();
    private List<String> sensorNames = new ArrayList<>();

    private List<Item> items = new ArrayList<>();
    private List<String> itemNames = new ArrayList<>();

    private List<State> states = new ArrayList<>();
    private List<String> stateNames = new ArrayList<>();

    private List<Position> positions = new ArrayList<>();
    private List<String> positionNames = new ArrayList<>();

    public MachineGUI(Frame parent, boolean modal, String title, int height, int width) {
        super(parent, modal, title, height, width);
        this.speciman = null;
        this.machine = null;
        this.state = null;
        this.position = null;
        this.setMinimumSize(MINIMUM_SIZE);
        initComponents();
    }

    public MachineGUI(Frame parent, boolean modal, Specimen speciman, Machine machine) {
        super(parent, modal, TITLE);
        this.speciman = speciman;
        this.machine = machine;
        this.state = machine.getState();
        this.position = machine.getPosition();
        this.setMinimumSize(MINIMUM_SIZE);
        initComponents();
    }

    private void initComponents() {
        if (speciman == null || machine == null) {
            System.exit(0);
        }

        labelSpeciman = new JLabel();
        labelSpecimanInfo = new JLabel();
        labelMachine = new JLabel();
        labelMachineInfo = new JLabel();
        labelSensors = new JLabel();
        labelItems = new JLabel();
        labelState = new JLabel();
        labelPosition = new JLabel();
        labelEmpty1 = new JLabel();
        labelEmpty2 = new JLabel();
        labelTitle = new JLabel();

        comboBoxSensor = new JComboBox();
        comboBoxItem = new JComboBox();
        comboBoxState = new JComboBox();
        comboBoxPosition = new JComboBox();

        buttonSensors = new JButton();
        buttonItems = new JButton();
        buttonState = new JButton();
        buttonPosition = new JButton();

        panelAbout = new JPanel();
        panelAction = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        setComboBoxes();

        panelAbout.setBorder(BorderFactory.createTitledBorder(null, "About", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        labelSpeciman.setText("Speciman");
        labelSpecimanInfo.setText(MachineGUIController.getSpecimanName(speciman));

        labelEmpty1.setText(" ");
        labelEmpty2.setText(" ");

        labelMachine.setText("Machine");
        labelMachineInfo.setText(MachineGUIController.getMachineName(machine));

        labelSensors.setText("Sensors");
        buttonSensors.setText("Show");
        buttonSensors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSensorsActionPerformed(evt);
            }
        });

        labelItems.setText("Items");
        buttonItems.setText("Show");
        buttonItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonItemsActionPerformed(evt);
            }
        });

        GridLayout panelAboutLayout = new GridLayout(4, 3);
        panelAbout.setLayout(panelAboutLayout);

        panelAbout.add(labelSpeciman);
        panelAbout.add(labelSpecimanInfo);
        panelAbout.add(labelEmpty1);

        panelAbout.add(labelMachine);
        panelAbout.add(labelMachineInfo);
        panelAbout.add(labelEmpty2);

        panelAbout.add(labelSensors);
        panelAbout.add(comboBoxSensor);
        panelAbout.add(buttonSensors);

        panelAbout.add(labelItems);
        panelAbout.add(comboBoxItem);
        panelAbout.add(buttonItems);

//------------------------------------------------------------------------------
        panelAction.setBorder(BorderFactory.createTitledBorder(null, "Action", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        labelState.setText("State");
        buttonState.setText("Change");
        buttonState.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonStateActionPerformed(evt);
            }
        });

        labelPosition.setText("Position");
        buttonPosition.setText("Change");
        buttonPosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonPositionActionPerformed(evt);
            }
        });

        GridLayout panelActionLayout = new GridLayout(2, 3);
        panelAction.setLayout(panelActionLayout);

        panelAction.add(labelState);
        panelAction.add(comboBoxState);
        panelAction.add(buttonState);

        panelAction.add(labelPosition);
        panelAction.add(comboBoxPosition);
        panelAction.add(buttonPosition);

//------------------------------------------------------------------------------
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

    private void buttonSensorsActionPerformed(ActionEvent evt) {
        //TODO open new dialog with info about given sensor
        int index = comboBoxSensor.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no sensor to show.", "No sensor to show", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void buttonItemsActionPerformed(ActionEvent evt) {
        //TODO open new dialog with info about given sensor (well maybe we don't need it)
        int index = comboBoxItem.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no item to show.", "No item to show", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void buttonStateActionPerformed(ActionEvent evt) {
        //TODO change state of a machine
        int index = comboBoxState.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no state to change.", "No state to change", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void buttonPositionActionPerformed(ActionEvent evt) {
        //TODO move machine to different location
        int index = comboBoxPosition.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "There is no position to move this machine to.", "No position avaiable", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void setComboBoxes() {
        setComboBoxSensor();
        setComboBoxItem();
        setComboBoxState();
        setComboBoxPosition();
    }

	private void setComboBoxSensor() {
        sensors = MachineGUIController.getSensors(machine);
        sensorNames = sensors
                .stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
        comboBoxSensor.setModel(new DefaultComboBoxModel(sensorNames.toArray()));
    }

    private void setComboBoxItem() {
        items = MachineGUIController.getItems(machine);
        itemNames = items
                .stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
        comboBoxItem.setModel(new DefaultComboBoxModel(itemNames.toArray()));
    }

    private void setComboBoxState() {
        //should work the same way as position (below)
        states = MachineGUIController.getStates();
        stateNames = states
                .stream()
                .map(d -> d.getState())
                .collect(Collectors.toList());
        comboBoxState.setModel(new DefaultComboBoxModel(stateNames.toArray()));
        if (!stateNames.isEmpty()) {
            comboBoxState.setSelectedIndex(states.indexOf(state));
        }
    }

    private void setComboBoxPosition() {
        //just for fake data
        positions = MachineGUIController.getPositions(position);
        //positions = MachineGUIController.getPositions();
        positionNames = positions
                .stream()
                .map(d -> d.getAddress())
                .collect(Collectors.toList());
        ComboBoxModel model = new DefaultComboBoxModel(positionNames.toArray());
        comboBoxPosition.setModel(model);
//        System.out.println(model.getSelectedItem());
        if (!positionNames.isEmpty()) {
            comboBoxPosition.setSelectedIndex(positions.indexOf(position));
//            System.out.println(positions.indexOf(position));
        }
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

                MachineGUI dialog = new MachineGUI(new JFrame(), true, TITLE, HEIGHT, WIDTH);
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
