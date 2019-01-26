
public class Room {
    private boolean visited = false;
    private Monster monster;
    private Treasure loot;

    //constructor: randomly creates a monster or loot object
    public Room(){
        RandomGenerator randGen = new RandomGenerator();

        int monsterOrLoot = randGen.randInt(1,2);
        switch(monsterOrLoot) {
            case 1:
                monster = new Monster();
                break;
            case 2:
                loot = new Treasure();
                break;
        }
    }

    //procedure when entering rooms
    public void enter(Player player){
        if(visited == false) {
            visited = true;
            if(monster == null){
                System.out.println(loot.getFindText());
                System.out.println(loot.getTakeText());
                System.out.println();
                if(loot.getType() == "gold"){
                    //player.onLoot(loot.getQuantity());  once method is created, will provide player with loot
                }
                else{
                    //player.onHeal(loot.getQuantity());  once method is created, will provide player with loot
                }
            }
            else{
                System.out.println(monster.getEntranceText());
                System.out.println();

            }
        }
        else{
            System.out.println("You have already visited this room...");
            if(!monster.isDefeated()){
                System.out.println("It appears the " + monster.getType() + " has been waiting for you!");
                //attack sequence continues here
            }
        }


    }

    public boolean hasVisited(){
        return visited;
    }


}
