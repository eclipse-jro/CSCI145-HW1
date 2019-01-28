public class Monster {
    //fields
    private int health;
    private int damage;
    private String monsterType;
    private String entranceText;
    private String deathText;
    private String escapeText;
    private boolean defeated = false;

    //constructor: when Monster instance is created, will automatically and randomly choose type
    public Monster() {
        RandomGenerator generator = new RandomGenerator();
        int monsterSelect = generator.randInt(1, 4);

        switch(monsterSelect) {
            case 1:
                monsterType = "Goblin";
                health = GameConstants.GOBLIN_INITIAL_HEALTH;
                damage = GameConstants.GOBLIN_MAX_DAMAGE;
                entranceText =
                        "A goblin is searching for gold.\n" +
                                "He hobbles towards you in an attempt to eliminate the competition!";
                escapeText = "The goblin cackles as you flee, quickly returning to finding more loot";
                deathText = "The goblin comes to his death with a horrible shriek.";
                break;

            case 2:
                monsterType = "Zombie";
                health = GameConstants.ZOMBIE_INITIAL_HEALTH;
                damage = GameConstants.ZOMBIE_MAX_DAMAGE;
                entranceText =
                        "A zombie is painfully rocking back in forth in the corner.\n" +
                                "He soon senses food and suddenly sprints towards you!";
                escapeText = "The zombie nashes its teeth as his meal gets away.";
                deathText = "The zombie is returned to his natural, inanimate state";
                break;

            case 3:
                monsterType = "Orc";
                health = GameConstants.ORC_INITIAL_HEALTH;
                damage = GameConstants.ORC_MAX_DAMAGE;
                entranceText =
                        "An orc is patrolling the dungeon.\n" +
                                "He spots you and charges at his next victim!";
                escapeText = "The orc lets out a blood curdling roar, as you escape!";
                deathText = "The orc falls, cracking the stone beneath him.";
                
                break;

            case 4:
                monsterType = "Deneke";
                health = GameConstants.DENEKE_INITIAL_HEALTH;
                damage = GameConstants.DENEKE_MAX_DAMAGE;
                entranceText =
                        "A man is standing still in the middle of the room.\n" +
                                "He smells your fear and with a swift motion rips off his skin!\n" +
                                "You've just encountered a Deneke. Steel yourself.";
                escapeText = "The horrible beast emits a high pitched shriek as you escape.";
                deathText = "The horrible Deneke dissolves into thousands of retreating spiders.";
                break;
        }
    }
    
    public String getType() {
    	return monsterType;
    }

    public int getHealth() {
        return health;
    }


    //damage taken will reduce monster's health
    public void onHit(int damage) {
        health -= damage;

    	if (health <= 0) {
        	defeated = true;
        	health = 0;
        }
    }

    //initiates an attack that directly hits the players health
    public void attack(Player player) {
        RandomGenerator generator = new RandomGenerator();
        int attackDamage = generator.randInt(1, damage);
        System.out.printf("The %s hits you for %d damage", this.getType(), attackDamage);
        System.out.println();
        player.onHit(attackDamage);
    }
    
    //checks if monster is dead
    public boolean isDefeated() {
    	return defeated;
    }
    
    public String getEntranceText() {
        return entranceText;
    }
    
    public String getEscapeText() {
        return escapeText;
    }
    
    public String getDeathText() {
    	return deathText;
    }
    
    public int getDamage() {
    	return damage;
    }
    
}