package view;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.background.BackgroundController;
import interface_adapter.background.BackgroundState;
import interface_adapter.background.BackgroundViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseBackgroundView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Background";
    private final BackgroundViewModel backgroundViewModel;
    private final CharacterCreatorController characterCreatorController;
    private final BackgroundController backgroundController;
    private boolean backgroundChoicesAdded = false;
    public ChooseBackgroundView(CharacterCreatorController characterCreatorController, BackgroundViewModel backgroundViewModel) {
        this.characterCreatorController = characterCreatorController;
        this.backgroundViewModel = backgroundViewModel;
        this.backgroundController = back
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        backgroundViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Choose Background");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        final JButton mainScreen;
        JPanel buttons = new JPanel();
        mainScreen = new JButton(backgroundViewModel.MAIN_SCREEN_LABEL);
        buttons.add(mainScreen);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(buttons);

        mainScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainScreen)) {
                            BackgroundState currentState = backgroundViewModel.getState();
                            characterCreatorController.execute();
                        }
                    }
                }
        );
    }
//    TODO FINISH ACTIONPERFORMED
    public ChooseBackgroundView(BackgroundController backgroundController, BackgroundViewModel backgroundViewModel, CharacterCreatorController characterCreatorController) {
        this.backgroundController = backgroundController;
        this.backgroundViewModel = backgroundViewModel;
        this.characterCreatorController = characterCreatorController;
        backgroundViewModel.addPropertyChangeListener(this);

        backgroundController.execute();
    }
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "[NOT SURE WHAT TO PUT HERE YET]");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof BackgroundState) {
            BackgroundState state = (BackgroundState) evt.getNewValue();

            JPanel buttons2 = new JPanel();
            for (String backgroundName: state.backgrounds) {
                JButton backgroundAdd = new JButton(backgroundName);
                buttons2.add(backgroundAdd);
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
}
