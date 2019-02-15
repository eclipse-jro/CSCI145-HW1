////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | Room.java makes a room that will contain either treasure or a monster, and will
//          | have procedures for player entry, battle, looting, and memory of player visitation.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Room {
    private boolean visited = false;
    private Monster monster;
    private Treasure loot;

    //constructor: randomly creates a Monster or Treasure object
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
        //if never been to room before
        if(visited == false) {
            //and no monster, then loot
            if(monster == null){
                System.out.println(loot.getFindText());

                if(loot.getType().equals("cookies")){
                    //considers player and mapsize lootmodifiers in cookie looting
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
        //has visited before
        else{
        	System.out.println("You have already visited this room...");
        }


    }

    //battle sequence
    private void battle(Player player, Monster monster, Scanner input) {
    	String choice;

    	//continues loop until either monster or player is dead
    	while(player.isAlive() && !monster.isDefeated()) {

    	    //prompts user to run or fight
    		System.out.println("What you you like to do?");
    		System.out.print("(A)ttack or (R)un?: ");
    		choice = input.nextLine();

    		//commences attack sequence
    		if(choice.equalsIgnoreCase("a")) {
    			System.out.println();
    			//monster attacks first
    			monster.attack(player);
    			if(player.isAlive()) {
        			player.attack(monster);
        			System.out.printf("The %s hits the %s for %d damage! %n", player.getType(), monster.getType(), player.getDamage());
                    System.out.print("\n" + "HP: " + player.getHealth() + "\n");
                    System.out.println();
    			}
    		}
    		//escape/run sequence
    		else if(choice.equalsIgnoreCase("r")) {
                System.out.println();
                //monster attacks player first
    			monster.attack(player);

    			if(player.isAlive()) {
    				System.out.println(monster.getEscapeText());
    				System.out.println();
    				//breaks from battle loop
    				 break;
    			}
    		}
    		//if incorrect input is submitted
    		else {
    			System.out.println("Please enter either A or R.");
                System.out.println();
    		}  
    	}

    	//death scenario
    	if(player.isAlive() == false) {
    	    System.out.println();
			System.out.println("You're cookie has crumbled...");
    	}
    	//monster defeat sequence and kill loot acquisition
    	else if(monster.isDefeated()) {
    	    //creates new treasure based on monster's initial health
    	    Treasure deathLoot = new Treasure((int)(monster.getInitialHealth()* monster.getLootBooster()));
    	    System.out.println();

    		System.out.println(monster.getDeathText());
            System.out.println();

    		System.out.println(deathLoot.getKillFindText());

    		if(deathLoot.getType().equals("cookies")) {
                System.out.printf(deathLoot.getTakeText(), (int) (deathLoot.getQuantity() * player.getLootModifier()));
                player.onLoot((int)(deathLoot.getQuantity() * player.getLootModifier()));
                System.out.println();
                System.out.println();
            }else{
                System.out.printf(deathLoot.getTakeText(), deathLoot.getQuantity());
                player.onHeal(deathLoot.getQuantity());
                System.out.println();
                System.out.println();
            }
    	}
    }

    //checks visited field
    public boolean hasVisited(){
        return visited;
    }

    //checks if Monster field is instantiated
    public boolean hasMonster(){
        if (monster == null){
            return false;
        }
        else{
            return true;
        }
    }

    //checks if monster object is dead or not
    public boolean isMonsterDefeated(){
        if (monster.isDefeated()){
            return true;
        }
        else{
            return false;
        }
    }

    //displays appropriate text depending on encountered already, then starts battle
    public void initiateCombat(Player player, Scanner input) {
        if (hasMonster()) {
            if (hasVisited() && !isMonsterDefeated()) {
                System.out.println("It appears the " + monster.getType() + " has been waiting for you!");
                System.out.println();
                battle(player, monster, input);
            } else if(!hasVisited()) {
                System.out.println(monster.getEntranceText());
                System.out.println();
                battle(player, monster, input);
            }
        }
        visited = true;
    }
}
