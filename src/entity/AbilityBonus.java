package entity;

public class AbilityBonus {
    private AbilityScore abilityScore;
    private int bonus;

    public AbilityBonus(AbilityScore abilityScore, int bonus) {
        this.abilityScore = abilityScore;
        this.bonus = bonus;
    }

    public AbilityScore getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(AbilityScore abilityScore) {
        this.abilityScore = abilityScore;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}