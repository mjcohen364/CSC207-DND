package view;

import interface_adapter.ItemController;
import interface_adapter.ItemState;
import interface_adapter.ItemViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ItemView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "item";

    private final ItemViewModel itemViewModel;
    private final JTextField apiInputField = new JTextField(15);
    private final JButton itemAdd;

    private final ItemController itemController;

    public ItemView(ItemController controller,
                      ItemViewModel itemViewModel) {

        this.itemController = controller;
        this.itemViewModel = itemViewModel;
        itemViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel apiInfo = new LabelTextPanel(
                new JLabel(ItemViewModel.ITEM_LABEL), apiInputField);

        JPanel buttons = new JPanel();
        itemAdd = new JButton(ItemViewModel.ITEM_ADD_BUTTON_LABEL);
        buttons.add(itemAdd);

        itemAdd.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(itemAdd)) {
                            ItemState currentState = itemViewModel.getState();

                            itemController.execute(currentState.getApi());
                        }
                    }
                }
        );


        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        apiInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ItemState currentState = itemViewModel.getState();
                        String text = apiInputField.getText() + e.getKeyChar();
                        currentState.setApi(text);
                        itemViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(apiInfo);

        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getNewValue() instanceof ItemState) {
            ItemState state = (ItemState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getName() + state.getQuantity());

        }
    }
}