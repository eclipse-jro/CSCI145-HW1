import java.util.Scanner;

public class TestMonster {
    public void runTest(){
        Scanner input = new Scanner(System.in);
        int damage;

        //creates an monster object and prints out entrance text
        Monster testMonster = new Monster();
        Player testPlayer = new Player("t");
        
        
        testMonster.attack(testPlayer);
        testPlayer.attack(testMonster);
        
        
    }
}