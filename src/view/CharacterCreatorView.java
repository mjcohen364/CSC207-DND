package view;

import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassState;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.race.RaceController;
import interface_adapter.race.RaceState;
import interface_adapter.race.RaceViewModel;
import interface_adapter.background.BackgroundController;
import interface_adapter.background.BackgroundState;
import interface_adapter.background.BackgroundViewModel;

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
    private final RaceViewModel raceViewModel;
    private final RaceController raceController;
    private final BackgroundViewModel backgroundViewmodel;
    private final BackgroundController backgroundController;

    private JLabel items;
//    private final JButton chooseBackground;

    public CharacterCreatorView(InventoryController controller,
                                InventoryViewModel inventoryViewModel,
                                ClassController classController,
                                ClassViewModel classViewModel,
                                RaceController raceController, RaceViewModel raceViewModel,
                                BackgroundController backgroundController, BackgroundViewModel backgroundViewModel) {

        this.inventoryController = controller;
        this.inventoryViewModel = inventoryViewModel;
        this.classController = classController;
        this.classViewModel = classViewModel;
        this.raceController = raceController;
        this.raceViewModel = raceViewModel;
        this.backgroundController = backgroundController;
        this.backgroundViewmodel = backgroundViewModel;
        inventoryViewModel.addPropertyChangeListener(this);
        classViewModel.addPropertyChangeListener(this);
        raceViewModel.addPropertyChangeListener(this);
        backgroundViewmodel.addPropertyChangeListener(this);


        items = new JLabel();
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel title = new JLabel(InventoryViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create buttons for choosing class
        raceController.execute();

        JPanel buttons = new JPanel();
        JButton chooseBackground = new JButton("Background");
        buttons.add(chooseBackground);

        chooseBackground.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        backgroundController.execute();
                    }
                }
        );
        JButton chooseClass = new JButton("Class");
        buttons.add(chooseClass);

        chooseClass.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {classController.execute();}
                }
        );

        JButton chooseRace = new JButton("Race");
        buttons.add(chooseRace);

        chooseRace.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {raceController.execute();}
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(buttons);
        this.add(title);
        this.add(items);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {}
}