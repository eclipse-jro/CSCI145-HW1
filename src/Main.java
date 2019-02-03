import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	//tests Treasure class
//    	Treasure treasure = new Treasure();
//    	System.out.println(treasure.getFindText());
//    	System.out.println(treasure.getTakeText());
//    	System.out.println(treasure.getType());
//    	System.out.println(treasure.getQuantity());

    	
    	/*
        // player test 1; hp, gp, damage
//        Scanner userInput = new Scanner(System.in);
        
//        System.out.print("Welcome to the YetToBeNamedDungeonGame.\n");
//        System.out.println("Time to choose your class. You have two choices.\n");
//        System.out.println("Thief or Warrior?\n");
//        System.out.println("Thief: 70HP , 10DMG, 120%GOLD (Enter 't' to select)\n");
//        System.out.println("Warrior: 100HP, 15DMG, 100%GOLD (Enter 'w' to select)\n");
//        System.out.println("Time to choose your class. You have two choices.\n");
//        String playerClass = userInput.next();
//        Player player = new Player(playerClass);
        
//		System.out.println(player.getType());

        //monster test
//        TestMonster testmonster = new TestMonster();
//        testmonster.runTest();

        //room test
        TestRoom testRoom = new TestRoom();
        testRoom.run();
        */

    	//test dungeon
    	TestDungeonGame game = new TestDungeonGame();
    	game.run();
    }
}