package view;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.desc.DescController;
import interface_adapter.desc.DescState;
import interface_adapter.desc.DescViewModel;
import interface_adapter.inventory.InventoryState;
import interface_adapter.race.RaceState;
import interface_adapter.race.RaceViewModel;
import not_implemented.Race;
import view.ViewManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseRaceView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Race";
    private final RaceViewModel raceViewModel;
    private final DescController descController;
    private final DescViewModel descViewModel;
    private final CharacterCreatorController characterCreatorController;
    private boolean raceChoicesAdded = false;
    final JButton mainScreen;
    private JLabel description;
    public ChooseRaceView(DescController descController, DescViewModel descViewModel,
                          CharacterCreatorController characterCreatorController, RaceViewModel raceViewModel) {
        this.characterCreatorController = characterCreatorController;
        this.raceViewModel = raceViewModel;
        this.descController = descController;
        this.descViewModel = descViewModel;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        raceViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Choose Race");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        description = new JLabel();
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        mainScreen = new JButton(RaceViewModel.MAIN_SCREEN_LABEL);
        buttons.add(mainScreen);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(buttons);
        this.add(description);

        mainScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainScreen)) {
                            RaceState currentState = raceViewModel.getState();
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
        if (evt.getNewValue() instanceof DescState) {
            DescState state = (DescState) evt.getNewValue();
            description.setText(state.desc);
            revalidate();
            repaint();

        }
        if (evt.getNewValue() instanceof RaceState) {
            RaceState state = (RaceState) evt.getNewValue();
            JPanel buttons2 = new JPanel();
            for (String raceName: state.races) {
                JButton raceAdd = new JButton(raceName);
                buttons2.add(raceAdd);
                raceAdd.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                descController.execute("api/races/" + raceName.toLowerCase());
                            }
                        }
                );
            }
            buttons2.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (!this.raceChoicesAdded){
                this.add(buttons2, 1);
            }
            this.raceChoicesAdded = true;
            revalidate();
            repaint();
        }
    }
}