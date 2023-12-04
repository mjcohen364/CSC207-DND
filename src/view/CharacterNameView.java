package view;

import interface_adapter.background.BackgroundState;
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

        JLabel welcome = new JLabel(CharacterNameViewModel);
        JLabel title = new JLabel(CharacterNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(CharacterNameViewModel.NAME_LABEL), nameInputField);

        JPanel buttons = new JPanel();
        JPanel prevNameButtons = new JPanel();
        //This button starts editing a new character (send to character creator view)
        createCharacterName = new JButton(CharacterNameViewModel.CREATECHARACTERNAME_BUTTON_LABEL);
        buttons.add(createCharacterName);

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

        editCharacter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(editCharacter)) {
                            CharacterNameState state2 = characterNameViewModel.getState();

                            for (Object name: state2.getNames()) {
                                System.out.println(name);
                                JButton nameAdd = new JButton(name.toString());
                                prevNameButtons.add(nameAdd);
                            }
                            prevNameButtons.setAlignmentX(Component.CENTER_ALIGNMENT);
                            if (!nameChoicesAdded){
                                add(prevNameButtons);
                            }
                            nameChoicesAdded = true;
                            revalidate();
                            repaint();
                            characterNameViewModel.firePropertyChanged();
                        }
                    }
                }
        );


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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CharacterNameState state = (CharacterNameState) evt.getNewValue();
        if (state.getNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getNameError());
        }
        if (e.getSource().equals(editCharacter)) {
            CharacterNameState state2 = characterNameViewModel.getState();

            for (Object name: state2.getNames()) {
                System.out.println(name);
                JButton nameAdd = new JButton(name.toString());
                prevNameButtons.add(nameAdd);
            }
            prevNameButtons.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (!nameChoicesAdded){
                add(prevNameButtons);
            }
            nameChoicesAdded = true;
            revalidate();
            repaint();
            characterNameViewModel.firePropertyChanged();
        }
        if (evt.getNewValue() instanceof CharacterNameState) {
            CharacterNameState state = (CharacterNameState) evt.getNewValue();

            JPanel buttons2 = new JPanel();
            for (String backgroundName: state.backgrounds) {
                JButton backgroundAdd = new JButton(backgroundName);
                buttons2.add(backgroundAdd);
                backgroundAdd.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                backDescController.execute();
                            }
                        }
                );
            }
            buttons2.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (!this.backgroundChoicesAdded){
                this.add(buttons2, 1);
            }
            this.backgroundChoicesAdded = true;
            revalidate();
            repaint();
            JPanel buttons = new JPanel();
            for (String backgroundName: state.backgrounds) {
                JButton backgroundAdd = new JButton(backgroundName);
                buttons.add(backgroundAdd);
            }
            this.add(buttons);
            revalidate();
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}