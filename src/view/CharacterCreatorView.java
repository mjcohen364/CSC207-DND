package view;

import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassState;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;

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

    public CharacterCreatorView(InventoryController controller,
                                InventoryViewModel inventoryViewModel,
                                ClassController classController,
                                ClassViewModel classViewModel) {

        this.inventoryController = controller;
        this.inventoryViewModel = inventoryViewModel;
        this.classController = classController;
        this.classViewModel = classViewModel;
        inventoryViewModel.addPropertyChangeListener(this);
        classViewModel.addPropertyChangeListener(this);


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