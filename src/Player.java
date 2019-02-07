public class Player {
    //fields
    private int health;
    private int gold;
    private int damage;
    private String playerType;
    private String entranceText;
    private boolean defeated = false;
    private int initialHealth;
    private Point2d position;
    private double lootModifier;

    // constructor for easier initialization of Player objects;
    // receives player input to choose type
    public Player(String playerClassChoice){
        int playerClassNum;
        //player chooses t for thief or w for warrior
        if (playerClassChoice.equalsIgnoreCase("t")) {
            playerClassNum = 1;
        }
        else if(playerClassChoice.equalsIgnoreCase("w")){
            playerClassNum =2;
        } else { playerClassNum = 2; }

        switch(playerClassNum){
            case 1:
                playerType = "Thief";
                health = GameConstants.THIEF_INITIAL_HEALTH;
                initialHealth = GameConstants.THIEF_INITIAL_HEALTH;
                damage = GameConstants.THIEF_DAMAGE;
                lootModifier = GameConstants.THIEF_GOLD_MULTIPLIER;
                entranceText =
                        "You awake startled. As a drunk thief, you awake after a long night of drinking.\n" +
                        "It is time for the daily usual, scavenging cookies, stealing, and use of wit to stay afloat.";
                break;
            case 2:
                playerType = "Warrior";
                health = GameConstants.WARRIOR_INIITAL_HEALTH;
                initialHealth = GameConstants.WARRIOR_INIITAL_HEALTH;
                damage = GameConstants.WARRIOR_DAMAGE;
                lootModifier = GameConstants.WARRIOR_GOLD_MULTIPLIER;
                entranceText =
                        "You awake startled. It appears you have lost your battle with the Cookie Monster last night.\n" +
                        "Your senses pick something up; there is a dangerous presence and you can smell COOKIES?!";
                break;
        }
    }

    public Point2d getPosition(){
        return position;
    }

    public void setPosition(Point2d point){
        this.position = point;
    }

    // getter (accessor method)
    public String getEntranceText() {
        return entranceText;
    }

    //take health away from player
    public void onHit(int damage){
        health -= damage;
        if (health <= 0){
            defeated = true;
            health = 0;
        }
    }
    
    public void onHeal(int health) {
    	this.health += health;
    	if (this.health > initialHealth) {
    		this.health = initialHealth;
    	}
    }

    //player takes gold
    public void onLoot (int gold) {
        this.gold = this.gold + gold;
    }

    //outputs a boolean
    public boolean isAlive(){
        boolean aliveYes = true;
        if (health == 0){
            aliveYes = false;
        }
        return aliveYes;
    }

    //uses monsters onhit method to hit monster
    public void attack(Monster monster){
    int playerDamage = this.damage;
    monster.onHit(playerDamage);

    }

    //outputs player class
    public String getType(){ return playerType; }

    //outputs player damage
    public int getDamage(){ return damage; }

    public int getHealth(){ return health; }

    public int getGold(){ return gold; }

    public int getMaxHealth(){
        return initialHealth;
    }

    public double getLootModifier(){
        return lootModifier;
    }


}
