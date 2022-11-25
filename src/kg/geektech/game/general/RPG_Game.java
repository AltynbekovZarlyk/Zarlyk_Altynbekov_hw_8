package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Usama");
        Warrior warrior = new Warrior(290, 10, "Artur");
        Medic doc = new Medic(250, 5, 15, "Zarlyk");
        Magic magic = new Magic(280, 15, "Merlin");
        Berserk berserk = new Berserk(270, 10, "Gats");
        Medic assistant = new Medic(270, 5, 5, "Strange");
        Golem golem = new Golem(1000, 5, "Misha");
        Thor thor = new Thor(240, 15, "Beka");
        Witcher witcher = new Witcher(400, 0, "Witcher");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, golem, thor, witcher};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }
    private static void playRound(Boss boss, Hero[] heroes) {
        if (!Thor.Thor) boss.setDamage(50);
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }
    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
