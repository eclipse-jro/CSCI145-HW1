import java.util.Scanner;

public class DungeonGame {
    //private DungeonMap map;

    public void play(){
        Scanner input = new Scanner(System.in);
        Player player;
        String classChoice;

        printIntro();

        System.out.print("Choose your class, Warrior or Thief? (W/T): ");
        classChoice = input.next();
        player = new Player(classChoice);
        //map = new DungeonMap(player);

        System.out.println(player.getEntranceText());

        while(player.isAlive() //&& player.getGold < 100){
        ){
            printDivide();


        }
        if(player.isAlive()){
            System.out.println("You acquired 100 cookies! YOU WIN!");
        }
        else{
            System.out.println("GAME OVER!");
        }


    }

    private void printIntro(){
        System.out.println(" ________________________________________________________________________________");
        System.out.println("|    ___    __    __   _  _ ___  ____     ___    _    _  ____   _____  _______   |");
        System.out.println("|   /   \\  /  \\  /  \\  | /   |   |       /   \\   |    |  |     |    |     |      |");
        System.out.println("|  |      |    ||    | |/    |   |__    |     |  |    |  |___   \\___      |      |");
        System.out.println("|   \\   |  \\  /  \\  /  | \\   |   |       \\  \\/   |    |  |          |     |      |");
        System.out.println("|     --    --    --   '  '  ---  ---     -- \\    \\__/    ---- |____/     |      |");
        System.out.println("|________________________________________________________________________________|");

        System.out.println();

        System.out.println("One hero needs to collect 100 cookies to satisfy the evil King.");
        System.out.println("You are in the fabled Dungeon of Delights, to gather those cookies.");
        System.out.println("You are not alone in the dungeon...");
        System.out.println("In each room, you may find goodies, or one of the greedy inhabitants.");
        System.out.println("Don't let its inhabitants get you...");
        System.out.println();
    }

    public void printDivide(){
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
    }
}
