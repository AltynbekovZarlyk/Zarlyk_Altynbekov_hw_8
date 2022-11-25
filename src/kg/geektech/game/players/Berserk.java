package kg.geektech.game.players;

public class Berserk extends Hero {
    private int savedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int getDamageOfBerserk = boss.getDamage() + this.getDamage();
        System.out.println("Берсерк заблокировал удар: " + getDamageOfBerserk);
        boss.setHealth(boss.getHealth() - getDamageOfBerserk);
    }
}
