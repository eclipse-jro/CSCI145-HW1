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


        //monster test
        //TestMonster testmonster = new TestMonster();
        //testmonster.runTest();

        //room test
        TestRoom testRoom = new TestRoom();
        testRoom.runTest(p1);
    }
}