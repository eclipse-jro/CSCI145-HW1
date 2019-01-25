import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        // player test 1; hp, gp, damage
        Player p1 = new Player(3, 6, 9);

        //monster test 2
        Scanner input = new Scanner(System.in);
        int damageDealt;
        int damageTaken = -1;
        
        Monster testMonster = new Monster();
        System.out.println(testMonster.getEntranceText());
        System.out.println();
        while(testMonster.isDefeated() == false && damageTaken != 0) {
        	damageDealt = testMonster.attack(); 
        	System.out.println("The " + testMonster.getType() + " attacks you for "
        					+ damageDealt + " damage!");
        	System.out.print("How much damage do you deal?: ");
        	damageTaken = input.nextInt();
        	if (damageTaken != 0) {
        		testMonster.onHit(damageTaken);
        		System.out.println("The " + testMonster.getType() +
        				" has " + testMonster.getHealth() + " health.");
        	}
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