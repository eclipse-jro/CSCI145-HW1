import java.util.Scanner;

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
    public void enter(Player player, Scanner input){
        if(visited == false) {
            visited = true;
            if(monster == null){
                System.out.println(loot.getFindText());
                System.out.println(loot.getTakeText());
                System.out.println();
                if(loot.getType().equals("cookies")){
                    player.onLoot(loot.getQuantity());  
                }
                else{
                    player.onHeal(loot.getQuantity());  
                }
            }
            else{
                System.out.println(monster.getEntranceText());
                System.out.println();
                battle(player, monster, input);
            }
        }
        else{
        	System.out.println("You have already visited this room...");
        	if(monster != null) {
        		if(!monster.isDefeated()){
                System.out.println("It appears the " + monster.getType() + " has been waiting for you!");
                battle(player, monster, input);
                //attack sequence continues here
        		}
            }
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
    			monster.attack(player);
    			if(player.isAlive()) {
    				System.out.println(monster.getEscapeText());
    				System.out.println();
    				 break;
    			}
    		}
    		else {
    			System.out.println("Please enter either A or R.");
    		}  
    	}
    	
    	if(player.isAlive() == false) {
			System.out.println("You're cookie has crumbled...");
    	}
    	else if(monster.isDefeated()) {
    		System.out.println(monster.getDeathText());
    	}
    }

    public boolean hasVisited(){
        return visited;
    }


}
