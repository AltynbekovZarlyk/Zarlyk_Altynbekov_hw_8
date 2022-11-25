package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.RESURRECTION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0 && heroes[i].getHealth() == 0 && this != heroes[i]) {
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("Ведьмак отдал свою жизнь, оживив " + heroes[i].getName());
                break;
            }
        }

    }
}
