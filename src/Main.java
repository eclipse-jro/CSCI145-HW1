import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // kicks off game, intro text, receive class choice from user
    	DungeonGame game = new DungeonGame();
    	game.play();

    	//tests Treasure class
//    	Treasure treasure = new Treasure();
//    	System.out.println(treasure.getFindText());
//    	System.out.println(treasure.getTakeText());
//    	System.out.println(treasure.getType());
//    	System.out.println(treasure.getQuantity());

    	

        // player test 1; hp, gp, damage
//        Scanner userInput = new Scanner(System.in);

//        String playerClass = userInput.next();
//        Player playerTest = new Player(playerClass);

//		System.out.println(playerTest.getType());

        //monster test
//        TestMonster testmonster = new TestMonster();
//        testmonster.runTest();

        //room test
        //TestRoom testRoom = new TestRoom();
        //testRoom.run();
    }
}