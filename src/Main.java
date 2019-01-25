import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	/* tests Treasure class
    	Treasure treasure = new Treasure();
    	System.out.println(treasure.getFindText());
    	System.out.println(treasure.getTakeText());
    	System.out.println(treasure.getType());
    	System.out.println(treasure.getQuantity());
    	*/
    	
        // player test 1; hp, gp, damage
        Player p1 = new Player(3, 6, 9);

        //monster test 2
        Scanner input = new Scanner(System.in);
        int damageDealt;
        int damageTaken = -1;
        
        //creates an monster object and prints out entrance text
        Monster testMonster = new Monster();
        
        System.out.println(testMonster.getEntranceText());
        System.out.println();
        
        //loops mock battle until monster has 0 health, or player 'runs' by entering 0 damage
        while(testMonster.isDefeated() == false && damageTaken != 0) {
        	
        	//test monsters random attack damage output
        	damageDealt = testMonster.attack(); 
        	System.out.println("The " + testMonster.getType() + " attacks you for "
        					+ damageDealt + " damage!");
        	
        	//user prompts how much damage to deal, to test monster's health reduction
        	System.out.print("How much damage do you deal?: ");
        	damageTaken = input.nextInt();
        	if (damageTaken != 0) {
        		testMonster.onHit(damageTaken);
        		System.out.println("The " + testMonster.getType() +
        				" has " + testMonster.getHealth() + " health.");
        	}
        	//temporary condition to test escape features
        	else {
        		System.out.println("You run away!");
        	}
        	
        }
        if(testMonster.isDefeated()) {
        	System.out.println(testMonster.getDeathText());
        }
        else {
        	System.out.println(testMonster.getEscapeText());
        }
        
    }
}