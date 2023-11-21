package view;

import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassState;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.race.RaceController;
import interface_adapter.race.RaceViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CharacterCreatorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "character creator";

    private final InventoryViewModel inventoryViewModel;
    private final InventoryController inventoryController;


    private final ClassViewModel classViewModel;
    private final ClassController classController;

    private JLabel items;

    private RaceViewModel raceViewModel;
    private RaceController raceController;
    //private JPanel raceButtonsPanel;

    private JTabbedPane tabbedPane;

    public CharacterCreatorView(InventoryController controller,
                                InventoryViewModel inventoryViewModel,
                                ClassController classController,
                                ClassViewModel classViewModel,
                                RaceController raceController,
                                RaceViewModel raceViewModel) {

        this.inventoryController = controller;
        this.inventoryViewModel = inventoryViewModel;
        this.classController = classController;
        this.classViewModel = classViewModel;
        this.raceController = raceController;
        this.raceViewModel = raceViewModel;

        tabbedPane = new JTabbedPane();
        // Set up the race tab
        initRaceTab();

        // Add the tabbed pane to the view
        this.add(tabbedPane);

        inventoryViewModel.addPropertyChangeListener(this);
        classViewModel.addPropertyChangeListener(this);

       // raceButtonsPanel = new JPanel(new FlowLayout());
      //  this.add(raceButtonsPanel);

      //  createRaceButtons();


        items = new JLabel();
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel title = new JLabel(InventoryViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create buttons for choosing class
        classController.execute();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(items);

    }
   /* private void createRaceButtons() {
        raceController.loadRaces(); // This should be async in a real app
        for (String raceName : raceViewModel.getRaceNames()) {
            JButton raceButton = new JButton(raceName);
            raceButton.addActionListener(e -> raceController.selectRace(raceName));
            raceButtonsPanel.add(raceButton);
        }
    } */

    private void initRaceTab() {
        // Panel that will contain the race buttons
        JPanel racePanel = new JPanel();
        racePanel.setLayout(new FlowLayout()); // Or any other layout you prefer

        // Assuming raceController.loadRaces() has been called and raceViewModel has the data
        for (String raceName : raceViewModel.getRaceNames()) {
            JButton raceButton = new JButton(raceName);
            raceButton.addActionListener(e -> raceController.selectRace(raceName));
            racePanel.add(raceButton);
        }

        // Add the race panel as a tab
        tabbedPane.addTab("Races", null, racePanel, "Choose your race");
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getNewValue() instanceof InventoryState) {
            InventoryState state = (InventoryState) evt.getNewValue();

            items.setText("");
            for (int i = 0; i < state.items.size(); i++) {
                items.setText(items.getText() + "    " + state.items.get(i));
            }
            revalidate();
            repaint();

        }

        if (evt.getNewValue() instanceof ClassState) {
            ClassState state = (ClassState) evt.getNewValue();

            JPanel buttons = new JPanel();
            for (String className: state.classes) {
                JButton classAdd = new JButton(className);
                buttons.add(classAdd);


                classAdd.addActionListener(
                        // This creates an anonymous subclass of ActionListener and instantiates it.
                        new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                if (evt.getSource().equals(classAdd)) {
                                    inventoryController.execute("/api/classes/" + className.toLowerCase());
                                }
                            }
                        }
                );


            }
            this.add(buttons);
            revalidate();
            repaint();

        }
    }
}