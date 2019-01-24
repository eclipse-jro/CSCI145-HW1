public class Monster {
    //fields
    private int health;
    private int damage;
    private String monsterType;
    private String entranceText;

    //constructor: when Monster instance is created, will automatically and randomly choose type
    public Monster() {
        RandomGenerator generator = new RandomGenerator();
        int monsterSelect = generator.randInt(1, 4);

        switch(monsterSelect) {
            case 1:
                monsterType = "Goblin";
                health = 6;
                damage = 10;
                entranceText =
                        "A goblin is searching for gold.\n" +
                                "He hobbles towards you in an attempt to eliminate the competition!";
                break;

            case 2:
                monsterType = "Zombie";
                health = 12;
                damage = 15;
                entranceText =
                        "A zombie is painfully rocking back in forth in the corner.\n" +
                                "He soon senses food and suddenly sprints towards you!";
                break;

            case 3:
                monsterType = "Orc";
                health = 18;
                damage = 20;
                entranceText =
                        "An orc is patrolling the dungeon.\n" +
                                "He spots you and with brute force, springs into action!";
                break;

            case 4:
                monsterType = "Deneke";
                health = 55;
                damage = 5;
                entranceText =
                        "A man is standing still in the middle of the room.\n" +
                                "He smells your fear and with a swift motion rips off his skin!\n" +
                                "You've just encountered a Deneke. Steel yourself.";
                break;
        }
    }

    public int getHealth() {
        return health;
    }

    public String getEntranceText() {
        return entranceText;
    }

    //damage taken will reduce monster's health
    public void onHit(int damage) {
        health -= damage;
    }

    //instructions say to include target player in parameters
    //not sure what this means yet
    public int attack() {
        RandomGenerator generator = new RandomGenerator();
        int attackDamage = generator.randInt(0, damage);
        return attackDamage;
    }
}

}