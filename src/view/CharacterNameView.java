package view;

import interface_adapter.character_name.CharacterNameViewModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearState;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.character_name.CharacterNameController;
import interface_adapter.character_name.CharacterNameState;
import interface_adapter.character_name.CharacterNameViewModel;

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
    public final String viewName = "character name";

    private final CharacterNameViewModel characterNameViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final CharacterNameController characterNameController;
    private final ClearController clearController;
    private final ClearViewModel clearViewModel;

    private final JButton createCharacterName;
    private final JButton cancel;

    // TODO Note: this is the new JButton for clearing the users file
    private final JButton clear;

    public CharacterNameView(CharacterNameController characterNameController, CharacterNameViewModel characterNameViewModel, ClearController clearController, ClearViewModel clearViewModel) {

        this.characterNameController = characterNameController;
        this.characterNameViewModel = characterNameViewModel;
        this.clearController = clearController;
        this.clearViewModel = clearViewModel;
        characterNameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CharacterNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(CharacterNameViewModel.NAME_LABEL), nameInputField);

        JPanel buttons = new JPanel();
        createCharacterName = new JButton(CharacterNameViewModel.CREATECHARACTERNAME_BUTTON_LABEL);
        buttons.add(createCharacterName);
        cancel = new JButton(CharacterNameViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // TODO Note: the following line instantiates the "clear" button; it uses
        //      a CLEAR_BUTTON_LABEL constant which is defined in the CharacterNameViewModel class.
        //      You need to add this "clear" button to the "buttons" panel.
        clear = new JButton(CharacterNameViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);

        createCharacterName.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createCharacterName)) {
                            CharacterNameState currentState = characterNameViewModel.getState();

                            characterNameController.execute(
                                    currentState.getName()
                            );
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
                            Set usernames = currentState.getUsernames();
                            String message = String.join("\n", usernames);
                            JOptionPane.showMessageDialog(new JFrame("Message"), message);
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
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
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }

    }
}