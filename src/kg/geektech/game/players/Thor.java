package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{
    public static boolean Thor = false;
    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STUN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Thor = RPG_Game.random.nextBoolean();
        if (Thor) {
            boss.setDamage(0);
            System.out.println("Босс оглушён!!!");
        } else {
            boss.setDamage(150);
        }

    }
}
