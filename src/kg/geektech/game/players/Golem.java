package kg.geektech.game.players;

public class Golem extends Hero{
    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.ABSORPTION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int absorbedDamage = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0 && heroes[i].getHealth() > 0 && this != heroes[i]) {
                heroes[i].setHealth(heroes[i].getHealth() + 5);
                absorbedDamage = heroes.length * 5;
            }
        }
        System.out.println("Голем заблокировал следующее количество урона: " + absorbedDamage);
    }
}
