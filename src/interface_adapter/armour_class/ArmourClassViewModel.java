package interface_adapter.armour_class;

public class ArmourClassViewModel {
    private int totalArmourClass;

    // Observable pattern methods or property change support
    // ...

    public int getTotalArmourClass() {
        return totalArmourClass;
    }

    public void setTotalArmourClass(int totalArmourClass) {
        this.totalArmourClass = totalArmourClass;
        // Notify observers of the change
    }
}
