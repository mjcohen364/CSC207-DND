package view;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.race_desc.RaceDescController;
import interface_adapter.race_desc.RaceDescState;
import interface_adapter.race_desc.RaceDescViewModel;
import interface_adapter.race.RaceState;
import interface_adapter.race.RaceViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseRaceView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Race";
    private final RaceViewModel raceViewModel;
    private final RaceDescController raceDescController;
    private final RaceDescViewModel raceDescViewModel;
    private final CharacterCreatorController characterCreatorController;
    private boolean raceChoicesAdded = false;
    private boolean imageAdded = false;
    private JLabel imageLabel = new JLabel();
    private BufferedImage image;
    final JButton mainScreen;
    private JLabel description;

    ArrayList<JButton> raceButtons = new ArrayList<>();
    public ChooseRaceView(RaceDescController raceDescController, RaceDescViewModel raceDescViewModel,
                          CharacterCreatorController characterCreatorController, RaceViewModel raceViewModel) throws IOException {
        this.characterCreatorController = characterCreatorController;
        this.raceViewModel = raceViewModel;
        this.raceDescController = raceDescController;
        this.raceDescViewModel = raceDescViewModel;
        this.raceDescViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        try {
            this.image = ImageIO.read(new File("images/noneselected.png"));
            this.imageLabel = new JLabel(new ImageIcon(image));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        raceViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Choose Race");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        description = new JLabel("Click a race to view its description!");
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        mainScreen = new JButton(RaceViewModel.MAIN_SCREEN_LABEL);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(buttons);
        this.add(description);
        this.add(mainScreen);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainScreen.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        this.add(imageLabel, 1);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        revalidate();
        repaint();
    }
    //    TODO FINISH ACTIONPERFORMED
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "[NOT SURE WHAT TO PUT HERE YET]");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof RaceDescState) {
            RaceDescState state = (RaceDescState) evt.getNewValue();
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
                raceButtons.add(raceAdd);
                if (raceName.toLowerCase().equals(state.selected)) {
                    raceAdd.setBackground(Color.GREEN);
                }
                raceAdd.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                for (var butt: raceButtons) {
                                    butt.setBackground(UIManager.getColor("Panel.background"));
                                }
                                raceAdd.setBackground(Color.GREEN);
                                raceDescController.execute(raceName.toLowerCase());
                                try {
                                    image = ImageIO.read(new File("images/" + raceName.toLowerCase() + ".png"));
                                    imageLabel.setIcon(new ImageIcon(image));
                                    revalidate();
                                    repaint();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
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