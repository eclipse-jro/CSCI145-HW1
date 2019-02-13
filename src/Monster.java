////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | Monster.java [description]
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Monster {
    //fields
    private int health;
    private int damage;
    private int initialHealth;
    private String monsterType;
    private String entranceText;
    private String deathText;
    private String escapeText;
    private boolean defeated = false;
    private double lootBooster = .9;

    //constructor: when Monster instance is created, will automatically and randomly choose type
    public Monster() {
        RandomGenerator generator = new RandomGenerator();
        int monsterSelect = generator.randInt(1, 4);

        switch(monsterSelect) {
            case 1:
                monsterType = "Goody Goblin";
                health = GameConstants.GOBLIN_INITIAL_HEALTH;
                damage = GameConstants.GOBLIN_MAX_DAMAGE;
                initialHealth = GameConstants.GOBLIN_INITIAL_HEALTH;
                entranceText =
                        "A goblin is searching for coookies.\n" +
                                "He hobbles towards you in an attempt to eliminate the competition!";
                escapeText = "The goblin cackles as you flee, quickly returning to finding more goodies";
                deathText = "The goblin comes to his death with a horrible shriek.";
                break;

            case 2:
                monsterType = "Fatboy Zombie";
                health = GameConstants.ZOMBIE_INITIAL_HEALTH;
                damage = GameConstants.ZOMBIE_MAX_DAMAGE;
                initialHealth = GameConstants.ZOMBIE_INITIAL_HEALTH;
                entranceText =
                        "A zombie is painfully rocking back in forth in the corner.\n" +
                                "He soon senses food and suddenly sprints towards you!";
                escapeText = "The zombie gnashes its teeth as his meal gets away.";
                deathText = "The zombie is returned to his natural, inanimate state";
                break;

            case 3:
                monsterType = "Oreorc";
                health = GameConstants.ORC_INITIAL_HEALTH;
                damage = GameConstants.ORC_MAX_DAMAGE;
                initialHealth = GameConstants.ORC_INITIAL_HEALTH;
                entranceText =
                        "An Oreorc is patrolling the dungeon.\n" +
                                "He spots you and charges at his next victim!";
                escapeText = "The orc lets out a cream-curdling roar, as you escape!";
                deathText = "The orc falls, breaking his cookie exterior.";
                
                break;

            case 4:
                monsterType = "Deneke";
                health = GameConstants.DENEKE_INITIAL_HEALTH;
                damage = GameConstants.DENEKE_MAX_DAMAGE;
                initialHealth = GameConstants.DENEKE_INITIAL_HEALTH;
                entranceText =
                        "A Deneke is standing still in the middle of the room.\n" +
                                "He is gluttonously eating a stash of cookies...\n" +
                                "and he DOESN'T WANT TO SHARE!";
                escapeText = "You run away, and the man quickly returns to his indulging.";
                deathText = "The man explodes...cookie dough cover the walls.";
                lootBooster = 0.6;
                break;
        }
    }
    
    public String getType() {
    	return monsterType;
    }

    public int getHealth() {
        return health;
    }

    public int getInitialHealth(){
        return initialHealth;
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

    public double getLootBooster(){
        return lootBooster;
    }
    
}