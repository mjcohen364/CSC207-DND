package view;
import interface_adapter.back_desc.BackDescController;
import interface_adapter.back_desc.BackDescState;
import interface_adapter.back_desc.BackDescViewModel;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.background.BackgroundState;
import interface_adapter.background.BackgroundViewModel;
import interface_adapter.race_desc.RaceDescState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseBackgroundView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Background";
    private final BackgroundViewModel backgroundViewModel;
    private final BackDescController backDescController;
    private final BackDescViewModel backDescViewModel;
    private final CharacterCreatorController characterCreatorController;
    private boolean backgroundChoicesAdded = false;
    final JButton mainScreen;
    private JLabel description;
    public ChooseBackgroundView(BackDescController backDescController, BackDescViewModel backDescViewModel,
                                CharacterCreatorController characterCreatorController, BackgroundViewModel backgroundViewModel) {
        this.characterCreatorController = characterCreatorController;
        this.backgroundViewModel = backgroundViewModel;
        this.backDescController = backDescController;
        this.backDescViewModel = backDescViewModel;
        this.backDescViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        backgroundViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Choose Background");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        description = new JLabel("Click a background to view its description!");
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        mainScreen = new JButton(backgroundViewModel.MAIN_SCREEN_LABEL);
        buttons.add(mainScreen);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(buttons);
        this.add(description);

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
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "[NOT SURE WHAT TO PUT HERE YET]");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof BackDescState) {
            BackDescState state = (BackDescState) evt.getNewValue();
            description.setText(state.desc);
            revalidate();
            repaint();

        }
        if (evt.getNewValue() instanceof BackgroundState) {
            BackgroundState state = (BackgroundState) evt.getNewValue();

            JPanel buttons2 = new JPanel();
            for (String backgroundName: state.backgrounds) {
                JButton backgroundAdd = new JButton(backgroundName);
                buttons2.add(backgroundAdd);
                backgroundAdd.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                backDescController.execute(backgroundName.toLowerCase());
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
        }
    }
}
