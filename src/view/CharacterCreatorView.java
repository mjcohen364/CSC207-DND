package view;

import interface_adapter.character_name.CharacterNameController;
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
import interface_adapter.return_to_name.ReturnToNameController;

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
    private final ReturnToNameController returnToNameController;

    private JLabel items;
//    private final JButton chooseBackground;

    public CharacterCreatorView(InventoryController controller,
                                InventoryViewModel inventoryViewModel,
                                ClassController classController,
                                ClassViewModel classViewModel,
                                RaceController raceController, RaceViewModel raceViewModel,
                                BackgroundController backgroundController,
                                BackgroundViewModel backgroundViewModel,
                                ReturnToNameController returnToNameController) {

        this.inventoryController = controller;
        this.inventoryViewModel = inventoryViewModel;
        this.classController = classController;
        this.classViewModel = classViewModel;
        this.raceController = raceController;
        this.raceViewModel = raceViewModel;
        this.backgroundController = backgroundController;
        this.backgroundViewmodel = backgroundViewModel;
        this.returnToNameController = returnToNameController;
        inventoryViewModel.addPropertyChangeListener(this);
        classViewModel.addPropertyChangeListener(this);
        raceViewModel.addPropertyChangeListener(this);
        backgroundViewmodel.addPropertyChangeListener(this);

        //create buttons for choosing class
        //Jun: actually, don't do that because I use .execute to color in a button for which option was selected
        //Everything still works but the window is smaller, so this is to enlarge the window:
        setPreferredSize(new Dimension(1000, 500));
        //classController.execute();
        //raceController.execute();

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

        JButton returnToNameScreen = new JButton("Return to Name Screen");
        buttons.add(returnToNameScreen);

        returnToNameScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {returnToNameController.execute();}
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(buttons);

        JPanel buttons2 = new JPanel();
        JButton characterAdd = new JButton("Add new Character");
        JButton characterChange = new JButton("Edit another Character");
        buttons2.add(characterAdd);
        buttons2.add(characterChange);

        characterAdd.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(characterAdd)) {
                            LoggedInController.execute("Add Character");
                        }
                    }
                }
        );
        characterChange.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(characterChange)) {
                            LoggedInController.execute("Change Character");
                        }
                    }
                }
        );
        this.add(buttons2);
        revalidate();
        repaint();

        JPanel buttons2 = new JPanel();
        JButton characterAdd = new JButton("Add new Character");
        JButton characterChange = new JButton("Edit another Character");
        buttons2.add(characterAdd);
        buttons2.add(characterChange);

        characterAdd.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(characterAdd)) {

                        }
                    }
                }
        );
        characterChange.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(characterChange)) {

                        }
                    }
                }
        );
        this.add(buttons2);
        revalidate();
        repaint();

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof LoggedInState) {
            LoggedInState state = (LoggedInState) evt.getNewValue();

        }
    }
}