package view;

import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.character_name.CharacterNameViewModel;
import interface_adapter.clear_characters.ClearController;
import interface_adapter.clear_characters.ClearState;
import interface_adapter.clear_characters.ClearViewModel;
import interface_adapter.character_name.CharacterNameController;
import interface_adapter.character_name.CharacterNameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class CharacterNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Name a Character!";
    private final CharacterNameViewModel characterNameViewModel;
    private final CharacterNameController characterNameController;
    private final CharacterCreatorController characterCreatorController;
    private final JTextField nameInputField = new JTextField(15);
    private final ClearController clearController;
    private final ClearViewModel clearViewModel;

    private final JButton createCharacterName;
    private final JButton cancel;
    private final JButton clear;
    private final JButton editCharacter;
    private boolean nameChoicesAdded;

    public CharacterNameView(CharacterNameController characterNameController, CharacterCreatorController characterCreatorController, CharacterNameViewModel characterNameViewModel, ClearController clearController, ClearViewModel clearViewModel) {

        this.characterCreatorController = characterCreatorController;
        this.characterNameViewModel = characterNameViewModel;
        this.characterNameController = characterNameController;
        this.clearController = clearController;
        this.clearViewModel = clearViewModel;
        characterNameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CharacterNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(CharacterNameViewModel.NAME_LABEL), nameInputField);

        JPanel buttons = new JPanel();
        //This button starts editing a new character (send to character creator view)
        createCharacterName = new JButton(CharacterNameViewModel.CREATECHARACTERNAME_BUTTON_LABEL);
        buttons.add(createCharacterName);

        cancel = new JButton(CharacterNameViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        clear = new JButton(CharacterNameViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);

        editCharacter = new JButton(CharacterNameViewModel.EDIT_BUTTON_LABEL);
        buttons.add(editCharacter);

        createCharacterName.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createCharacterName)) {
                            CharacterNameState currentState = characterNameViewModel.getState();
                            characterNameController.execute(currentState.getName());
                            characterCreatorController.execute();
                        }
                    }
                }
        );

        // TODO Add the body to the actionPerformed method of the action listener below
        //      for the "clear" button. You'll need to write the controller before
        //      you can complete this.
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(clear)) {
                            clearController.execute();
                            ClearState currentState = clearViewModel.getState();
                            Set names = currentState.getNames();
                            String message = String.join("\n", names);
                            JOptionPane.showMessageDialog(new JFrame("Message"), message);
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the nameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CharacterNameState currentState = characterNameViewModel.getState();
                        String text = nameInputField.getText() + e.getKeyChar();
                        currentState.setName(text);
                        characterNameViewModel.setState(currentState);
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
        this.add(nameInfo);
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
        CharacterNameState state = (CharacterNameState) evt.getNewValue();
        if (state.getNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getNameError());
        }
        if (evt.getNewValue() instanceof CharacterNameState) {
            CharacterNameState state2 = (CharacterNameState) evt.getNewValue();

            JPanel buttons2 = new JPanel();
            for (String className: state2.names) {
                JButton classAdd = new JButton(className);
                buttons2.add(classAdd);
            }
            buttons2.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (!this.nameChoicesAdded){
                this.add(buttons2, 1);
            }
            this.nameChoicesAdded = true;
            revalidate();
            repaint();
        }

    }
}