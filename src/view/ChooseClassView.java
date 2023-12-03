package view;

import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.dnd_class.ClassState;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import view.ViewManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChooseClassView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Class";
    private final InventoryController inventoryController;
    private final InventoryViewModel inventoryViewModel;
    private final ClassViewModel classViewModel;
    private final CharacterCreatorController characterCreatorController;
    private boolean classChoicesAdded = false;
    final JButton mainScreen;
    private JLabel items;

    ArrayList<JButton> classButtons = new ArrayList<>();

    public ChooseClassView(InventoryController inventoryController, InventoryViewModel inventoryViewModel,
                           CharacterCreatorController characterCreatorController, ClassViewModel classViewModel) {
        this.inventoryController = inventoryController;
        this.inventoryViewModel = inventoryViewModel;
        this.characterCreatorController = characterCreatorController;
        this.classViewModel = classViewModel;
        this.inventoryViewModel.addPropertyChangeListener(this);
        this.classViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Choose Class");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        items = new JLabel("Click a class to see its starting items!");
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel inventoryTitle = new JLabel(InventoryViewModel.TITLE_LABEL);
        inventoryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        mainScreen = new JButton(classViewModel.MAIN_SCREEN_LABEL);
        buttons.add(mainScreen);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(buttons);
        this.add(inventoryTitle);
        this.add(items);

        mainScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainScreen)) {
                            ClassState currentState = classViewModel.getState();
                            characterCreatorController.execute();
                        }
                    }
                }
        );
    }
    //    TODO FINISH ACTIONPERFORMED
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "[NOT SURE WHAT TO PUT HERE YET]");
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

            JPanel buttons2 = new JPanel();
            for (String className: state.classes) {
                JButton classAdd = new JButton(className);
                buttons2.add(classAdd);
                classButtons.add(classAdd);

                if (className.toLowerCase().equals(state.selected)) {
                    classAdd.setBackground(Color.GREEN);
                }

                classAdd.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                for (JButton butt: classButtons) {
                                    butt.setBackground(UIManager.getColor("Panel.background"));

                                }
                                classAdd.setBackground(Color.GREEN);
                                if (evt.getSource().equals(classAdd)) {
                                    inventoryController.execute("/api/classes/" + className.toLowerCase());
                                }
                            }
                        }
                );
            }
            buttons2.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (!this.classChoicesAdded){
                this.add(buttons2, 1);
            }
            this.classChoicesAdded = true;
//            revalidate();
//            repaint();
        }
    }
}