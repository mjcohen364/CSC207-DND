package use_case.armour_class;

public class ArmourClassInputData {
    private int baseArmourClass;
    private int additionalModifiers;

    public ArmourClassInputData(int baseArmourClass, int additionalModifiers) {
        this.baseArmourClass = baseArmourClass;
        this.additionalModifiers = additionalModifiers;
    }

    public int getBaseArmourClass() {
        return baseArmourClass;
    }

    public void setBaseArmourClass(int baseArmourClass) {
        this.baseArmourClass = baseArmourClass;
    }

    public int getAdditionalModifiers() {
        return additionalModifiers;
    }

    public void setAdditionalModifiers(int additionalModifiers) {
        this.additionalModifiers = additionalModifiers;
    }

}
