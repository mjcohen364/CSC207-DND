package view;
import interface_adapter.background.BackgroundController;
import interface_adapter.background.BackgroundState;
import interface_adapter.background.BackgroundViewModel;
import not_implemented.Background;
import view.ViewManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseBackgroundView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Background";
    private final BackgroundViewModel backgroundViewModel;
    private final BackgroundController backgroundController;
    final JButton mainScreen;
    public ChooseBackgroundView(BackgroundController backgroundController, BackgroundViewModel backgroundViewModel) {
        this.backgroundController = backgroundController;
        this.backgroundViewModel = backgroundViewModel;
        backgroundViewModel.addPropertyChangeListener(this);

        backgroundController.execute();
        JPanel buttons = new JPanel();
        mainScreen = new JButton(backgroundViewModel.MAIN_SCREEN_LABEL);
        buttons.add(mainScreen);

        mainScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainScreen)) {
                            BackgroundState currentState = backgroundViewModel.getState();
                            backgroundController.execute();
                        }
                    }
                }
        );
        this.add(buttons);
    }
//    FINISH ACTIONPERFORMED
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "[NOT SURE WHAT TO PUT HERE YET]");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof BackgroundState) {
            BackgroundState state = (BackgroundState) evt.getNewValue();

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
