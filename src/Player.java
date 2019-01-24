public class Player {
    //fields
    private int health;
    private int gold;
    private int damage;
    private String playerType;
    private String entranceText;

    // constructor for easier initialization of Player objects;
    // random player type method implemented per Jon's example.
    public Player(int h, int g, int d){
        RandomGenerator generator = new RandomGenerator();
        int playerRand = generator.randInt(1,2);

        switch(playerRand){
            case 1:
                playerType = "Thief";
                health = GameConstants.THIEF_INITAL_HEALTH;
                damage = GameConstants.THIEF_DAMAGE;
                entranceText =
                        "As a drunk thief, you awake after a long night of drinking.\n" +
                        "It is time for the daily usual; stealing and running from the witty to stay afloat.";
                break;
            case 2:
                playerType = "Warrior";
                health = GameConstants.WARRIOR_INITAL_HEALTH;
                damage = GameConstants.WARRIOR_DAMAGE;
                entranceText =
                        "You awake startled. It appears you have lost your battle last night.\n" +
                        "As a warrior your instincts kick in, you sense a dangerous presence and smell GOLD.";
                break;
        }
        /* Not sure if switch or below will be better for creating multiple objects of the same class / type.
        this.health = h;
        this.gold = g;
        this.damage = d;
        */
    }
    // getter (accessor method)
    public String getEntranceText() {
        return entranceText;
    }
}
