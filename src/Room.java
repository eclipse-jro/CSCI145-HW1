import java.util.Scanner;

public class Room {
    private boolean visited = false;
    private Monster monster;
    private Treasure loot;

    //constructor: randomly creates a monster or loot object
    public Room(){ // 3 pass size into room
        RandomGenerator randGen = new RandomGenerator();

        int monsterOrLoot = randGen.randInt(1,2);
        switch(monsterOrLoot) {
            case 1:
                monster = new Monster();
                break;
            case 2:
                loot = new Treasure(); // 2 pass mult into treasure constructor
                break;
        }
    }

    public Room(int monsterOrLoot, int choice){
        switch(monsterOrLoot){
            case 1:
                loot = new Treasure(choice);
                break;
            case 2:
                monster = new Monster();
                break;
        }
    }

    //procedure when entering rooms
    public void enter(Player player, Scanner input){
        if(visited == false) {
            if(monster == null){
                System.out.println(loot.getFindText());

                if(loot.getType().equals("cookies")){
                    System.out.printf(loot.getTakeText(), (int)(loot.getQuantity() * player.getLootModifier()));
                    player.onLoot((int)(loot.getQuantity() * player.getLootModifier()));
                }
                else{
                    System.out.printf(loot.getTakeText(), loot.getQuantity());
                    player.onHeal(loot.getQuantity());
                }
                System.out.println();
            }
        }
        else{
        	System.out.println("You have already visited this room...");
        }


    }
    
    private void battle(Player player, Monster monster, Scanner input) {
    	String choice;
    	
    	while(player.isAlive() && !monster.isDefeated()) {
    		
    		System.out.println();
    		//might use these prompts in a separate class, 
    		//that contains the map and printout of player status (perhaps shows enemy health)
    		System.out.println("What you you like to do?");
    		System.out.print("(A)ttack or (R)un?: ");
    		
    		choice = input.nextLine();
    		
    		if(choice.equalsIgnoreCase("a")) {
    			System.out.println();
    			monster.attack(player);
    			if(player.isAlive()) {
        			player.attack(monster);
        			System.out.printf("The %s hits the %s for %d damage!", player.getType(), monster.getType(), player.getDamage());
        			System.out.println();
    			}
    		}
    		else if(choice.equalsIgnoreCase("r")) {
                System.out.println();
    			monster.attack(player);

    			if(player.isAlive()) {
    				System.out.println(monster.getEscapeText());
    				System.out.println();
    				 break;
    			}
    		}
    		else {
    			System.out.println("Please enter either A or R.");
                System.out.println();
    		}  
    	}
    	
    	if(player.isAlive() == false) {
    	    System.out.println();
			System.out.println("You're cookie has crumbled...");
    	}
    	else if(monster.isDefeated()) {
    	    System.out.println();
    		System.out.println(monster.getDeathText());
            System.out.println();
    	}
    }

    public boolean hasVisited(){
        return visited;
    }

    public boolean hasMonster(){
        if (monster == null){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isMonsterDefeated(){
        if (monster.isDefeated()){
            return true;
        }
        else{
            return false;
        }
    }

    public void initiateCombat(Player player, Scanner input) {
        if (hasMonster()) {
            if (hasVisited() && !isMonsterDefeated()) {
                System.out.println("It appears the " + monster.getType() + " has been waiting for you!");
                System.out.println();
                battle(player, monster, input);
            } else {
                System.out.println(monster.getEntranceText());
                System.out.println();
                battle(player, monster, input);
            }
        }
        visited = true;
    }
}
