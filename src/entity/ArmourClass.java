package entity;
public class ArmourClass {
    private int baseArmourClass;
    private int bonus;
    private String specialProperties;

    public ArmourClass(int baseArmourClass, int bonus, String specialProperties) {
        this.baseArmourClass = baseArmourClass;
        this.bonus = bonus;
        this.specialProperties = specialProperties;
    }

    // Getters and setters
    public int getBaseArmourClass() {
        return baseArmourClass;
    }

    public void setBaseArmourClass(int baseArmourClass) {
        this.baseArmourClass = baseArmourClass;
    }

}

